<template>
    <div>
        <li v-for="todo in todos">
            {{ todo.text }}
        </li>
    </div>
</template>

<script setup>

import { computed, reactive, ref } from 'vue';
import Todo from './TODO.vue'
import { listTodolist, getTodolist, delTodolist, addTodolist, updateTodolist } from "@/api/system/todolist";
let todos = ref([])
onMounted(() => {
    
    getList();
})
function getList() {
    listTodolist().then(response => {
        console.log(response.rows);
        todos.value = response.rows;
        console.log(todos);
    });
}
</script>