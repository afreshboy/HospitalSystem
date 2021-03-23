import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        userinfo: window.localStorage.getItem('userinfo') == '' ? null : JSON.parse(window.localStorage.getItem('userinfo'))
    },
    mutations: {
        login(state, userinfo) {
            state.userinfo = userinfo
            window.localStorage.setItem('userinfo', JSON.stringify(userinfo))
        },
        logout(state, userinfo) {
            state.userinfo = ''
            window.localStorage.setItem('userinfo', JSON.stringify(userinfo))
        }

    },
    getters:{
        getUser:state=>{
            return state.userinfo;
        }
    },
    actions: {},
    modules: {}
})
