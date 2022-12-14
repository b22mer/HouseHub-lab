import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";

const store = createStore({
    state() {
        return { userInfo: "userinfo" };
    },
    mutations: {
        GET_USER_INFO(state, user) {
            state.userInfo = user;
        },
    },
    getters: {
        userInfoGetter(state) {
            return state.userInfo;
        },
    },
    actions: {
        getUserInfo({ commit }, user) {
            commit("GET_USER_INFO", user);
        },
    },
    plugins: [
        createPersistedState({
            // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
            storage: sessionStorage,
        }),
    ],
});
export default store;
