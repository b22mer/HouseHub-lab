<template>
  <div class="regist">
    <h1>SSAFY 글 삭제</h1>
    <div>삭제중....</div>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardDelete",
  created() {
    console.log(this.$route.params.articleno);
    http
      .delete(`/board/delete?code=${this.$route.params.code}`)
      .then(({ data }) => {
        alert(data.msg);
        this.$router.push({ name: "boardlist" });
      })
      .catch(() => {
        alert("");
      });
  },
};
</script>

<style></style>
