<template>
  <div class="boardlist">
    <b-card
      bg-variant="secondary"
      text-variant="white"
      title="Client Notice Board"
    >
      <b-card-text>
        Feel free to write. If you have any questions, feel free to ask.
      </b-card-text>
    </b-card>

    <div v-if="articles.length">
      <table class="table mt-3">
        <thead
          class="
            text-xs text-gray-800
            uppercase
            bg-gray-300
            dark:bg-gray-700 dark:text-indigo-400
          "
        >
          <tr>
            <th scope="col" class="py-3 px-6" style="color: black">num</th>
            <th scope="col" class="py-3 px-6" style="color: black">title</th>
            <th scope="col" class="py-3 px-6" style="color: black">writer</th>
            <th scope="col" class="py-3 px-6" style="color: black">date</th>
          </tr>
        </thead>
        <tbody>
          <board-list-item
            v-for="article in articles"
            :key="article.articleNo"
            :article="article"
          ></board-list-item>
        </tbody>
      </table>
      <!-- <table class="">


        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" class="py-3 px-6" style="color:black;" >num</th>
            <th scope="col" class="py-3 px-6" style="color:black;" >title</th>
            <th scope="col" class="py-3 px-6" style="color:black;">writer</th>
            <th scope="col" class="py-3 px-6" style="color:black;" >date</th>
          </tr>
        </thead>
        <tbody>
          <board-list-item
            v-for="article in articles"
            :key="article.articleNo"
            :article="article"
          ></board-list-item>
        </tbody>
      </table> -->
    </div>

    <div id="board-list-empty" class="text-center" v-else>
      게시글이 없습니다.
    </div>
    <nav
      class="isolate inline-flex -space-x-px rounded-md shadow-sm"
      aria-label="Pagination"
    >
      <a
        v-for="index in maxPage"
        :key="index"
        href="#"
        @click="selectPage(index)"
        aria-current="page"
        :class="{
          'bg-indigo-50': selected == index,
          'border-indigo-500': selected == index,
        }"
        class="
          relative
          z-10
          inline-flex
          items-center
          border
          px-4
          py-2
          text-sm
          font-medium
          text-indigo-600
          focus:z-20
        "
        >{{ index }}</a
      >
    </nav>

    <div id="board-list-btn" style="text-align: center">
      <button
        id="board-list-btns"
        class="
          px-4
          sm:px-6
          py-2
          sm:py-2.5
          text-white
          bg-indigo-900
          hover:bg-indigo-600
          rounded-md
          focus:ring-1 focus:ring-indigo-900
          duration-500
        "
        @click="moveWrite"
      >
        Write
      </button>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
import BoardListItem from "@/components/board/BoardListItem";

export default {
  name: "BoardList",
  components: {
    BoardListItem,
  },
  beforeCreate() {
    console.log("created");
    if (sessionStorage.getItem("access-token") == null) {
      this.$router.push("/");
    }
  },
  data() {
    return {
      fields: ["글 번호", "작성자", "글 제목", "작성날짜"],
      articles: [],
      maxPage: 0,
      selected: 1,
      pageNum: 1,
      pageSize: 5,
      pageStart: 0,
    };
  },
  created() {
    //글 목록 가져오기
    http
      .post("board/selectall", {
        pageNum: this.pageNum,
        pageSize: this.pageSize,
      })
      .then(({ data }) => {
        this.maxPage = data.pages;
        console.log("글목록 가져온다!");
        console.log(data.list);
        let articleList = [...data.list];
        for (let index = 0; index < articleList.length; index++) {
          articleList[index]["idx"] = index + 1;
          let date = new Date(articleList[index].registerTime);
          articleList[index]["registerTime"] = date.toDateString();
        }
        console.log(articleList);
        this.articles = data.list;
      })
      .catch(({ response }) => {
        alert(response.data.errMsg);
      });
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "boardwrite" });
    },
    selectPage(index) {
      this.pageNum = index;
      this.selected = index;
      this.pageStart = index * this.pageSize - 4;

      http
        .post("board/selectall", {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        })
        .then(({ data }) => {
          this.maxPage = data.pages;
          console.log("글목록 가져온다!");
          console.log(data.list);
          let articleList = [...data.list];
          for (let index = 0; index < articleList.length; index++) {
            articleList[index]["idx"] = this.pageStart + index;
            let date = new Date(articleList[index].registerTime);
            articleList[index]["registerTime"] = date.toDateString();
          }
          console.log(articleList);
          this.articles = data.list;
        })
        .catch(({ response }) => {
          alert(response.data.errMsg);
        });
    },
  },
};
</script>

<style>
#boardlist-head {
}
.boardlist {
  width: 1000px;
  margin-left: auto;
  margin-right: auto;
  display: felx;
  justify-content: center;
  flex-direction: column;
  margin-top: 20px;
}
.board-list-header {
  font-weight: bold;
  font-size: 24px;
}
#board-list-empty {
  margin-top: 20px;
  font-weight: bold;
  color: grey;
}
#board-list-btn {
  margin-top: 30px;
  font-weight: bold;
}

#board-list-btns {
  font-weight: bold;
}

/* th {
  color: #ffff;
}

td {
  font-weight: bold;
} */
</style>
