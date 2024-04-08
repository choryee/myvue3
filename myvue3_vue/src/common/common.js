import api from '@/api'
import axios from "axios";

const common={
    GET : function (URL){
        return new Promise((resolve, reject) => {
            api.get(URL)
                .then(res=>{
                    if(res){
                        //api.get(URL)이게 성공했을때, 그 결과(res)를 resolve함수에 넣기'만'하고, 그 역할로 끝이다.
                        //	resolve(res); 이걸 받는데서는, 이 반환타입이 Promise이므로, .then()이나 await를 붙여야.
                        resolve(res);
                    }else {
                        reject(res);
                    }
                })
                .catch(err=>new Error('에러남..'))
        })
    },

    POST : function (URL, params){
        return new Promise((resolve, reject)=>{
            api.post(URL, params)
                .then(res=>{
                    if(res.data){
                        resolve(res.data);
                    }else{
                        reject(res.data);
                    }
                })
                .catch(err=>new Error('에러남...'))
        })
    }
}

export default common;