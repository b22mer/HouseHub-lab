<template>
  <div class="deal">
	<div><img src="../assets/images/banner_dealinfo.png" style="margin-left:18%;width: 300px;"></div>
  <!-- <deal-select/>
  <deal-list/>
 -->
<!-- <deal-list/> -->
<div class="dealbox"><deal-map/></div>

<!-- <deal-select/> -->

  </div>
</template>

<script>
// import DealSelect from '../components/deal/DealSelect.vue'
import DealMap from '../components/deal/DealMap.vue'
//import DealList from '../components/deal/DealList.vue'
export default {
  name: "DealView", 
  components: {
    
    DealMap,
    // DealSelect
  //  DealList,
  }, 

  data() {


  },
}

</script>
<style scoped>
.dealbox{
  display: flex;
  justify-content: center;
}
</style>