<template>
    <section class="todoapp">
        <!-- header -->
        <header class="header">
            <input class="new-todo" autocomplete="off" placeholder="Todo List" @keyup.enter="addTodo">
        </header>
        <!-- main section v-show="todos.length" -->
        <section  class="main">
            <input id="toggle-all" :checked="allChecked" class="toggle-all" type="checkbox">
            <label for="toggle-all" />
            <ul class="todo-list">
                <todo v-for="(todo, index) in filteredTodos" :key="index" :todo="todo" @toggleTodo="toggleTodo"
                    @editTodo="editTodo" @deleteTodo="deleteTodo" />
            </ul>
        </section>
        <!-- footer -->
        <footer v-show="todos.length" class="footer">
            <span class="todo-count">
                <strong>{{ remaining }}</strong>
                item left
            </span>
            <ul class="filters">
                <li v-for="(val, key) in filters" :key="key">
                    <a :class="{ selected: visibility === key }" @click="visibility = key">{{ key }}</a>
                </li>
            </ul>
            <button class="clear-completed" v-show="todos.length > remaining" @click="clearCompleted">
          Clear completed
        </button>
        </footer>
    </section>
</template>
  
<script setup>
import { computed, reactive, ref, toRaw } from 'vue';
import Todo from './TODO.vue'
import { listTodolist, getTodolist, delTodolist, addTodolist, updateTodolist } from "@/api/system/todolist";
import { ElMessage} from 'element-plus'
const { proxy } = getCurrentInstance();

let complete = ref([])
let visibility = ref('all')
let total = ref()
let loading = ref(false)
let todos = ref([])
let todoss = reactive([{}])
const idss = ref([]);


onMounted(() => {
    getList();
})
const filters = {
    all: todos => todos,
    active: todos => todos.filter(todo => !todo.done),
    completed: todos => todos.filter(todo => todo.done)
}
const filteredTodos = computed(() => {
    return filters[visibility.value](todos.value)
})
const allChecked = computed(() => {
    return todos.value.every(todo => todo.done)
},)
const remaining = computed(() => {
    return todos.value.filter(todo => !todo.done).length
})
function getList() {
    loading = true;
    listTodolist().then(response => {
        console.log(response.rows);
        todos.value = response.rows;
        total.value = response.total;
    });
}
function addTodo(e) {
    const text = e.target.value

    let list = {
        text,
        done: false
    }
    addTodolist(list).then(response => {
        proxy.$modal.msgSuccess("新增成功");
        getList();
    });

    e.target.value = ''
}
function toggleTodo(val) {
    val.done = !val.done
    updateTodolist(val).then(response => {
        proxy.$modal.msgSuccess("修改成功");
        getList();
    });
}
function deleteTodo(todo) {
    const ids = todo.id;
    proxy.$modal.confirm('是否确认删除"' + todo.text + '"事项？').then(function () {
        return delTodolist(ids);
    }).then(() => {
        getList();
        proxy.$modal.msgSuccess("删除成功");
    }).catch(() => { });
}
function editTodo({ todo, value }) {
    todo.text = value
    updateTodolist(todo).then(response => {
        proxy.$modal.msgSuccess("修改成功");
        getList();
    });
}
function clearCompleted() {
    complete.value = todos.value.filter(item => item.done);
    idss.value = complete.value.map(item => item.id);        
    console.log(idss);
    proxy.$modal.confirm('是否确认删除记事本已完成事项？').then(function () {
        return delTodolist(idss.value);
    }).then(() => {
        getList();
        proxy.$modal.msgSuccess("删除成功");
    }).catch(() => { });

    
}

</script>
  
<style lang="scss">
@import './index.scss';
</style>
  