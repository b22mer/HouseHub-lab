<template>
  <div class="deal">
<div><img src="../assets/images/banner_dealinfo1.png" style="margin-left:18%;width: 300px;"></div>

    <router-view></router-view>

  </div>
</template>

<script>

export default {
  name: "BoardView", 
  components: {

  }, 

  data() {


  },
}

</script>
<style scoped>
.deal{

margin-left: auto;
margin-right: auto;
}
</style>