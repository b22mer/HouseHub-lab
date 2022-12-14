<script>
import AppBanner from "@/components/shared/AppBanner";
//import ProjectsGrid from '../components/projects/ProjectsGrid.vue';
import Button from "../components/reusable/Button.vue";
import LandCardView from "@/components/land/LandCardView.vue";
import http from "@/api/http.js";

export default {
  name: "Home",
  components: {
    AppBanner,
    //ProjectsGrid,
    Button,
    LandCardView,
  },
  data() {
    return {
      newsList: [],
    };
  },
  created() {
    http.get("land/news").then(({ data }) => {
      this.newsList = data.body;
    });
  },
};
</script>

<template>
  <div class="container mx-auto">
    <!-- Banner -->
    <AppBanner class="mb-5 sm:mb-8" />

    <!-- Projects -->
    <!-- <ProjectsGrid /> -->

    <!-- Load more projects button -->
    <div class="mt-10 sm:mt-20 flex justify-center mb-8">
      <router-link
        to="/Regist"
        class="
          font-general-medium
          flex
          items-center
          px-6
          py-3
          rounded-lg
          shadow-lg
          hover:shadow-xl
          bg-indigo-900
          hover:bg-indigo-600
          focus:ring-1 focus:ring-indigo-900
          text-white text-lg
          sm:text-xl
          duration-300
        "
        aria-label="More Projects"
      >
        <Button title="Start Service" />
      </router-link>
    </div>
    <div style="background-color: grey"   class="font-bold bg-indigo-800 w-72 mb-1">
      <div style="color:white">오늘의 주요 부동산 뉴스</div>
    </div>
        <b-card
      bg-variant="secondary"
      text-variant="white"
      title="Today's news"
    >
      <b-card-text>
      Check out the latest real estate news. It will help you.
      </b-card-text>
    </b-card>
    <div id="newsbox" class="grid grid-rows-4 grid-flow-col gap-3">
      <land-card-view
        v-for="(news, index) in newsList"
        :key="index"
        :news="news"
      ></land-card-view>
    </div>
  </div>
</template>

<style scoped>
#btn {
  text-decoration: none;
  
}

#newsbox{
border: 1px solid lightgray;
border-radius: 5px;
padding: 10px;

}

</style>
