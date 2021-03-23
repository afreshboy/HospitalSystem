<template>
    <div id="app">
        <el-container>
            <el-header>
                东软云医院

                <el-button type="primary" icon="el-icon-s-home" @click="logout()" class="tologin">

                </el-button>
            </el-header>
            <router-view>
            </router-view>

        </el-container>


    </div>
</template>
<script>
    export default {
        name: "App",
        data() {
            return {};
        },
        methods: {

            logout(){
                this.$store.commit("logout",'')
                this.$router.replace('/login')
                this.$message({type:'success',message:'登出成功'});

            }
        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #5ec1ff;
        color: #d3da89;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 400px;
    }

    .el-main {
        /*background-color: #E9EEF3;*/
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .tologin {
        margin-left: 0px;
    }

</style>
