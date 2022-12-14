<template>
  <div class="regist">
    <b-card
      bg-variant="secondary"
      text-variant="white"
      title="Modify the Board Detail"
    >
      <b-card-text> Please revise your writing. Only the author can modify the text.</b-card-text>
    </b-card>

    <table
      style="padding-top: 50px"
      align="center"
      width="1000"
      border="0"
      cellpadding="2"
    >
      <tr>
        <td height="20" align="center" bgcolor="#ccc">
          <font color="white">modify the board</font>
        </td>
      </tr>
      <tr>
        <td bgcolor="white">
          <table class="table2">
            <tr>
              <td class="py-3">Writer</td>
              <td class="py-3">
                <input
                  readonly
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                  type="text"
                  id="userid"
                  v-model="article.writer"
                  ref="writer"
                />
              </td>
            </tr>

            <tr>
              <td class="py-3">Title</td>
              <td>
                <input
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                  type="text"
                  id="subject"
                  v-model="article.title"
                  ref="title"
                />
              </td>
            </tr>

            <tr>
              <td class="py-3">Content</td>
              <td>
                <textarea
                  cols="85"
                  rows="15"
                  id="content"
                  v-model="article.content"
                  ref="content"
                  class="border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                ></textarea>
              </td>
            </tr>
          </table>

        </td>
      </tr>
    </table>
    <button
        id="modify-btn"
        @click="checkValue"
        class="
          px-4
          sm:px-6
          py-2
          sm:py-2.5
          text-white
          bg-indigo-800
          hover:bg-indigo-600
          rounded-md
          focus:ring-1 focus:ring-indigo-900
          duration-500
        "
      >
        Modify
      </button>
      <button
        id="modify-btn"
        @click="moveList"
        class="
          px-4
          sm:px-6
          py-2
          sm:py-2.5
          text-white
          bg-indigo-800
          hover:bg-indigo-600
          rounded-md
          focus:ring-1 focus:ring-indigo-900
          duration-500
        "
      >
        List
      </button>




<!-- 
    <div >
      <label class="label-name" for="writer">Author</label><br />
      <input
        readonly
        type="text"
        class="
          w-64
          px-5
          py-2
          border-1 border-gray-200
          dark:border-secondary-dark
          rounded-md
          text-md
          bg-secondary-light
          dark:bg-ternary-dark
          text-primary-dark
          dark:text-ternary-light
        "
        id="writer"
        v-model="article.writer"
        ref="writer"
      /><br />
      <br />
      <br />
      <br />
      <label class="label-name" for="title">Title</label><br />
      <input
        type="text"
        class="
          w-64
          px-5
          py-2
          border-1 border-gray-200
          dark:border-secondary-dark
          rounded-md
          text-md
          bg-secondary-light
          dark:bg-ternary-dark
          text-primary-dark
          dark:text-ternary-light
        "
        id="title"
        v-model="article.title"
        ref="title"
      /><br />
      <br />
      <br />
      <label class="label-name" for="content">Content</label>
      <br />
      <textarea
        id="content"
        class="
          w-64
          px-5
          py-2
          border-1 border-gray-200
          dark:border-secondary-dark
          rounded-md
          text-md
          bg-secondary-light
          dark:bg-ternary-dark
          text-primary-dark
          dark:text-ternary-light
        "
        v-model="article.content"
        ref="content"
        cols="35"
        rows="5"
      ></textarea
      ><br />
      <br />
      <br />
      <button
        id="modify-btn"
        @click="checkValue"
        class="
          px-4
          sm:px-6
          py-2
          sm:py-2.5
          text-white
          bg-indigo-500
          hover:bg-indigo-600
          rounded-md
          focus:ring-1 focus:ring-indigo-900
          duration-500
        "
      >
        수정
      </button>
      <button
        id="modify-btn"
        @click="moveList"
        class="
          px-4
          sm:px-6
          py-2
          sm:py-2.5
          text-white
          bg-indigo-500
          hover:bg-indigo-600
          rounded-md
          focus:ring-1 focus:ring-indigo-900
          duration-500
        "
      >
        목록
      </button>
    </div> -->
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardModify",
  beforeCreate() {
    console.log("created");
    if (sessionStorage.getItem("access-token") == null) {
      this.$router.push("/");
    }
  },
  data() {
    return {
      article: Object,
    };
  },

  created() {
    console.log("수정 입성!!!");
    http
      .post(`board/detail`, null, { params: { code: this.$route.params.code } })
      .then(({ data }) => {
        console.log(data);
        this.article = data.body;
        console.log(this.article.writer);
        console.log(this.article.content);
        console.log(this.article.title);
      });
  },
  methods: {
    checkValue() {
      let err = true;
      let msg = "";
      !this.article.writer &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
      err &&
        !this.article.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.article.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.modifyArticle();
    },
    modifyArticle() {
      console.log("글 수정 !");

      // 비동기
      // TODO : 글번호에 해당하는 글정보 수정.
      http
        .put(`board/update`, {
          code: this.$route.params.code,
          title: this.article.title,
          content: this.article.content,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data.msg === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.moveList();
        });
    },

    moveList() {
      console.log("글 목록!");
      this.$router.push({ name: "boardlist" });
    },
  },
};
</script>

<style>

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

.regist{
  width: 1000px;
  margin-left: auto;
  margin-right: auto;
  
}
#modify-btn {
  margin: 4px;
  font-weight: bold;
}
</style>
