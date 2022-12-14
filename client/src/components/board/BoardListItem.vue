<template>
  <tr class="border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-300">
    <td class="py-4 px-6">{{ article.idx }}</td>
    <td class="py-4 px-6" >

      <b-link
        :to="{
          name: 'boardview',
          params: { code: article.code, id: article.id },
        }"
      >

      {{ article.title }}
    </b-link>
    
         
    </td>
    <td class="py-4 px-6">{{ article.writer }}</td>
    <td class="py-4 px-6">{{ article.registerTime }}</td>
  </tr>
</template>

<script>
import moment from "moment";
export default {
  name: "BoardListItem",
  props: {
    article: Object,
  },
  data() {
    return {
      idx: 0,
    };
  },
  filters: {
    dateFormat(reg_datetime) {
      return moment(new Date(reg_datetime)).format("YY.MM.DD");
    },
  },
};
</script>

<style >


</style>
