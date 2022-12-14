<template>
  <transition name="fade">
    <div v-show="modal" class="font-general-regular fixed inset-0 z-30">
      <!-- Modal body background as backdrop -->
      <div
        v-show="modal"
        @click="showModal()"
        class="
          bg-filter bg-black bg-opacity-50
          fixed
          inset-0
          w-full
          h-full
          z-20
        "
      ></div>
      <!-- Modal content -->
      <main class="flex flex-col items-center justify-center h-full w-full">
        <transition name="fade-up-down">
          <div v-show="modal" class="modal-wrapper flex items-center z-30">
            <div
              class="
                modal
                max-w-md
                mx-5
                xl:max-w-xl
                lg:max-w-xl
                md:max-w-xl
                bg-secondary-light
                dark:bg-primary-dark
                max-h-screen
                shadow-lg
                flex-row
                rounded-lg
                relative
              "
            >
              <div
                class="
                  modal-header
                  flex
                  justify-between
                  gap-10
                  p-5
                  border-b border-ternary-light
                  dark:border-ternary-dark
                "
              >
                <!-- 상단 제목 -->
                <h5 class="text-primary-dark dark:text-primary-light text-xl">
                  Login Section
                </h5>

                <!-- 닫힘 버튼  -->
                <button
                  class="px-4 text-primary-dark dark:text-primary-light"
                  @click="showModal()"
                >
                  <i data-feather="x"></i>
                </button>
              </div>

              <img src="../assets/images/banner_login.png" style="width:230px;margin-left:20px;margin-top:20px">
              <div class="modal-body p-3 w-full h-full">
                <!-- 폼 시작 -->

                <form class="max-w-xl m-4 text-left">
                  <!-- (1115-1) id input수정 -->
                  <div class="mt-0">
                    <input
                      v-model="loginId"
                      class="
                        w-full
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
                      id="loginId"
                      name="name"
                      type="text"
                      required=""
                      placeholder="ID"
                      aria-label="ID"
                    />
                  </div>

                  <!-- (1115-1) password input수정 -->
                  <div class="mt-6">
                    <input
                      v-model="loginPw"
                      class="
                        w-full
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
                      id="loginPw"
                      name="loginPw"
                      type="password"
                      required=""
                      placeholder="Password"
                      aria-label="Password"
                    />
                  </div>

                  <!-- (1115-1) 로그인 버튼 수정 -->
                  <div class="mt-6 pb-4 sm:pb-1">
                    <button
                      style="font-weight: bold;"
                      @click.prevent
                      @click="userLogin"
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
                      Login
                    </button>
                    
                  </div>
                      <a style="font-weight:bold" class="button button--social-login button--facebook" href="#"><i class="icon fa fa-facebook"></i>Login With Facebook</a>
   
    <a  style="font-weight:bold" class="button button--social-login button--github" href="#"><i class="icon fa fa-github"></i>Login With Github</a>
                </form>
                <!-- 폼 끝 -->
              </div>
            </div>
          </div>
        </transition>
      </main>
    </div>
  </transition>
</template>

<script>
import feather from "feather-icons";
//import Button from "./reusable/Button.vue";
import http from "@/api/http.js";

export default {
  props: ["showModal", "modal", "categories"],
  components: {},
  data() {
    return {
      loginId: "",
      loginPw: "",
    };
  },
  mounted() {
    //feather.replace();
  },
  updated() {
    feather.replace();
  },
  methods: {
    async userLogin() {
      http
        .post("user/login", { id: this.loginId, pw: this.loginPw })
        .then(({ data }) => {
          console.log("access toke : ", data.body.accessToken);
          this.$store.dispatch("getUserInfo", { user: data.body.user });
          sessionStorage.setItem("access-token", data.body.accessToken);
          sessionStorage.setItem("loginRequired", true);
          this.showModal();
          window.document.location.reload();
        })
        .catch((e) => {
          console.log(e.message);
          alert("로그인 정보가 다릅니다");
        });
    },
  },
};
</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Roboto+Slab:400,700);
body {
  text-align: center;
  padding: 24px 24px 96px;
  font-family: 'Roboto Slab', serif;
}

h1, h2 {
  margin-bottom: 48px;
  font-weight: normal;
}

.button {
  width: auto;
  display: inline-block;
  padding: 0 18px 0 6px;
  border: 0 none;
  border-radius: 5px;
  text-decoration: none;
  transition: all 250ms linear;
}
.button:hover {
  text-decoration: none;
}

