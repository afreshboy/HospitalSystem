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
                        :data="tableData"
                        height="300"
                        highlight-current-row
                        style="width: 100%">
                    <el-table-column v-for="item in tablecolumns"
                                     :key="item.key"
                                     :prop="item.key"
                                     :label="item.label"
                                     :width="item.width"

                    >


                    </el-table-column>
                    <el-table-column label="操作" align="center" min-width="100">
                        　　　　
                        <template slot-scope="scope">
                            　　　　　　
                            <el-button type="primary" @click.native.prevent="returnnumber(scope.row)">退号</el-button>
                            　　　　
                        </template>
                        　　
                    </el-table-column>

                </el-table>

                <!--            <el-pagination-->
                <!--                @size-change="handleSizeChange"-->
                <!--                @current-change="handleCurrentChange"-->
                <!--                :current-page="currentPage"-->
                <!--                :page-size="pagesize"-->
                <!--                layout="total,prev,paper,next"-->
                <!--                :total="tableData.length">-->
                <!--        </el-pagination>-->


            </el-form>
        </el-main>

    </div>
</template>

<script>
    export default {
        name: "Return",
        data() {

            return {
                pagesize: 1,//每页的数据条数
                currentPage: 1,//默认开始页面


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
                        key: 'number',
                        label: '病历号',
                        width: '100'
                    },
                    {
                        key: 'reid',
                        label: '挂号id',
                        width: '100'
                    },
                    {
                        key: 'name',
                        label: '姓名',
                        width: '100'
                    },
                    {
                        key: 'man',
                        label: '身份证号',
                        width: '200'
                    },
                    {
                        key: 'time',
                        label: '挂号时间',
                        width: '100'
                    },
                    {
                        key: 'department',
                        label: '挂号科室',
                        width: '100'
                    },
                    {
                        key: 'doctor',
                        label: '挂号医生',
                        width: '100'
                    },
                    {
                        key: 'restatus',
                        label: '挂号状态',
                        width: '100'
                    },
                    {
                        key: 'diagstatus',
                        label: '诊断状态',
                        width: '100'
                    },

                ],
                tableData:[]

            }
        },

        methods: {
            search(){
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        const _this=this;
                        console.log("number:"+this.ruleForm.number);

                        this.$axios.post('/returnsearch', {number:this.ruleForm.number}).then(resp => {
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
            returnnumber(rows) {

                console.log("reid:------------------"+rows.reid) ;

                    this.$axios.post("/return", {reid: rows.reid}).then(resp => {
                        this.search();
                        console.log("----------"+resp.data.data.status);
                        if (resp.data.data.status==0) {
                            this.$message({type: 'error', message: '退号失败'});

                        }else {

                            this.$message({type: 'success', message: '退号成功'});

                        }
                    })



            },
            handleSizeChange(val) {
                console.log('每页 ${val} 条');
                this.pagesize = val;
            },


            handleCurrentChange(val) {
                console.log('当前页:${val}');
                this.currentPage = val;
            }

        }


    }
</script>

<style scoped>

</style>