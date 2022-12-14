<template>
  <div class="todoList">
  <div v-for="(item, index) in todos" :key="index">
    <input id="chkbox" type="checkbox" v-model="item.done"> <span :class="{donestyle:item.done}" >{{item.text}}</span>
  
  
  </div>
  </div>
</template>

<script>
export default {
  name: 'TodoList',
  props: ["todos"],
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.donestyle{
  text-decoration: line-through;
  color: gray;
}

#chkbox{
  font-weight: bold;
}
</style>