.button--social-login {
  margin-bottom: 12px;
  margin-right: 12px;
  color: white;
  height: 50px;
  line-height: 46px;
  position: relative;
  text-align: left;
}
.button--social-login .icon {
  margin-right: 12px;
  font-size: 24px;
  line-height: 24px;
  width: 42px;
  height: 24px;
  text-align: center;
  display: inline-block;
  position: relative;
  top: 4px;
}
.button--social-login .icon:before {
  display: inline-block;
  width: 40px;
}
.button--social-login .icon:after {
  content: "";
}

.button--bitbucket {
  background-color: #205081;
  border: 1px solid #163758;
}
.button--bitbucket .icon {
  border-right: 1px solid #163758;
}
.button--bitbucket .icon:after {
  border-right: 1px solid #2a69aa;
}
.button--bitbucket:hover {
  background-color: #1b436d;
}

.button--dropbox {
  background-color: #007DE1;
  border: 1px solid #0061ae;
}
.button--dropbox .icon {
  border-right: 1px solid #0061ae;
}
.button--dropbox .icon:after {
  border-right: 1px solid #1597ff;
}
.button--dropbox:hover {
  background-color: #006fc8;
}

.button--facebook {
  background-color: #4b70ab;
  border: 1px solid #3b5988;
}
.button--facebook .icon {
  border-right: 1px solid #3b5988;
}
.button--facebook .icon:after {
  border-right: 1px solid #6b8bbe;
}
.button--facebook:hover {
  background-color: #436499;
}

.button--flickr {
  background-color: #FF0084;
  border: 1px solid #cc006a;
}
.button--flickr .icon {
  border-right: 1px solid #cc006a;
}
.button--flickr .icon:after {
  border-right: 1px solid #ff339d;
}
.button--flickr:hover {
  background-color: #e60077;
}

.button--github {
  background-color: #333;
  border: 1px solid #1a1a1a;
}
.button--github .icon {
  border-right: 1px solid #1a1a1a;
}
.button--github .icon:after {
  border-right: 1px solid #4d4d4d;
}
.button--github:hover {
  background-color: #262626;
}

.button--google {
  background-color: #3F85F4;
  border: 1px solid #0f66f1;
}
.button--google .icon {
  border-right: 1px solid #0f66f1;
}
.button--google .icon:after {
  border-right: 1px solid #6fa4f7;
}
.button--google:hover {
  background-color: #2776f3;
}

.button--googleplus {
  background-color: #DD4B39;
  border: 1px solid #c23321;
}
.button--googleplus .icon {
  border-right: 1px solid #c23321;
}
.button--googleplus .icon:after {
  border-right: 1px solid #e47365;
}
.button--googleplus:hover {
  background-color: #d73925;
}

.button--linkedin {
  background-color: #0087be;
  border: 1px solid #00638b;
}
.button--linkedin .icon {
  border-right: 1px solid #00638b;
}
.button--linkedin .icon:after {
  border-right: 1px solid #00abf1;
}
.button--linkedin:hover {
  background-color: #0075a5;
}

.button--microsoft {
  background-color: #00A4EF;
  border: 1px solid #0081bc;
}
.button--microsoft .icon {
  border-right: 1px solid #0081bc;
}
.button--microsoft .icon:after {
  border-right: 1px solid #23baff;
}
.button--microsoft:hover {
  background-color: #0093d6;
}

.button--openid {
  background-color: #F78C40;
  border: 1px solid #f56f0f;
}
.button--openid .icon {
  border-right: 1px solid #f56f0f;
}
.button--openid .icon:after {
  border-right: 1px solid #f9a971;
}
.button--openid:hover {
  background-color: #f67d28;
}

.button--soundcloud {
  background-color: #FF5500;
  border: 1px solid #cc4400;
}
.button--soundcloud .icon {
  border-right: 1px solid #cc4400;
}
.button--soundcloud .icon:after {
  border-right: 1px solid #ff7733;
}
.button--soundcloud:hover {
  background-color: #e64d00;
}

.button--spotify {
  background-color: #2EBD59;
  border: 1px solid #249446;
}
.button--spotify .icon {
  border-right: 1px solid #249446;
}
.button--spotify .icon:after {
  border-right: 1px solid #4bd374;
}
.button--spotify:hover {
  background-color: #29a84f;
}

.button--twitter {
  background-color: #3B94D9;
  border: 1px solid #257abc;
}
.button--twitter .icon {
  border-right: 1px solid #257abc;
}
.button--twitter .icon:after {
  border-right: 1px solid #66abe1;
}
.button--twitter:hover {
  background-color: #2988d2;
}

.button--yahoo {
  background-color: #500095;
  border: 1px solid #350062;
}
.button--yahoo .icon {
  border-right: 1px solid #350062;
}
.button--yahoo .icon:after {
  border-right: 1px solid #6b00c8;
}
.button--yahoo:hover {
  background-color: #42007c;
}
</style>
