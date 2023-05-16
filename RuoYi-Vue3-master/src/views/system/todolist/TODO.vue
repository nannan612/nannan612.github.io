<template>
    <li :class="{ completed: todo.done, editing: editing }" class="todo">
      <div class="view">
        <input
          class="toggle"
          type="checkbox"
          :checked="todo.done"
          @change="toggleTodo"
        />
        <label @dblclick="editing = true">{{
          todo.text
        }}</label>
        <button class="destroy" @click="deleteTodo"></button>
      </div>
      <input
        class="edit"
        type="text"
        ref="editInput"
        v-if="editing"
        :value="todo.text"
        @blur="doneEdit"
        @keyup.enter="doneEdit"
        @keyup.esc="cancelEdit"
        v-focus="editing"

      />
    </li>
  </template>
  
  <script>
  import { ref, watchEffect } from 'vue'
  
  export default {
    props: {
      todo: Object
    },
    
    setup(props, { emit }) {
      const editing = ref(false)
      const editInputRef = ref(null)
  
      function deleteTodo() {
        emit('delete-todo', props.todo)
      }
  
      function toggleTodo() {
        emit('toggle-todo', props.todo);
      }
  
      function doneEdit(e) {
        const value = e.target.value.trim();
        const { todo } = props;
  
        if (!value) {
          deleteTodo(props.todo);
        } else if (editing.value) {
          emit('edit-todo', { todo: props.todo, value });
          editing.value = false;
        }
      }
  
      function cancelEdit() {
        editInputRef.value.value = props.todo.text;
        editing.value = false;
      }
  
      watchEffect(() => {
        if (editing.value) {
          editInputRef.value?.focus();
        }
      })
  
      return { editing, editInputRef, deleteTodo, toggleTodo, doneEdit, cancelEdit }
    }
  };
  </script>