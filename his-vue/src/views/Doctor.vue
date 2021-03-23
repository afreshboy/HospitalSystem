<template>
    <el-tabs type="border-card">

        <el-tab-pane label="门诊病历">
            <el-container style="height: 600px; border: 1px solid #eee">
                <el-aside width="300px" style="background-color: rgb(238, 241, 246)">
                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                        <el-form-item label="患者选择" prop="choose">
                        </el-form-item>
                        <el-tag>待诊病人</el-tag>
                        <el-table
                                :data="tableData"
                                highlight-current-row
                                @row-click="selectpatient"
                                style="width: 100%">
                            <el-table-column v-for="item in tablecolumns"
                                             :key="item.key"
                                             :prop="item.key"
                                             :label="item.label"
                                             :width="item.width"

                            >
                            </el-table-column>
                        </el-table>
                        <el-tag>已诊病人</el-tag>
                        <el-table
                                :data="tableData2"
                                highlight-current-row
                                @row-click="selectpatient"
                                style="width: 100%">
                            <el-table-column v-for="item in tablecolumns"
                                             :key="item.key"
                                             :prop="item.key"
                                             :label="item.label"
                                             :width="item.width"

                            >
                            </el-table-column>
                        </el-table>


                    </el-form>
                </el-aside>
                <el-main>
                    <el-tag> 当前患者 姓名:{{this.p_name}}    性别:{{this.p_sex}}     年龄:{{this.p_age}}    </el-tag>


                    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
                        <el-tab-pane label="诊断" name="first">
                            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                                     class="demo-ruleForm">
                                <el-tag>病史内容</el-tag>
                                <el-form-item label="主诉" prop="chiefcomplaint">
                                    <el-input v-model="ruleForm.chiefcomplaint" placeholder="请输入主诉"
                                              style="width:800px"></el-input>
                                </el-form-item>
                                <el-form-item label="现病史" prop="pih">
                                    <el-input v-model="ruleForm.pih" placeholder="请输入主诉" style="width:800px"></el-input>
                                </el-form-item>
                                <el-form-item label="既往史" prop="ph">
                                    <el-input v-model="ruleForm.ph" placeholder="请输入既往史" style="width:800px"></el-input>
                                </el-form-item>
                                <el-form-item label="过敏史" prop="ah">
                                    <el-input v-model="ruleForm.ah" placeholder="请输入过敏史" style="width:800px"></el-input>
                                </el-form-item>

                                <el-tag>诊断</el-tag>
                                <el-form-item label="诊断结果" prop="result">
                                    <el-input v-model="ruleForm.result" placeholder="请输入诊断结果"
                                              style="width:800px"></el-input>
                                </el-form-item>
                                <el-form-item class="mybutton">
                                    <el-button type="primary" @click="dialog()">确诊</el-button>
                                    <el-button @click="resetForm('ruleForm')">清空</el-button>
                                </el-form-item>


                            </el-form>
                        </el-tab-pane>
                        <el-tab-pane label="开药" name="second">
                            <el-row>
                                <el-button type="primary" @click="addpreVisible = true"
                                           icon="el-icon-circle-plus-outline">增方
                                </el-button>
                                <el-dialog
                                        title="处方详情"
                                        :visible.sync="addpreVisible"
                                        width="30%"
                                        :before-close="handleClose">
                                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                                             class="demo-ruleForm">
                                        <el-form-item label="处方名称" prop="prename">
                                            <el-input v-model="ruleForm.prename" placeholder="请输入处方名称"
                                                      style="width: 300px"></el-input>
                                        </el-form-item>

                                        <el-form-item>
                                            <el-button type="primary" @click="addprescription">确 定</el-button>
                                            <el-button @click="addpreVisible = false">取 消</el-button>
                                        </el-form-item>

                                    </el-form>


                                </el-dialog>

                                <el-button type="primary" @click="addmeVisible=true"
                                           icon="el-icon-circle-plus-outline">增药
                                </el-button>
                                <el-dialog
                                        title="药品详情"
                                        :visible.sync="addmeVisible"
                                        width="30%"
                                        :before-close="handleClose">
                                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                                             class="demo-ruleForm">
                                        <el-form-item label="药品id" prop="mid">
                                            <el-input v-model="ruleForm.mid" placeholder="请输入药品名称"
                                                      style="width: 300px"></el-input>
                                        </el-form-item>
                                        <el-form-item label="药品数量" prop="mcount">
                                            <el-input v-model="ruleForm.mcount" placeholder="请输入药品数量"
                                                      style="width: 300px"></el-input>
                                        </el-form-item>
                                        <el-form-item label="药品用量" prop="musage">
                                            <el-input v-model="ruleForm.musage" placeholder="请输入药品用量"
                                                      style="width: 300px"></el-input>
                                        </el-form-item>
                                        <el-form-item label="药品用法" prop="mway">
                                            <el-input v-model="ruleForm.mway" placeholder="请输入药品用法"
                                                      style="width: 300px"></el-input>
                                        </el-form-item>
                                        <el-form-item label="药品频次" prop="mfluency">
                                            <el-input v-model="ruleForm.mfluency" placeholder="请输入药品频次"
                                                      style="width: 300px"></el-input>
                                        </el-form-item>

                                        <el-form-item>
                                            <el-button type="primary" @click="addmedicine">确 定</el-button>
                                            <el-button @click="addmeVisible = false">取 消</el-button>
                                        </el-form-item>

                                    </el-form>


                                </el-dialog>

                            </el-row>
                            <el-row :gutter="20">
                                <el-col :span="6">
                                    <div class="grid-content bg-purple">
                                        <el-tag>门诊处方</el-tag>
                                        <el-table
                                                :data="tableData3"
                                                height="250"
                                                style="width: 100%"
                                                @row-click="selectprescription"
                                                highlight-current-row
                                        >
                                            <el-table-column label="处方id" key="preid" prop="preid" width="100">
                                            </el-table-column>
                                            <el-table-column label="处方名称" key="prename" prop="prename" width="100">
                                            </el-table-column>

                                        </el-table>

                                    </div>
                                </el-col>
                                <el-col :span="18">
                                    <div class="grid-content bg-purple">
                                        <el-row>
                                            <el-tag>本处方金额合计：</el-tag>
                                            <el-tag type="warning">{{this.preprice}}元</el-tag>
                                        </el-row>
                                        <el-table
                                                height="250"
                                                :data="tableData4"
                                                tooltip-effect="dark"
                                                style="width: 100%"
                                                >
                                            <el-table-column
                                                    v-for="item in tablecolumns2"
                                                    :key="item.key"
                                                    :prop="item.key"
                                                    :label="item.label"
                                                    :width="item.width"
                                                    :type="item.type"

                                            ></el-table-column>


                                        </el-table>
                                    </div>
                                </el-col>

                            </el-row>


                            <el-row :gutter="20">
                                <el-col :span="6">
                                    <div class="grid-content bg-purple">
                                        <el-row>
                                        <el-tag>处方模板</el-tag>
                                            <el-button type="primary" @click="usetemplate">使用</el-button>

                                        </el-row>
                                        <el-table
                                                :data="tableData5"
                                                height="250"
                                                style="width: 100%"
                                                @row-click="selecttemplate"
                                                highlight-current-row
                                        >
                                            <el-table-column label="处方模板id" key="pretid" prop="pretid" width="100">
                                            </el-table-column>

                                            <el-table-column label="处方模板名称" key="pretname" prop="pretname" width="100">
                                            </el-table-column>


                                        </el-table>
                                    </div>
                                </el-col>
                                <el-col :span="18">
                                    <div class="grid-content bg-purple">
                                        <el-tag>模板明细</el-tag>
                                        <el-table
                                                height="250"
                                                ref="multipleTable"
                                                :data="tableData6"
                                                tooltip-effect="dark"
                                                style="width: 100%">
                                            <el-table-column
                                                    v-for="item in tablecolumns2"
                                                    :key="item.key"
                                                    :prop="item.key"
                                                    :label="item.label"
                                                    :width="item.width"
                                                    :type="item.type"

                                            ></el-table-column>


                                        </el-table>

                                    </div>
                                </el-col>

                            </el-row>


                        </el-tab-pane>

                    </el-tabs>
                </el-main>
                <router-view></router-view>
            </el-container>


        </el-tab-pane>

    </el-tabs>
