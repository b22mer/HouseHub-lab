<template>
  <div>
    <a :href="`${news.newsUrl}`" target="_blank" style="text-decoration: none">
      <div
        style="
          border-bottom: 1px solid lightgrey;
          border-right: 1px solid lightgrey;
        "
        class="grid grid-rows-3 grid-flow-col gap-4 w-96 h-64 rounded-lg"
      >
        <div style="border-radius: 5px" class="row-span-3 col-span-4">
          <a :href="`${news.newsUrl}`" target="_blank"
            ><img
              width="100"
              height="100"
              :src="`${news.imgUrl}`"
              alt="{{news.imgUrl}}"
          /></a>
        </div>
        <div
          style="color: black; font-weight: bold; margin-top: 6px"
          class="col-span-2"
        >
          {{ news.title }}
        </div>
        <div
          style="
            color: black;
            font-size: 15px;
            margin-top: 3px;
            margin-right: 6px;
            border-left: 3px solid lightgrey;
          "
          class="row-span-2 col-span-2"
        >
          {{ news.preview }}...
        </div>
      </div>
    </a>
  </div>
</template>

<script>
export default {
  props: {
    news: Object,
  },
};
</script>

<style scoped>
</style>