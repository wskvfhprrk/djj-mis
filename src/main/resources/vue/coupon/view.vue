<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-row :gutter="16">
            <el-col :span="12">
                </el-form-item>
                <el-form-item label="空间名称" :label-width="formLabelWidth" prop="name">
                        <el-input :disabled="disabled=='1'" v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="所属店铺" :label-width="formLabelWidth" prop="shopId">
                        <el-input :disabled="disabled=='1'" v-model="form.shopId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图片" :label-width="formLabelWidth" prop="images">
                        <el-input :disabled="disabled=='1'" v-model="form.images" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="面值，单价（元）" :label-width="formLabelWidth" prop="price">
                        <el-input :disabled="disabled=='1'" v-model="form.price" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="使用门槛（消费满多少元可以使用）" :label-width="formLabelWidth" prop="useThreshold">
                        <el-input :disabled="disabled=='1'" v-model="form.useThreshold" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="标签" :label-width="formLabelWidth" prop="startDate">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.startDate" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="结束日期" :label-width="formLabelWidth" prop="stopDate">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.stopDate" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="优惠说明" :label-width="formLabelWidth" prop="description">
                        <el-input :disabled="disabled=='1'" v-model="form.description" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="使用须知" :label-width="formLabelWidth" prop="instruction">
                        <el-input :disabled="disabled=='1'" v-model="form.instruction" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="类型（0-公开 1-内部）" :label-width="formLabelWidth" prop="type">
                        <el-input :disabled="disabled=='1'" v-model="form.type" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="状态（0-新建 1-已上架 2-已下架）" :label-width="formLabelWidth" prop="status">
                        <el-input :disabled="disabled=='1'" v-model="form.status" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="创建时间" :label-width="formLabelWidth" prop="createTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.createTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
                </el-form-item>
                <el-form-item label="修改时间" :label-width="formLabelWidth" prop="updateTime">
                    <el-date-picker :disabled="disabled=='1'" v-model="form.updateTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" autocomplete="off"></el-date-picker>
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
                            message: '请输入空间名称',
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
                            required: true,
                            message: '请输入所属店铺',
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
                            message: '请输入图片',
                            trigger: 'blur'
                        }, 
                        {
                            max: 1000,
                            message: '输入最大长度为 1000 个字符',
                            trigger: 'blur'
                        }, 
                        {
                            pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                            message: '输入字符非法'
                        }
                    ],                     price: [
                        {
                            required: true,
                            message: '请输入面值，单价（元）',
                            trigger: 'blur'
                        }, 
                    ],                     useThreshold: [
                        {
                            required: true,
                            message: '请输入使用门槛（消费满多少元可以使用）',
                            trigger: 'blur'
                        }, 
                    ],                     startDate: [
                        {
                            required: true,
                            message: '请输入标签',
                            trigger: 'blur'
                        }, 
                    ],                     stopDate: [
                        {
                            required: true,
                            message: '请输入结束日期',
                            trigger: 'blur'
                        }, 
                    ],                     description: [
                        {
                            required: true,
                            message: '请输入优惠说明',
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
                    ],                     instruction: [
                        {
                            required: true,
                            message: '请输入使用须知',
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
                    ],                     type: [
                        {
                            required: true,
                            message: '请输入类型（0-公开 1-内部）',
                            trigger: 'blur'
                        }, 
                    ],                     status: [
                        {
                            required: true,
                            message: '请输入状态（0-新建 1-已上架 2-已下架）',
                            trigger: 'blur'
                        }, 
                    ],                     createTime: [
                        {
                            required: true,
                            message: '请输入创建时间',
                            trigger: 'blur'
                        }, 
                    ],                     updateTime: [
                        {
                            required: true,
                            message: '请输入修改时间',
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
