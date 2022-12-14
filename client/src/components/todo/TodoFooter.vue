<template>
  <div class="todoFooter" >
    <button @click="deleteTodo">delete todo</button>
  <p>{{doneCnt}}/{{todos.length}} success</p>
  </div>
</template>

<script>
export default {
  name: 'TodoFooter',
  props: ["todos"],
  computed: {
    doneCnt() {
      return this.todos.filter((pick) => {
        return pick.done == true;
      }).length
    }

  },
  methods: {
    deleteTodo() {
      let arr = this.todos.filter(pick => {
        return pick.done == false;
      })
      //부모한테 전달
      this.$emit('deleteTodo', arr);  
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

button{
  margin-top: 10px;
  border: 2px solid grey;
  border-radius: 5px;
  font-weight: bold;
}

button:hover{
  color: blue;
}

p{
  margin-top: 5px;
  font-weight: bold;
}
</style>
