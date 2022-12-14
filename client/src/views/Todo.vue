


<template>
  <div class="todo">
    <h1>Todo List</h1>
		<hr>
    <div>
      <todo-header></todo-header>
      <!-- 이렇게 처리 -->
      <todo-input @addTodo="addTodo"></todo-input>
      <!-- 하위로 내려보내줄거야! 자식으로! -->
      <todo-list :todos="todos"></todo-list>
      <!-- 건수 보이게 할려고 푸터로 보내줘! -->
      <todo-footer   @deleteTodo="deleteTodo" :todos="todos"></todo-footer>
    </div>
  </div>
</template>

<script>
import TodoHeader from '../components/todo/TodoHeader.vue'
import TodoFooter from '../components/todo/TodoFooter.vue'
import TodoInput from '../components/todo/TodoInput.vue'
import TodoList from '../components/todo/TodoList.vue'

export default {
  name: "TodoView", // 필수는 아님
  components: {

    TodoHeader,
    TodoFooter,
    TodoInput,
    TodoList

  }, //나는 자식들을 가지고있어!

  data() {
    return {
    todos:[],
  }
},

  methods: {
    addTodo(item) {
      this.todos.push(item);
      console.log(item)
    },
    deleteTodo(item) {
      this.todos = item;
    }
  }
}
</script>
<style scoped>
.todo{

}
h1 {
  
	font-size: 30px;
	font-weight: bold;

}
</style>