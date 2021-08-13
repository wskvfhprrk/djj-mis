<template>
    <el-form :model="form" :rules="rules" ref="ruleForm">
        <#---->
        <el-row :gutter="16"><#list data as d><#if d.id==false>
            <el-col :span="12">
                <el-form-item label="${d.commentName}" :label-width="formLabelWidth" prop="${d.beanName}">
                    <el-input :disabled="disabled=='1'" v-model="form.${d.beanName}" autocomplete="off"></el-input>
                </el-form-item>
            </el-col></#if></#list>
        </el-row>
    </el-form>

</template>
<script>
    import * as publicApi from '../../api/publicapi.js';

    export default {
        props: {
            disabled: String,
            fromdata: String,
        },
        data() {
            return {
                form: {islock:0},
                formLabelWidth: '120px',
                partData: [],
                rules: {<#list data as d><#if d.id==false>
                    ${d.beanName}: [
                        {required: <#if d.isNull==false>true<#else>false</#if>, message: '请输入${d.commentName}', trigger: 'blur'},<#if d.maximumLength?string!="0">
                        {max: ${d.maximumLength}, message: '输入最大长度为 ${d.maximumLength} 个字符', trigger: 'blur'},</#if><#if d.type=='String'>
                        {pattern: /^[\u4E00-\u9FA5A-Za-z0-9_]+$/, message: '输入字符非法'}</#if><#if d.type=='Double'>{pattern: /^\d+(\.\d+)?$/, message: '输入字符非法'}</#if>
                    ],</#if></#list>
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
        methods: {
            getUserSelect() {
                var vm = this;
                publicApi.userSelect.r(2).then(res => {
                    if (res.data.success) {
                        vm.partData = res.data.content;
                    } else {
                        vm.$message.error('获取用户下拉数据失败');
                    }
                })
            }
        },
        //显示编辑界面
        created() {
            this.getUserSelect();
        }
    }
</script>
