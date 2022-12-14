<template>
  <div class="todoInput">
  <input id="job-input" v-model="job" placeholder=" Enter To Do..." @keyup.enter="addTodo">
  </div>
</template>

<script>


export default {
  name: 'TodoInput',
  // 컴포넌트들은 데이터를 표현할때 function으로 사용
  data() {
    return {
      job: "",
    }
  },
  methods: {
    addTodo() {
      
      //호출할 이벤트 이름
      let item = { done: false, text: this.job }
      this.job = "";
      
      //부모한테 전달
      this.$emit('addTodo', item);   
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

#job-input{
  margin-top: 10px;
  border: 2px solid black;
  border-radius: 5px;
}
</style>
