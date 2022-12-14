import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:9999/",
    headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${window.sessionStorage.getItem("access-token")}`,
    },
    withCredentials: true,
});
