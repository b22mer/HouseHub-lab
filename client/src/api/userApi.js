import * as Api from "@/api/api.js";

async function login(user, success, fail) {
    await Api.post("/user/login", user).then(success).catch(fail);
}

export { login };
