<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                <el-form-item label="用户编号" :label-width="formLabelWidth" prop="userId">
                        <el-input :disabled="disabled=='1'" v-model="form.userId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="上报时间" :label-width="formLabelWidth" prop="reportTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.reportTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="经度" :label-width="formLabelWidth" prop="longitude">
                        <el-input :disabled="disabled=='1'" v-model="form.longitude" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="纬度" :label-width="formLabelWidth" prop="latitude">
                        <el-input :disabled="disabled=='1'" v-model="form.latitude" autocomplete="off"></el-input>
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
                    userId: [
                        {
                            required: true,
                            message: '请输入用户编号',
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
                    ],                     reportTime: [
                        {
                            required: true,
                            message: '请输入上报时间',
                            trigger: 'blur'
                        }, 
                    ],                     longitude: [
                        {
                            required: true,
                            message: '请输入经度',
                            trigger: 'blur'
                        }, {pattern: /^\d+(\.\d+)?$/, message: '输入字符非法'}
                    ],                     latitude: [
                        {
                            required: true,
                            message: '请输入纬度',
                            trigger: 'blur'
                        }, {pattern: /^\d+(\.\d+)?$/, message: '输入字符非法'}
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
