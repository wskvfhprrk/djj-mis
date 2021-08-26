<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="图片地址" :label-width="formLabelWidth" prop="imageUrl">
                        <el-input :disabled="disabled=='1'" v-model="form.imageUrl" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="类型（0-店铺 1-代金券 2-网址 ）" :label-width="formLabelWidth" prop="type">
                        <el-input :disabled="disabled=='1'" v-model="form.type" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="链接地址" :label-width="formLabelWidth" prop="address">
                        <el-input :disabled="disabled=='1'" v-model="form.address" autocomplete="off"></el-input>
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
                    imageUrl: [
                        {
                            required: true,
                            message: '请输入图片地址',
                            trigger: 'blur'
                        }, 
                        {
                            max: 1024,
                            message: '输入最大长度为 1024 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     type: [
                        {
                            required: true,
                            message: '请输入类型（0-店铺 1-代金券 2-网址 ）',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     address: [
                        {
                            required: false,
                            message: '请输入链接地址',
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
