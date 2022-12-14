<template>
  <div class="regist">
    <b-card
      bg-variant="secondary"
      text-variant="white"
      title="Check the Board Detail"
    >
      <b-card-text> Take a look at other people's opinions. </b-card-text>
    </b-card>
    <table
      style="padding-top: 50px"
      align="center"
      width="1000px"
      border="0"
      cellpadding="1"
    >
      <tr>
        <td height="20" align="center" bgcolor="#ccc">
          <font color="white">write the board</font>
        </td>
      </tr>
      <tr>
        <td bgcolor="white">
          <table class="table2">
            <tr>
              <td class="py-3">Writer</td>
              <td class="py-3">
                <div
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                  type="text"
                  id="userid"
                  
                  ref="writer"
                >{{ article.writer }}</div>
              </td>
            </tr>

            <tr>
              <td class="py-3">Title</td>
              <td>
                <div
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                  type="text"
                  id="subject"
                  ref="title"  
                >{{ article.title }}</div>
              </td>
            </tr>

            <tr>
              <td class="py-3">Date</td>
              <td>
                <div
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                  type="text"
                  id="date"
               
                  ref="date"
                >{{ article.registerTime }}</div>
              </td>
            </tr>

            <tr>
              <td class="py-3">Content</td>
              <td>
                <div 

                  id="content"
                  ref="content"
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                >{{ article.content }}</div>
              </td>
            </tr>
          </table>
          
            <div id="select" style="padding-top: 15px">
        <router-link
          v-if="isOwn"
          :to="{ name: 'boardmodify', params: { code: article.code } }"
          class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-500 hover:bg-indigo-600 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
          id="select-btn"
        >
          수정
        </router-link>
        <router-link
          v-if="isOwn"
          :to="{ name: 'boarddelete', params: { code: article.code } }"
          class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-500 hover:bg-indigo-600 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
          id="select-btn"
        >
          삭제
        </router-link>
        <router-link
          :to="{ name: 'boardlist' }"
          class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-800 hover:bg-indigo-700 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500 "
          id="select-btn"
        >
          List
        </router-link>
      </div>
          
        </td>
      </tr>
    </table>
    <!-- <div class="regist_form">
      <label class="label-name"> number</label>
      <div class="view">{{ article.articleNo }}</div>
      <label class="label-name"> title</label>
      <div class="view">{{ article.title }}</div>
      <label class="label-name"> writer</label>
      <div class="view">{{ article.writer }}</div>
      <label class="label-name"> date</label>
      <div class="view">{{ article.registerTime }}</div>
      <label class="label-name"> content</label>
      <div class="view">{{ article.content }}</div>
      <div id="select" style="padding-top: 15px">
        <router-link
          v-if="isOwn"
          :to="{ name: 'boardmodify', params: { code: article.code } }"
          class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-500 hover:bg-indigo-600 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
          id="select-btn"
        >
          수정
        </router-link>
        <router-link
          v-if="isOwn"
          :to="{ name: 'boarddelete', params: { code: article.code } }"
          class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-500 hover:bg-indigo-600 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
          id="select-btn"
        >
          삭제
        </router-link>
        <router-link
          :to="{ name: 'boardlist' }"
          class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-500 hover:bg-indigo-600 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
          id="select-btn"
        >
          목록
        </router-link>
      </div>
    </div> -->
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardView",
  beforeCreate() {
    console.log("created");
    if (sessionStorage.getItem("access-token") == null) {
      this.$router.push("/");
    }
  },
  data() {
    return {
      isOwn: "",
      article: {},
    };
  },
  created() {
    console.log("before create");
    let userInfo = this.$store.getters.userInfoGetter;
    console.log(userInfo);
    if (userInfo.user.admin == 1) {
      this.isOwn = true;
    } else {
      if (userInfo.user.id == this.$route.params.id) {
        this.isOwn = true;
      } else {
        this.isOwn = false;
      }
    }

    http
      .post(`board/detail`, null, {
        params: { code: this.$route.params.code },
      })
      .then(({ data }) => {
        console.log("상세보기 요청했어요!");
        console.log(data);
        this.article = data.body;
      });
  },
};
</script>

<style>
.regist :not(p) {
}

table.table2 {
  border-collapse: separate;
  border-spacing: 1px;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  margin: 20px 10px;
}
table.table2 tr {
  width: 50px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}
table.table2 td {
  width: 100px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}

.regist {
  width: 1000px;
  margin-left: auto;
  margin-right: auto;
}
.regist_form {
  border: 2px solid black;
  border-radius: 5px;

  width: 500px;
  height: 600px;
  padding: 10px;
  margin: auto;
}
.label-name {
  font-size: 20px;
  font-weight: bold;
}
.view {
  margin-top: 10px;
  border: 1px solid black;
  border-radius: 5px;
  height: 40px;
}

#select-btn {
  margin: 3px;
  font-weight: bold;
}
#select {
  margin-top: 50px;
}

#content{
  width: 800px;
  height: 200px;
}


</style>
