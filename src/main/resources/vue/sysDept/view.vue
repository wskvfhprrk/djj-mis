<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="上级部门ID，一级部门为0" :label-width="formLabelWidth" prop="parentId">
                        <el-input :disabled="disabled=='1'" v-model="form.parentId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="部门名称" :label-width="formLabelWidth" prop="name">
                        <el-input :disabled="disabled=='1'" v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="排序" :label-width="formLabelWidth" prop="orderNum">
                        <el-input :disabled="disabled=='1'" v-model="form.orderNum" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="是否删除  -1：已删除  0：正常" :label-width="formLabelWidth" prop="delFlag">
                        <el-input :disabled="disabled=='1'" v-model="form.delFlag" autocomplete="off"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
    </el-form>

</template>
<script>

    //如果需要下拉时才使用，每个js中已经有得到全部数据
    //import * as selectData from '../../api/publicapi.js';

    export default {
        props: {
            disabled: String,
            fromdata: String,
        },
        data() {
            return {
                form: {islock: 0},
                formLabelWidth: '120px',
                //partData: [],
                rules: {
                    parentId: [
                        {
                            required: false,
                            message: '请输入上级部门ID，一级部门为0',
                            trigger: 'blur'
                        }, 
                    ],                     name: [
                        {
                            required: false,
                            message: '请输入部门名称',
                            trigger: 'blur'
                        }, 
                        {
                            max: 50,
                            message: '输入最大长度为 50 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     orderNum: [
                        {
                            required: false,
                            message: '请输入排序',
                            trigger: 'blur'
                        }, 
                    ],                     delFlag: [
                        {
                            required: false,
                            message: '请输入是否删除  -1：已删除  0：正常',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ], 
                },
            }
        },
        watch: {
            fromdata(newdata, olddata) {
                this.form = this.fromdata ? JSON.parse(this.fromdata) : {};
            },
            disabled(newdata) {
                this.disabled = newdata
            }
        },
        mounted() {
            var vm = this;
            vm.form = vm.fromdata ? JSON.parse(vm.fromdata) : {};
            vm.$refs['ruleForm'].resetFields()
        },
        // methods: {
        //     getAll() {
        //         var vm = this;
        //         selectData.getall.r(2).then(res => {
        //             if (res.data.success) {
        //                 vm.partData = res.data.content;
        //             } else {
        //                 vm.$message.error('获取用户下拉数据失败');
        //             }
        //         })
        //     }
        // },
        //显示编辑界面
        created() {
            // this.getAll();
        }
    }
</script>
