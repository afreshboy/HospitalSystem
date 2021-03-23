import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import axios from 'axios'
import moment from 'moment'
import "element-ui/lib/theme-chalk/index.css"
import { Message } from 'element-ui'
Vue.use(Message)
Vue.prototype.$message = Message

Vue.use(Element)

Vue.prototype.$moment=moment

 Vue.prototype.$axios = axios


Vue.config.productionTip = false
axios.defaults.withCredentials=false;
axios.defaults.baseURL="http://localhost:8081";

router.beforeEach((to,from,next) => {
    if (to.meta.requireAuth) {
        if (store.state.userinfo) {
            next()
        } else {
            next("/login")
        }
    }
    else{
        next()
    }
})

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')


