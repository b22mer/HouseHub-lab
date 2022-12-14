import { login } from "@/api/userApi.js";

const userStore = {
    namespaced: true,
    state: {
        isLogin: false,
        userInfo: null,
    },
    getters: {},
    mutations: {
        SET_IS_LOGIN: (state, isLogin) => {
            state.isLogin = isLogin;
        },
    },
    actions: {
        async userConfirm({ commit }, user) {
            await login(
                user,
                ({ data }) => {
                    console.log(data.accessToken);
                    commit("SET_IS_LOGIN", true);
                },
                error => {
                    console.log(error);
                }
            );
        },
    },
};

export default userStore;
