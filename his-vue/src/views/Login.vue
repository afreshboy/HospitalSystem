<template>
    <div>
        <el-container>

            <el-main>
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username">
                        <el-input type="text" v-model="ruleForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="ruleForm.password"></el-input>
                    </el-form-item>


                    <el-form-item>
                        <el-button type="primary" @click="loginto()">登陆</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
    </div>
</template>

<script>

    export default {
        name: "login.vue",
        data() {
            return {
                ruleForm: {
                    username: '',
                    password: '',

                },
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 0, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'change'},

                    ],

                }
            };
        },
        methods: {
            loginto() {
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        const _this=this;
                        console.log(this.ruleForm.username+'=======')
                        this.$axios.post('/login', this.ruleForm).then(resp => {
                            console.log(resp);
                            const userinfo=resp.data.data;
                            _this.$store.commit("login",userinfo);
                            if (resp) {
                                if(resp.data.data.position=="挂号员"){
                                    this.$router.replace("/register");
                                }
                                else if(resp.data.data.position=="医生"){
                                    this.$router.replace("/doctor");
                                }
                                else if(resp.data.data.position=="发药员"){
                                    this.$router.replace("/dispense");
                                }
                                this.$message({type:'success',message:'登陆成功'});
                            }
                            else{
                                this.$message({type:'error',message:'登陆失败'});
                            }
                        })
                    } else {
                        this.$router.replace("/login");
                    }
                });
            },
            submitForm(formName) {
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        alert('submit!');
                        this.$axios.post('http://localhost:8082/login', {username:this.ruleForm.username,password:this.ruleForm.password}).then(res => {
                            console.log(res.headers)
                            console.log(res)
                            this.$router.replace('/register')
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    .el-footer {
        background-color: #5ec1ff;
        color: #d3da89;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
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


    .demo-ruleForm {
        max-width: 500px;
        margin: 0 auto;
    }
</style>