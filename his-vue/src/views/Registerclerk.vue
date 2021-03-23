<template>
    <div>
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1']" unique-opened>
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>挂号收费</template>
                        <el-menu-item index="1-1" @click="goTo('/regist')">现场挂号</el-menu-item>
                        <el-menu-item index="1-2" @click="goTo('/return')">退号</el-menu-item>
                        <el-menu-item index="1-3" @click="goTo('/charge')">收费</el-menu-item>
                        <el-menu-item index="1-4" @click="goTo('/refund')">退费</el-menu-item>
                        <el-menu-item index="1-5" @click="goTo('/invoice')">发票补打</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <router-view></router-view>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Registerclerk",
        data() {
            return {};
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            goTo(path) {
                this.$router.replace("/register" + path);
            }
        }
    }
</script>

<style scoped>

</style>