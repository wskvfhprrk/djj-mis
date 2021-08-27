<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="编号（每张代金券唯一编号）" :label-width="formLabelWidth" prop="couponNo">
                        <el-input :disabled="disabled=='1'" v-model="form.couponNo" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="发出方（id+名称）" :label-width="formLabelWidth" prop="fromName">
                        <el-input :disabled="disabled=='1'" v-model="form.fromName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="接收方（id+名称）" :label-width="formLabelWidth" prop="toName">
                        <el-input :disabled="disabled=='1'" v-model="form.toName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="创建时间" :label-width="formLabelWidth" prop="createTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.createTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="备注" :label-width="formLabelWidth" prop="remark">
                        <el-input :disabled="disabled=='1'" v-model="form.remark" autocomplete="off"></el-input>
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
                    couponNo: [
                        {
                            required: true,
                            message: '请输入编号（每张代金券唯一编号）',
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
                    ],                     fromName: [
                        {
                            required: true,
                            message: '请输入发出方（id+名称）',
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
                    ],                     toName: [
                        {
                            required: true,
                            message: '请输入接收方（id+名称）',
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
                            required: true,
                            message: '请输入创建时间',
                            trigger: 'blur'
                        }, 
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
