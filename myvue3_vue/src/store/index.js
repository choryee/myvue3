import { createStore } from 'vuex'

export default createStore({

    state() {
        return {
            user : {}
        }
    },

    mutations: {
        setUser(state, value) { //위 state의 데이타를 관리하기 위한 함수setUser()
            state.user = value;
        }
    }
})