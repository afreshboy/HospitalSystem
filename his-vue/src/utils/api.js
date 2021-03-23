import axios from 'axios'
import './plugins/element.js'
import router from './router'
import store from './store'

axios.defaults.baseURL="http://localhost:8081";
//前置拦截
axios.interceptors.request.use(config=>{

    return config
})
//后置拦截
axios.interceptors.response.use(response=>{
    let res=response.data
    console.log("=================")
    console.log(res)
    console.log("=================")
    if(res.code=200){
        return response
    }else {
        Element.Message.error('用户名或密码输入错误',{duration : 3*1000})
        return Promise.reject(response.data.msg)
    }


},error=>{
    console.log(error)
    if(error.response.data){
        error.message=error.response.data.msg
    }
    if(error.response.status==401){
        store.commit("REMOVE_INFO")
        router.push("/Login")
    }
    Element.Message.error('用户名或密码输入错误',{duration : 3*1000})
    return Promise.reject(error)
})



