<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="任务id" :label-width="formLabelWidth" prop="jobId">
                        <el-input :disabled="disabled=='1'" v-model="form.jobId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="spring bean名称" :label-width="formLabelWidth" prop="beanName">
                        <el-input :disabled="disabled=='1'" v-model="form.beanName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="方法名" :label-width="formLabelWidth" prop="methodName">
                        <el-input :disabled="disabled=='1'" v-model="form.methodName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="参数" :label-width="formLabelWidth" prop="params">
                        <el-input :disabled="disabled=='1'" v-model="form.params" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="任务状态    0：成功    1：失败" :label-width="formLabelWidth" prop="status">
                        <el-input :disabled="disabled=='1'" v-model="form.status" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="失败信息" :label-width="formLabelWidth" prop="error">
                        <el-input :disabled="disabled=='1'" v-model="form.error" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="耗时(单位：毫秒)" :label-width="formLabelWidth" prop="times">
                        <el-input :disabled="disabled=='1'" v-model="form.times" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="创建时间" :label-width="formLabelWidth" prop="createTime">
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
                    jobId: [
                        {
                            required: true,
                            message: '请输入任务id',
                            trigger: 'blur'
                        }, 
                    ],                     beanName: [
                        {
                            required: false,
                            message: '请输入spring bean名称',
                            trigger: 'blur'
                        }, 
                        {
                            max: 200,
                            message: '输入最大长度为 200 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     methodName: [
                        {
                            required: false,
                            message: '请输入方法名',
                            trigger: 'blur'
                        }, 
                        {
                            max: 100,
                            message: '输入最大长度为 100 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     params: [
                        {
                            required: false,
                            message: '请输入参数',
                            trigger: 'blur'
                        }, 
                        {
                            max: 2000,
                            message: '输入最大长度为 2000 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     status: [
                        {
                            required: true,
                            message: '请输入任务状态    0：成功    1：失败',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     error: [
                        {
                            required: false,
                            message: '请输入失败信息',
                            trigger: 'blur'
                        }, 
                        {
                            max: 2000,
                            message: '输入最大长度为 2000 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     times: [
                        {
                            required: true,
                            message: '请输入耗时(单位：毫秒)',
                            trigger: 'blur'
                        }, 
                    ],                     createTime: [
                        {
                            required: false,
                            message: '请输入创建时间',
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
