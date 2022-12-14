<template>
  <div class="w-full md:w-1/2">
    <div
      class="
        leading-loose
        max-w-xl
        m-4
        p-7
        bg-secondary-light
        dark:bg-secondary-dark
        rounded-xl
        shadow-xl
        text-left
      "
    >
      <p
        class="
          font-general-medium
          text-primary-dark
          dark:text-primary-light
          text-2xl
          mb-8
        "
      >
        User Regist
      </p>
      <!-- 회원가입 폼 시작 -->
      <form action="#" class="font-general-regular space-y-7">
        <!-- 이름 입력부분 -->
        <div>
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="name"
            >Full Name</label
          >
          <input
            v-model="member.name"
            class="
              w-full
              px-5
              py-2
              border border-gray-300
              dark:border-primary-dark
              border-opacity-50
              text-primary-dark
              dark:text-secondary-light
              bg-ternary-light
              dark:bg-ternary-dark
              rounded-md
              shadow-sm
              text-md
            "
            id="name"
            name="name"
            type="text"
            required=""
            placeholder="Your Name"
            aria-label="Name"
          />
        </div>

        <!-- 포지션 입력부분 -->
        <div>
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="position"
            >Position</label
          >
          <input
            v-model="member.position"
            class="
              w-full
              px-5
              py-2
              border border-gray-300
              dark:border-primary-dark
              border-opacity-50
              text-primary-dark
              dark:text-secondary-light
              bg-ternary-light
              dark:bg-ternary-dark
              rounded-md
              shadow-sm
              text-md
            "
            id=""
            name="position"
            type="text"
            required=""
            placeholder="Your position"
            aria-label="position"
          />
        </div>

        <!-- ID 입력부분 -->
        <div>
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="id"
            >ID</label
          >
          <input
            @change="checkId"
            v-model="member.id"
            class="
              w-full
              px-5
              py-2
              border border-gray-300
              dark:border-primary-dark
              border-opacity-50
              text-primary-dark
              dark:text-secondary-light
              bg-ternary-light
              dark:bg-ternary-dark
              rounded-md
              shadow-sm
              text-md
            "
            id=""
            name="id"
            type="text"
            required=""
            placeholder="Your ID"
            aria-label="id"
          />
          <span>{{ idchMsg }}</span>
        </div>

        <!-- 비밀번호 입력부분 -->
        <div>
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="password"
            >Password</label
          >
          <input
            v-model="member.pw"
            class="
              w-full
              px-5
              py-2
              border border-gray-300
              dark:border-primary-dark
              border-opacity-50
              text-primary-dark
              dark:text-secondary-light
              bg-ternary-light
              dark:bg-ternary-dark
              rounded-md
              shadow-sm
              text-md
            "
            id="password"
            name="password"
            type="password"
            required=""
            placeholder="Your Password"
            aria-label="password"
          />
        </div>

        <!-- 이메일 입력부분  -->
        <div>
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="email"
            >Email</label
          >
          <input
            v-model="member.email"
            class="
              w-full
              px-5
              py-2
              border border-gray-300
              dark:border-primary-dark
              border-opacity-50
              text-primary-dark
              dark:text-secondary-light
              bg-ternary-light
              dark:bg-ternary-dark
              rounded-md
              shadow-sm
              text-md
            "
            id="email"
            name="email"
            type="email"
            required=""
            placeholder="Your email"
            aria-label="email"
          />
        </div>

        <!-- 휴대폰 입력부분  -->
        <div>
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="phoneNumber"
            >Phone Number</label
          >
          <input
            v-model="member.phoneNumber"
            class="
              w-full
              px-5
              py-2
              border border-gray-300
              dark:border-primary-dark
              border-opacity-50
              text-primary-dark
              dark:text-secondary-light
              bg-ternary-light
              dark:bg-ternary-dark
              rounded-md
              shadow-sm
              text-md
            "
            id="phoneNumber"
            name="phoneNumber"
            type="tel"
            required=""
            placeholder="Your phoneNumber"
            aria-label="phoneNumber"
          />
        </div>

        <div>
          <button
            style="font-weight: bold;"
            @click.prevent
            @click="register"
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
            Join
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import http from "@/api/http.js";
export default {
  components: {},
  data() {
    // 사용될 데이터 정의
    return {
      idChOk: true,
      idchMsg: "",
      member: {
        name: "",
        position: "",
        id: "",
        pw: "",
        email: "",
        phoneNumber: "",
      },
    };
  },
  mounted() {},
  updated() {},
  // 메소드 연결 확인
  methods: {
    checkId() {
      http
        .post("user/idchck", null, { params: { id: this.member.id } })
        .then(({ data }) => {
          console.log(data.msg);
          this.idChOk = true;
          this.idchMsg = "id 생성 가능합니다";
        })
        .catch(() => {
          this.idChOk = false;
          this.idchMsg = "중복되는 id가 존재합니다";
        });
    },
    register() {
      console.log(this.idChOk);
      if (this.idChOk) {
        http.post(`/user/register`, null, { params: this.member }).then(() => {
          alert("회원가입 성공");
          this.$router.push("/");
        });
      } else {
        alert("id 중복을 확인해 주세요");
      }
    },
  },
};
</script>
<style lang="scss" scoped></style>
