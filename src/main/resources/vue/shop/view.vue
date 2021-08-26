<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="店铺名称" :label-width="formLabelWidth" prop="name">
                        <el-input :disabled="disabled=='1'" v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="logo图片" :label-width="formLabelWidth" prop="logoImage">
                        <el-input :disabled="disabled=='1'" v-model="form.logoImage" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图片（可以多张）" :label-width="formLabelWidth" prop="images">
                        <el-input :disabled="disabled=='1'" v-model="form.images" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商圈" :label-width="formLabelWidth" prop="businessDistrictId">
                        <el-input :disabled="disabled=='1'" v-model="form.businessDistrictId" autocomplete="off"></el-input>
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
                <el-form-item label="联系方式" :label-width="formLabelWidth" prop="phone">
                        <el-input :disabled="disabled=='1'" v-model="form.phone" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="负责人" :label-width="formLabelWidth" prop="custodian">
                        <el-input :disabled="disabled=='1'" v-model="form.custodian" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="行业" :label-width="formLabelWidth" prop="profession">
                        <el-input :disabled="disabled=='1'" v-model="form.profession" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="店面介绍" :label-width="formLabelWidth" prop="details">
                        <el-input :disabled="disabled=='1'" v-model="form.details" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="入驻时间" :label-width="formLabelWidth" prop="createTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.createTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="状态（0-未审核 1-已发布 2-已下架）" :label-width="formLabelWidth" prop="status">
                        <el-input :disabled="disabled=='1'" v-model="form.status" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="营业开始时间" :label-width="formLabelWidth" prop="startTime">
                        <el-input :disabled="disabled=='1'" v-model="form.startTime" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="营业结束时间" :label-width="formLabelWidth" prop="stopTime">
                        <el-input :disabled="disabled=='1'" v-model="form.stopTime" autocomplete="off"></el-input>
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
                    ],                     logoImage: [
                        {
                            required: false,
                            message: '请输入logo图片',
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
                    ],                     businessDistrictId: [
                        {
                            required: true,
                            message: '请输入商圈',
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
                    ],                     phone: [
                        {
                            required: true,
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
                    ],                     custodian: [
                        {
                            required: true,
                            message: '请输入负责人',
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
                    ],                     profession: [
                        {
                            required: true,
                            message: '请输入行业',
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
                    ],                     createTime: [
                        {
                            required: true,
                            message: '请输入入驻时间',
                            trigger: 'blur'
                        }, 
                    ],                     status: [
                        {
                            required: true,
                            message: '请输入状态（0-未审核 1-已发布 2-已下架）',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     startTime: [
                        {
                            required: true,
                            message: '请输入营业开始时间',
                            trigger: 'blur'
                        }, 
                    ],                     stopTime: [
                        {
                            required: true,
                            message: '请输入营业结束时间',
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
