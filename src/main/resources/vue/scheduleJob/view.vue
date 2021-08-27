<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
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
                <el-form-item label="cron表达式" :label-width="formLabelWidth" prop="cronExpression">
                        <el-input :disabled="disabled=='1'" v-model="form.cronExpression" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="任务状态  0：正常  1：暂停" :label-width="formLabelWidth" prop="status">
                        <el-input :disabled="disabled=='1'" v-model="form.status" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="备注" :label-width="formLabelWidth" prop="remark">
                        <el-input :disabled="disabled=='1'" v-model="form.remark" autocomplete="off"></el-input>
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
                    beanName: [
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
                    ],                     cronExpression: [
                        {
                            required: false,
                            message: '请输入cron表达式',
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
                    ],                     status: [
                        {
                            required: false,
                            message: '请输入任务状态  0：正常  1：暂停',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     remark: [
                        {
                            required: false,
                            message: '请输入备注',
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
