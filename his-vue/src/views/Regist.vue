<template>
    <div>

        <el-main>
            <el-form :inline="true" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="挂号信息" prop="info">
                </el-form-item>
                <el-row>
                    <el-form-item label="姓名" prop="name">
                        <el-input v-model="ruleForm.name" placeholder="请输入姓名" style="width: 150px"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="sex">
                    <el-select v-model="ruleForm.sex" placeholder="请选择性别" style="width: 150px">
                        <el-option label="男" value="男"></el-option>
                        <el-option label="女" value="女"></el-option>
                    </el-select>
                    </el-form-item>
                    <el-form-item label="病历号" prop="number">
                        <el-input v-model="ruleForm.number"  style="width: 150px"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="年龄" prop="age">
                        <el-input v-model="ruleForm.age" placeholder="请输入年龄" style="width: 150px"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄种类" prop="agetype">
                        <el-select v-model="ruleForm.agetype" placeholder="请选择年龄种类" style="width: 150px">
                            <el-option v-for="item in options"
                                       :key="item.value"
                                       :label="item.label"
                                       :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="生日" prop="birthday">
                        <el-date-picker
                                v-model="ruleForm.birthday"
                                type="date"
                                placeholder="选择日期"
                                style="width: 150px"
                        >
                        </el-date-picker>
                    </el-form-item>
                </el-row>
                <el-row>

                    <el-form-item label="身份证号" prop="ID">
                        <el-input v-model="ruleForm.ID" placeholder="请输入身份证号" style="width: 300px"></el-input>
                    </el-form-item>
                    <el-form-item label="家庭住址" prop="address">
                        <el-input v-model="ruleForm.address" placeholder="请输入家庭住址" style="width: 400px"></el-input>
                    </el-form-item>


                </el-row>
                <el-row>
                    <el-form-item label="号别" prop="relevel">
                        <el-select v-model="ruleForm.relevel" placeholder="请选择号别" style="width: 150px">
                            <el-option v-for="item in options2"
                                       :key="item.value"
                                       :label="item.label"
                                       :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="挂号科室" prop="depid">
                        <el-select v-model="ruleForm.depid" placeholder="请选择挂号科室" style="width: 150px">
                            <el-option v-for="item in options3"
                                       :key="item.value"
                                       :label="item.label"
                                       :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="挂号医生" prop="docid">
                        <el-select v-model="ruleForm.docid" placeholder="请选择挂号医生" style="width: 150px">
                            <el-option v-for="item in options4"
                                       :key="item.value"
                                       :label="item.label"
                                       :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="购买病历本" prop="book">
                        <el-switch v-model="ruleForm.book"></el-switch>
                    </el-form-item>
                    <el-form-item label="应收金额" prop="price">
                        <el-input v-model="ruleForm.price" placeholder="请输入应收金额" style="width: 150px"></el-input>
                    </el-form-item>
                </el-row>
                <el-form-item class="mybutton">
                    <el-button type="primary" @click="regist()">挂号</el-button>
                    <el-button @click="resetForm('ruleForm')">清空</el-button>
                </el-form-item>




            </el-form>
        </el-main>

    </div>
</template>

<script>
    export default {
        name: "Regist",
        data() {
            return {
                pickerOptions: {
                    disabledDate(time) {
                        return time.getTime() > Date.now();
                    },
                },
                ruleForm: {
                    name: '',
                    sex: '',
                    age: '',
                    agetype: '',
                    birthday: '',
                    ID: '',
                    address: '',
                    relevel: '',
                    depid: '',
                    docid: '',
                    price: '',
                    book:'false',
                    number:'',
                    reid:''

                },
                options: [{

                    label: '岁',
                    value: '岁'
                }, {
                    label: '月',
                    value: '月'
                }],
                options2: [{
                    label: '普通',
                    value: '普通'

                }, {
                    label: '专家',
                    value: '专家'

                }],
                options3: [{
                    label: '心血管内科',
                    value: '1'

                }, {
                    label: '神经内科',
                    value: '2'

                }],
                options4: [{
                    label: '王大锤',
                    value: '1'

                }, {
                    label: '王二锤',
                    value: '2'

                },
                    {
                        label: '王大雷',
                        value: '3'

                    },
                    {
                        label: '王二雷',
                        value: '4'

                    }],
                rules: {

                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],
                    sex: [
                        {required: true, message: '请输入性别', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],
                    age: [
                        {required: true, message: '请输入年龄', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],
                    agetype: [
                        {required: true, message: '请选择年龄种类', trigger: 'change'}
                    ],
                    birthday: [
                        {required: true, message: '请选择年龄种类', trigger: 'change'}
                    ],
                    ID: [
                        {required: true, message: '请输入身份证号', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],
                    address: [
                        {required: true, message: '请输入家庭住址', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],
                    relevel: [
                        {required: true, message: '请选择号别', trigger: 'change'}
                    ],
                    depid: [
                        {required: true, message: '请选择挂号科室', trigger: 'change'}
                    ],
                    docid: [
                        {required: true, message: '请选择挂号医生', trigger: 'change'}
                    ],
                    price: [
                        {required: true, message: '请输入应付金额', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],


                }
            };
        },
        methods: {
            regist() {
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        const _this=this;
                        let birth=this.ruleForm.birthday;
                        let birthtime=this.$moment(birth).format("YYYY-MM-DD");
                        console.log("birthday:"+this.ruleForm.birthday);
                        console.log("book:"+this.ruleForm.book);
                        console.log("docid:"+this.ruleForm.docid);
                        console.log("depid:"+this.ruleForm.depid);
                        console.log("birthtime:"+birthtime);
                        let postData = ({
                            man:this.ruleForm.ID,
                            name:this.ruleForm.name,
                            sex:this.ruleForm.sex,
                            birthday:birthtime,
                            age:this.ruleForm.age,
                            agetype:this.ruleForm.agetype,
                            address:this.ruleForm.address,
                            depid:this.ruleForm.depid,
                            docid:this.ruleForm.docid,
                            relevel:this.ruleForm.relevel,
                            book:this.ruleForm.book,
                             });
                        console.log(postData)
                        this.$axios.post('/regist', postData).then(resp => {
                            this.$message({type:'success',message:'挂号成功'});
                            this.ruleForm.number=resp.data.data.number;
                            console.log(resp.data.data)

                        })

                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            }
        }
    }
</script>

<style scoped>
    .mybutton {
        text-align: center;
        margin: 0 auto;
    }
</style>