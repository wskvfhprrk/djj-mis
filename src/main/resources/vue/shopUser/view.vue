<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="昵称" :label-width="formLabelWidth" prop="name">
                        <el-input :disabled="disabled=='1'" v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="性别（0:男，1:女）" :label-width="formLabelWidth" prop="sex">
                        <el-input :disabled="disabled=='1'" v-model="form.sex" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="生日" :label-width="formLabelWidth" prop="birthday">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.birthday" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="联系方式" :label-width="formLabelWidth" prop="phone">
                        <el-input :disabled="disabled=='1'" v-model="form.phone" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="角色（0-老板 1-店长 2-员工）" :label-width="formLabelWidth" prop="role">
                        <el-input :disabled="disabled=='1'" v-model="form.role" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="店铺编号" :label-width="formLabelWidth" prop="shopId">
                        <el-input :disabled="disabled=='1'" v-model="form.shopId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="创建时间" :label-width="formLabelWidth" prop="createTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.createTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="更新时间" :label-width="formLabelWidth" prop="updateTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.updateTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="状态（0-正常 1-暂停 2-注销）" :label-width="formLabelWidth" prop="status">
                        <el-input :disabled="disabled=='1'" v-model="form.status" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户在微信端的唯一标识" :label-width="formLabelWidth" prop="openId">
                        <el-input :disabled="disabled=='1'" v-model="form.openId" autocomplete="off"></el-input>
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
                    name: [
                        {
                            required: true,
                            message: '请输入昵称',
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
                    ],                     sex: [
                        {
                            required: true,
                            message: '请输入性别（0:男，1:女）',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     birthday: [
                        {
                            required: true,
                            message: '请输入生日',
                            trigger: 'blur'
                        }, 
                    ],                     phone: [
                        {
                            required: true,
                            message: '请输入联系方式',
                            trigger: 'blur'
                        }, 
                        {
                            max: 20,
                            message: '输入最大长度为 20 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     role: [
                        {
                            required: true,
                            message: '请输入角色（0-老板 1-店长 2-员工）',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     shopId: [
                        {
                            required: true,
                            message: '请输入店铺编号',
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
                    ],                     createTime: [
                        {
                            required: true,
                            message: '请输入创建时间',
                            trigger: 'blur'
                        }, 
                    ],                     updateTime: [
                        {
                            required: true,
                            message: '请输入更新时间',
                            trigger: 'blur'
                        }, 
                    ],                     status: [
                        {
                            required: true,
                            message: '请输入状态（0-正常 1-暂停 2-注销）',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     openId: [
                        {
                            required: false,
                            message: '请输入用户在微信端的唯一标识',
                            trigger: 'blur'
                        }, 
                        {
                            max: 64,
                            message: '输入最大长度为 64 个字符',
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
