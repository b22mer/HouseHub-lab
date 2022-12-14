<template>
  <div class="boardwrite">
    <b-card
      bg-variant="secondary"
      text-variant="white"
      title="Write Board Section"
    >
      <b-card-text>
        Write what you like! Please refrain from writing anything offensive to
        others!
      </b-card-text>
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
          <font color="white">write the board</font>
        </td>
      </tr>
      <tr>
        <td bgcolor="white">
          <table class="table2">
            <tr>
              <td class="py-3">Writer</td>
              <td class="py-3">
                <input
                  class="w-26 px-5 py-2 border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                  type="text"
                  id="userid"
                  v-model="writer"
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
                  v-model="title"
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
                  v-model="content"
                  ref="content"
                  class="border border-gray-300 dark:border-primary-dark border-opacity-50 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md"
                ></textarea>
              </td>
            </tr>
          </table>
          <center>
            <button
              id="board-write-btn"
              class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-900 hover:bg-indigo-700 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
              @click="checkValue"
            >
              Submit
            </button>
            <button
              id="board-write-btn"
              class="px-4 sm:px-6 py-2 sm:py-2.5 text-white bg-indigo-900 hover:bg-indigo-700 rounded-md focus:ring-1 focus:ring-indigo-900 duration-500"
              @click="moveList"
            >
              List
            </button>
          </center>
        </td>
      </tr>
    </table>

    <!-- <div class="regist_form">

      <div>Author <input
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
        type="text"
        id="userid"
        v-model="writer"
        ref="writer"
      /></div>



  
     
      <div>Title <input
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
        type="text"
        id="subject"
        v-model="title"
        ref="title"
      /></div>
      <label for="title">Title</label><br />
      <br />
      <br />
      <label for="content">Text</label>
      <br />
      <textarea
        class="
          w-96
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
        id="content"
        v-model="content"
        ref="content"
        cols="35"
        rows="5"
      ></textarea
      ><br />
      <br />
      <button
        id="board-write-btn"
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
        @click="checkValue"
      >
        글 등록
      </button>
      <button
        id="board-write-btn"
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
        @click="moveList"
      >
        글 목록
      </button>
    </div> -->
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardWrite",
  beforeCreate() {
    console.log("created");
    if (sessionStorage.getItem("access-token") == null) {
      this.$router.push("/");
    }
  },
  data() {
    return {
      writer: null,
      title: null,
      content: null,
    };
  },
  methods: {
    checkValue() {
      let err = true;
      let msg = "";
      !this.writer &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
      err &&
        !this.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.registArticle();
    },
    registArticle() {
      console.log("글 작성 !");
      let article = {
        writer: this.writer,
        title: this.title,
        content: this.content,
      };
      http
        .post("board/upload", article, { withCredentials: true })
        .then(({ data }) => {
          console.log(data);
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data.status === "success") msg = "글등록이 완료되었습니다.";
          alert(msg);
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

.board-write-header {
  font-weight: bold;
  font-size: 24px;
}

.regist_form {
  margin-top: 20px;
}

#board-write-btn {
  margin: 14px;
  font-weight: bold;
}

label {
  font-weight: bold;
}

.boardwrite {
  width: 1000px;
  margin-left: auto;
  margin-right: auto;
}
</style>