</template>

<script>


    export default {
        name: "Doctor",
        data() {
            return {
                preprice:null,
                pr_id:null,
                pr_name:null,
                tp_id:null,
                tp_name:null,
                p_name:null,
                p_sex:null,
                p_age:null,
                p_reid:null,
                p_number:null,

                radio: null,
                radio2: null, // 如果使用单选框，定义一个model值
                addpreVisible: false,
                addmeVisible: false,
                currentSelectItem: {},
                activeName: 'first',
                tablecolumns: [
                    {
                        key: 'number',
                        label: '病历号',
                        width: '100'
                    },
                    {
                        key: 'name',
                        label: '姓名',
                        width: '100'
                    },
                    {
                        key: 'reid',
                        label: '挂号id',
                        width: '100'
                    },


                ],
                tablecolumns2: [


                    {
                        key: 'mname',
                        label: '药品名称',
                        width: '150'
                    },
                    {
                        key: 'mprice',
                        label: '单价',
                        width: '100'
                    },
                    {
                        key: 'mcount',
                        label: '数量',
                        width: '100'
                    },
                    {
                        key: 'format',
                        label: '规格',
                        width: '100'
                    },
                    {
                        key: 'usage',
                        label: '用法',
                        width: '100'
                    },
                    {
                        key: 'ucount',
                        label: '用量',
                        width: '100'
                    },
                    {
                        key: 'fluency',
                        label: '频次',
                        width: '100'
                    },


                ],
                tableData: [],
                tableData2: [],
                tableData3: [],
                tableData4: [],
                tableData5: [],
                tableData6: [],
                ruleForm: {
                    chiefcomplaint: '',
                    pih: '',
                    ph: '',
                    ah: '',
                    result: '',
                    prename: '',
                    mid: '',
                    mcount: '',
                    musage: '',
                    mway: '',
                    mfluency: ''


                },
                rules: {
                    chiefcomplaint: [
                        {required: true, message: '请输入主诉', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    pih: [
                        {required: true, message: '请输入现病史', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    ph: [
                        {required: true, message: '请输入既往史', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    ah: [
                        {required: true, message: '请输入过敏史', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    result: [
                        {required: true, message: '请输入诊断结果', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    prename: [
                        {required: true, message: '请输入处方名称', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    mname: [
                        {required: true, message: '请输入药品名称', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    mcount: [
                        {required: true, message: '请输入药品数量', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    musage: [
                        {required: true, message: '请输入药品用量', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    mway: [
                        {required: true, message: '请输入药品用法', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],
                    mfluency: [
                        {required: true, message: '请输入药品频次', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}],

                },

            }
        },
        created(){

            const username=this.$store.getters.getUser.username;
            this.$axios.post("/searchpatients",{username:username}).then(resp=>{
                console.log(resp);
                this.tableData=resp.data.data.a1;
                this.tableData2=resp.data.data.a2;

                }).then(()=>{
                    this.$axios.post("/inittemplate",{}).then(resp=>{
                        this.tableData5=resp.data.data.template;
                    })

            })


        },
        methods: {
            addprescription(){
                console.log("----------"+this.ruleForm.prename);
                this.$axios.post("/addprescription",{prename:this.ruleForm.prename,number:this.p_number,reid:this.p_reid}).then(resp=>{

                }).then(()=>{
                    let postData={reid:this.p_reid,number:this.p_number,reid:this.p_reid};
                    console.log(postData);

                    this.$axios.post("/getprescription",{reid:this.p_reid}).then(resp=>{
                        this.tableData3=resp.data.data.prescriptions;
                        var that=this;
                        that.addpreVisible=false;
                        this.$message({type:'success',message:'增方成功'});
                    })
                })
            },
            addmedicine(){
                let postData={preid:this.pr_id,mid:this.ruleForm.mid,mcount:this.ruleForm.mcount,musage:this.ruleForm.musage,mway:this.ruleForm.mway,mfluency:this.ruleForm.mfluency};
                console.log(postData);
                this.$axios.post("/addmedicine",postData).then(resp=>{

                }).then(()=>{
                    this.$axios.post("/selectprescription",{preid:this.pr_id}).then(resp=>{
                        this.tableData4=resp.data.data.prescriptiondetails;
                        this.preprice=(resp.data.data.preprice).toFixed(1);
                        var that=this;
                        that.addmeVisible=false;
                        this.$message({type:'success',message:'增药成功'});
                    });
                })
            },
            selectprescription(row) {
                this.pr_id=row.preid;
                this.pr_name=row.prename;
                this.$axios.post("/selectprescription",{preid:this.pr_id}).then(resp=>{
                    this.tableData4=resp.data.data.prescriptiondetails;
                    console.log("price:"+resp.data.data.preprice);
                    this.preprice=(resp.data.data.preprice).toFixed(1);
                });
            },
            usetemplate(){
                this.$axios.post("/usetemplate",{ptid:this.tp_id,reid:this.p_reid,number:this.p_number}).then(resp=>{
                }).then(()=>{
                    this.$axios.post("/getprescription",{reid:this.p_reid}).then(resp=>{
                        this.tableData3=resp.data.data.prescriptions;
                        this.$message({type:'success',message:'使用模板成功'});
                    })
                });
            },
            dialog(){
                this.$axios.post("/dialog",{reid:this.p_reid,chiefcomplaint:this.ruleForm.chiefcomplaint,pih:this.ruleForm.pih,ph:this.ruleForm.ph,ah:this.ruleForm.ah,result:this.ruleForm.result}).then(resp=>{
                }).then(()=>{
                        const username=this.$store.getters.getUser.username;
                        this.$axios.post("/searchpatients",{username:username}).then(resp=> {
                            console.log(resp);
                            this.tableData = resp.data.data.a1;
                            this.tableData2 = resp.data.data.a2;
                            this.$message({type:'success',message:'确诊成功'});
                            this.ruleForm.chiefcomplaint='';
                            this.ruleForm.pih='';
                            this.ruleForm.ph='';
                            this.ruleForm.ah='';
                            this.ruleForm.result='';
                        })
                })
            },
            selectpatient(row){
                this.$axios.post("/selectpatient",{number:row.number}).then(resp=>{
                    console.log(resp);
                    this.p_age=resp.data.data.age;
                    this.p_sex=resp.data.data.sex;
                    this.p_number=row.number;
                    this.p_name=row.name;
                    this.p_reid=row.reid;
                }).then(()=>{
                    this.$axios.post("/getprescription",{reid:this.p_reid}).then(resp=>{
                        this.tableData3=resp.data.data.prescriptions;
                    })
                });



            },


            handleClick(tab, event) {
                console.log(tab, event);
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            handleSelectionChange(row) {
                console.log(row);
                this.currentSelectItem = row;
            },
            selecttemplate(row) {
                this.tp_id=row.pretid;
                this.tp_name=row.pretname;
                this.$axios.post("/selecttemplate",{pretid:this.tp_id}).then(resp=>{
                    this.tableData6=resp.data.data.template;
                });
            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            },
        }

    }
</script>

<style scoped>

</style>