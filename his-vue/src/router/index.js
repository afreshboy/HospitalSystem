import Vue from 'vue';
import VueRouter from 'vue-router';
import Login from '../views/Login.vue';
import Registerclerk from "../views/Registerclerk";
import Regist from "../views/Regist";
import Return from "../views/Return";
import Charge from "../views/Charge";
import Refund from "../views/Refund";
import Invoice from "../views/Invoice";
import Doctor from "../views/Doctor";
import Dispense from "../views/Dispense";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'index',
        redirect: {
            name: "Login"
        },
        meta: {requireAuth: false}
    },
    {
        path: '/register',
        name: 'Register',
        component: Registerclerk,
        meta: {requireAuth: true},
        children: [{
            path: 'regist',
            component: Regist,
            name: 'Regist',
             meta: {requireAuth: true}
        },
            {
                path: 'return',
                component: Return,
                name: 'Return',
                 meta: {requireAuth: true}
            },
            {
                path: 'charge',
                component: Charge,
                name: 'Charge',
                 meta: {requireAuth: true}
            },
            {
                path: 'refund',
                component: Refund,
                name: 'Refund',
                 meta: {requireAuth: true}
            },
            {
                path: 'invoice',
                component: Invoice,
                name: 'Invoice',
                 meta: {requireAuth: true}
            }]

    },

    {
        path: '/login',
        name: 'Login',
        component: Login,
        meta: {requireAuth: false}
    },
    {
        path: '/doctor',
        name: 'Doctor',
        component: Doctor,
         meta: {requireAuth: true}
    },
    {
        path: '/dispense',
        name: 'Dispense',
        component: Dispense,
        meta: {requireAuth: true}
    }


]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
