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
                    <el-button type="primary" @click="todispense">发药</el-button>
                </el-row>
                <el-table
                        :data="tableData"
                        height="300"
                        highlight-current-row
                        style="width: 100%">
                    <el-table-column v-for="item in tablecolumns"
                                     :key="item.key"
                                     :prop="item.key"
                                     :label="item.label"
                                     :width="item.width">

                        　　
                    </el-table-column>

                </el-table>


            </el-form>
        </el-main>

    </div>
</template>

<script>
    export default {
        name: "Dispense",
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

                tablecolumns: [

                    {
                        key: 'mname',
                        label: '药品名称',
                        width: '100'
                    },
                    {
                        key: 'mprice',
                        label: '药品单价',
                        width: '100'
                    },
                    {
                        key: 'mcount',
                        label: '药品数量',
                        width: '200'
                    },
                    {
                        key: 'docname',
                        label: '开立医生',
                        width: '100'
                    },
                    {
                        key: 'prename',
                        label: '处方名称',
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
        }, methods: {
            todispense(){
                this.$axios.post("/dispense",{number:this.ruleForm.number}).then(resp=>{

                    this.search();
                    this.$message({type:'success',message:'发药成功'});
                })
            },
            search() {
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        const _this = this;
                        console.log("number:" + this.ruleForm.number);

                        this.$axios.post('/dispensesearch', {number: this.ruleForm.number}).then(resp => {
                            console.log(resp);


                            this.ruleForm.name = resp.data.data.name;
                            this.ruleForm.ID = resp.data.data.ID;
                            this.ruleForm.address = resp.data.data.address;
                            this.tableData = resp.data.data.dispense;


                        })

                    }
                });

            }
        }
    }
</script>

<style scoped>

</style>