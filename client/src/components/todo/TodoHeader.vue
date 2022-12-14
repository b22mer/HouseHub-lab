<template>
  <div class="todoHeader">
  <!-- 스타일의 이름을 지을때는 카멜케이스를 쓰는게 일반적 -->
<h1>Manage schedule</h1> 
  </div>
</template>

<script>
export default {
  name: 'TodoHeader', // 컴포넌트느느 다 파스칼 케이스를 사용한다.
  props: {
    msg: String
  }
}

</script>

<style scoped>

h1{
  font-size: 20px;
  color: grey;
}

</style>
