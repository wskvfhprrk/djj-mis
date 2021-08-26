<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="店铺名称" :label-width="formLabelWidth" prop="name">
                        <el-input :disabled="disabled=='1'" v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图片（可以多张）" :label-width="formLabelWidth" prop="images">
                        <el-input :disabled="disabled=='1'" v-model="form.images" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="省" :label-width="formLabelWidth" prop="province">
                        <el-input :disabled="disabled=='1'" v-model="form.province" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="市" :label-width="formLabelWidth" prop="city">
                        <el-input :disabled="disabled=='1'" v-model="form.city" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="县" :label-width="formLabelWidth" prop="county">
                        <el-input :disabled="disabled=='1'" v-model="form.county" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="区" :label-width="formLabelWidth" prop="area">
                        <el-input :disabled="disabled=='1'" v-model="form.area" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="详细地址" :label-width="formLabelWidth" prop="address">
                        <el-input :disabled="disabled=='1'" v-model="form.address" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="经度" :label-width="formLabelWidth" prop="longitude">
                        <el-input :disabled="disabled=='1'" v-model="form.longitude" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="纬度" :label-width="formLabelWidth" prop="latitude">
                        <el-input :disabled="disabled=='1'" v-model="form.latitude" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="店面介绍" :label-width="formLabelWidth" prop="details">
                        <el-input :disabled="disabled=='1'" v-model="form.details" autocomplete="off"></el-input>
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
                            message: '请输入店铺名称',
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
                    ],                     images: [
                        {
                            required: false,
                            message: '请输入图片（可以多张）',
                            trigger: 'blur'
                        }, 
                        {
                            max: 2048,
                            message: '输入最大长度为 2048 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     province: [
                        {
                            required: true,
                            message: '请输入省',
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
                    ],                     city: [
                        {
                            required: true,
                            message: '请输入市',
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
                    ],                     county: [
                        {
                            required: true,
                            message: '请输入县',
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
                    ],                     area: [
                        {
                            required: true,
                            message: '请输入区',
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
                    ],                     address: [
                        {
                            required: true,
                            message: '请输入详细地址',
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
                    ],                     details: [
                        {
                            required: true,
                            message: '请输入店面介绍',
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
