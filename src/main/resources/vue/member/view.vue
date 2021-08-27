<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="用户在微信端的唯一标识" :label-width="formLabelWidth" prop="openId">
                        <el-input :disabled="disabled=='1'" v-model="form.openId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="联系方式" :label-width="formLabelWidth" prop="phone">
                        <el-input :disabled="disabled=='1'" v-model="form.phone" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="性别（0：未知,1:男，2:女）" :label-width="formLabelWidth" prop="sex">
                        <el-input :disabled="disabled=='1'" v-model="form.sex" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="生日" :label-width="formLabelWidth" prop="birthday">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.birthday" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="注册时间" :label-width="formLabelWidth" prop="registerTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.registerTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="头像" :label-width="formLabelWidth" prop="imageUrl">
                        <el-input :disabled="disabled=='1'" v-model="form.imageUrl" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户昵称" :label-width="formLabelWidth" prop="nickname">
                        <el-input :disabled="disabled=='1'" v-model="form.nickname" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户姓名" :label-width="formLabelWidth" prop="name">
                        <el-input :disabled="disabled=='1'" v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="标签" :label-width="formLabelWidth" prop="label">
                        <el-input :disabled="disabled=='1'" v-model="form.label" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="描述" :label-width="formLabelWidth" prop="description">
                        <el-input :disabled="disabled=='1'" v-model="form.description" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="归属店铺ID" :label-width="formLabelWidth" prop="shopId">
                        <el-input :disabled="disabled=='1'" v-model="form.shopId" autocomplete="off"></el-input>
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
                    openId: [
                        {
                            required: true,
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
                    ],                     phone: [
                        {
                            required: false,
                            message: '请输入联系方式',
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
                    ],                     sex: [
                        {
                            required: false,
                            message: '请输入性别（0：未知,1:男，2:女）',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     birthday: [
                        {
                            required: false,
                            message: '请输入生日',
                            trigger: 'blur'
                        }, 
                    ],                     registerTime: [
                        {
                            required: false,
                            message: '请输入注册时间',
                            trigger: 'blur'
                        }, 
                    ],                     imageUrl: [
                        {
                            required: false,
                            message: '请输入头像',
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
                    ],                     nickname: [
                        {
                            required: false,
                            message: '请输入用户昵称',
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
                    ],                     name: [
                        {
                            required: false,
                            message: '请输入用户姓名',
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
                    ],                     label: [
                        {
                            required: false,
                            message: '请输入标签',
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
                    ],                     description: [
                        {
                            required: false,
                            message: '请输入描述',
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
                    ],                     shopId: [
                        {
                            required: false,
                            message: '请输入归属店铺ID',
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
