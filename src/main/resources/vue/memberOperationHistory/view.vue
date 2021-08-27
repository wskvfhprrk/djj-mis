<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="编号" :label-width="formLabelWidth" prop="memberId">
                        <el-input :disabled="disabled=='1'" v-model="form.memberId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="操作类型" :label-width="formLabelWidth" prop="operationId">
                        <el-input :disabled="disabled=='1'" v-model="form.operationId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="操作说明" :label-width="formLabelWidth" prop="relationInfo">
                        <el-input :disabled="disabled=='1'" v-model="form.relationInfo" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="详细信息" :label-width="formLabelWidth" prop="detail">
                        <el-input :disabled="disabled=='1'" v-model="form.detail" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="" :label-width="formLabelWidth" prop="createTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.createTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
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
                    memberId: [
                        {
                            required: true,
                            message: '请输入编号',
                            trigger: 'blur'
                        }, 
                        {
                            max: 32,
                            message: '输入最大长度为 32 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     operationId: [
                        {
                            required: true,
                            message: '请输入操作类型',
                            trigger: 'blur'
                        }, 
                        {
                            max: 255,
                            message: '输入最大长度为 255 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     relationInfo: [
                        {
                            required: false,
                            message: '请输入操作说明',
                            trigger: 'blur'
                        }, 
                        {
                            max: 255,
                            message: '输入最大长度为 255 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     detail: [
                        {
                            required: false,
                            message: '请输入详细信息',
                            trigger: 'blur'
                        }, 
                        {
                            max: 65535,
                            message: '输入最大长度为 65535 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     createTime: [
                        {
                            required: true,
                            message: '请输入',
                            trigger: 'blur'
                        }, 
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
