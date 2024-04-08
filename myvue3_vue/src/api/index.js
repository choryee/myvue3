import axios from 'axios'
//import requestSystem from "@/constants/requestSystem.js"

export default axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    headers : {
        'Content-Type': 'application/json'
        // , 'requestSystem' : requestSystem.PORTAL_FRONT
        // , 'requestHostname' : requestSystem.PORTAL_FRONT
        , 'version' : "1.0"
    }
});