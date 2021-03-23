<template>
    <div>

        <el-main>
            <el-form :inline="true" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                     class="demo-ruleForm">

                <el-form-item label="患者信息查询" prop="infoquery">
                </el-form-item>
                <el-row>
                    <el-form-item label="病历号" prop="number">
                        <el-input v-model="ruleForm.number" placeholder="请输入病历号" style="width: 150px"></el-input>
                    </el-form-item>
                    <el-button type="primary" icon="el-icon-search" @click="search()">搜索</el-button>
                </el-row>
                <el-row>
                    <el-form-item label="患者信息" prop="info">
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="姓名" prop="name">
                        <el-input v-model="ruleForm.name" placeholder="姓名" style="width: 150px"></el-input>
                    </el-form-item>
                    <el-form-item label="身份证号" prop="ID">
                        <el-input v-model="ruleForm.ID" placeholder="身份证号" style="width: 300px"></el-input>
                    </el-form-item>
                    <el-form-item label="家庭住址" prop="address">
                        <el-input v-model="ruleForm.address" placeholder="家庭住址" style="width: 400px"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="患者挂号信息" prop="info">
                    </el-form-item>
                </el-row>
                <el-table
                        height="300"
                        :data="tableData"
                        tooltip-effect="dark"
                        style="width: 100%"
                        @selection-change="handleSelectionChange">
                    <el-table-column
                            v-for="item in tablecolumns"
                            :key="item.key"
                            :prop="item.key"
                            :label="item.label"
                            :width="item.width"
                            :type="item.type"

                    ></el-table-column>


                </el-table>
            </el-form>
            <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm2">

                <el-form-item class="mybutton">
                    <el-button type="primary" @click="open" >收费</el-button>
                </el-form-item>
                <el-dialog
                        ref="dialog1"
                        title="收费详情"
                        :visible.sync="chargeVisible"
                        width="30%"
                        :before-close="handleClose">

                    <el-form-item label="病历号" prop="number">
                        <el-input v-model="ruleForm2.number" placeholder="请输入病历号" style="width: 300px"></el-input>
                    </el-form-item>
                    <el-form-item label="患者姓名" prop="name">
                        <el-input v-model="ruleForm2.name" placeholder="请输入患者姓名" style="width: 300px"></el-input>
                    </el-form-item>
                    <el-form-item label="应收金额" prop="price1">
                        <el-input v-model="ruleForm2.price1" placeholder="请输入应收金额" style="width: 300px"></el-input>
                    </el-form-item>
                    <el-form-item label="实收金额" prop="price2">
                        <el-input v-model="ruleForm2.price2" placeholder="请输入实收金额" @keyup.enter.native="calculate" style="width: 300px"></el-input>
                    </el-form-item>
                    <el-form-item label="找零金额" prop="price3">
                        <el-input v-model="ruleForm2.price3" placeholder="请输入找零金额" style="width: 300px"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="charge()" >确 定</el-button>
                        <el-button @click="chargeVisible = false">取 消</el-button>
                    </el-form-item>
                </el-dialog>

            </el-form>

        </el-main>

    </div>
</template>

<script>

    export default {
        name: "Charge",
        data() {


            return {
                radio: '',
                chargeVisible: false,

                multipleSelection: [],


                ruleForm: {
                    number: '',
                    name: '',
                    ID: '',
                    address: '',


                },
                rules: {
                    number: [
                        {required: true, message: '请输入病历号', trigger: 'blur'},
                        {min: 0, trigger: 'blur'}
                    ],

                },
                ruleForm2: {
                    number: '',
                    price1: '',
                    price2: '',
                    price3: '',
                    name: '',
                    chargeVisible: false

                },
                rules2: {},
                tablecolumns: [
                    {
                        type: 'selection',
                        width: '50'
                    },
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
                        key: 'mname',
                        label: '药品名称',
                        width: '200'
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
                        key: 'time',
                        label: '开立时间',
                        width: '100'
                    },
                    {
                        key: 'predid',
                        label: '明细',
                        width: '100'
                    },

                ],
                tableData: []
            }
        },

        methods: {
            open(){
                var arr=this.multipleSelection;
                let multis = [];
                for (var i=0;i<arr.length;i++) {
                    multis.push(arr[i]);
                }
                console.log("----------------"+JSON.stringify(this.multipleSelection));
                console.log("================"+multis);
                this.$axios.post('/chargeinfo',multis).then(resp =>{
                    this.ruleForm2.number=resp.data.data.number;
                    this.ruleForm2.name=resp.data.data.name;
                    this.ruleForm2.price1=resp.data.data.price;
                    var that = this;
                    that.chargeVisible=true;


                });
            },
            search(){
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        const _this=this;
                        console.log("number:"+this.ruleForm.number);
                        this.$axios.post('/chargesearch', {number:this.ruleForm.number}).then(resp => {
                            console.log(resp);
                            this.ruleForm.name=resp.data.data.name;
                            this.ruleForm.ID=resp.data.data.ID;
                            this.ruleForm.address=resp.data.data.address;
                            this.tableData=resp.data.data.list;
                            // let tableData=[];
                            // for(let i in resp.data.data.list){
                            //     tableData.push(resp.data.data.list[i]);
                            //     console.log("----------"+resp.data.data.list[i])
                            // }
                            //  this.tableData = tableData;


                        })

                    }
                });
            },
            charge(){
                var arr=this.multipleSelection;
                let multis = [];
                for (var i=0;i<arr.length;i++) {
                    multis.push(arr[i]);
                }
                this.$axios.post('/charge',multis).then(resp => {
                    var that = this;
                    that.chargeVisible=false;
                    this.$message({type:'success',message:'收费成功'});
                    this.search();
                    this.multipleSelection=[];

                })



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
            calculate(){
                this.ruleForm2.price3=(this.ruleForm2.price2 - this.ruleForm2.price1).toFixed(1);
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },

            toggleSelection(rows) {
                if (rows) {
                    rows.forEach(row => {
                        this.$refs.multipleTable.toggleRowSelection(row);
                    });
                } else {
                    this.$refs.multipleTable.clearSelection();
                }
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;

            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            }

        },
    }
</script>

<style scoped>

</style>