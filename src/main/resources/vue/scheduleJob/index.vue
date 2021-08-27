<template>
    <div v-loading="loading">
        <!-- 操作 start -->
        <div class="searchBox">
            <el-row v-model="queryParms" :gutter="20" class="operation">
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">spring bean名称： </span>
                    <el-input class="SearchInput" v-model="queryParms.beanName" placeholder="请输入spring bean名称"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">方法名： </span>
                    <el-input class="SearchInput" v-model="queryParms.methodName" placeholder="请输入方法名"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">参数： </span>
                    <el-input class="SearchInput" v-model="queryParms.params" placeholder="请输入参数"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">cron表达式： </span>
                    <el-input class="SearchInput" v-model="queryParms.cronExpression" placeholder="请输入cron表达式"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">任务状态  0：正常  1：暂停： </span>
                    <el-input class="SearchInput" v-model="queryParms.status" placeholder="请输入任务状态  0：正常  1：暂停"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">备注： </span>
                    <el-input class="SearchInput" v-model="queryParms.remark" placeholder="请输入备注"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">创建时间： </span>
                    <el-date-picker class="SearchInput"  v-model="queryParms.createTime" type="date" placeholder="选择创建时间"></el-date-picker>
                </el-col>
                <el-col :span="8">
                    <span class="labelSpan">状态： </span>
                    <el-select v-model="islock" clearable placeholder="请选择状态">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-col>
                <el-col :span="8">
                    <el-button size="medium" type="primary" v-allow="scheduleJob_get" @click="search">查询</el-button>
                </el-col>
            </el-row>
        </div>
        <!-- 操作 end-->

        <!-- table start  -->
        <div class="resultBox">
            <el-row :gutter="20">
                <el-col class="title" :span="24">
                    <h4>查询结果</h4>
                </el-col>
                <el-button class="addBtn" v-allow="scheduleJob_post" @click="add" size="medium" type="primary">新增
                </el-button>
            </el-row>
            <el-table :data="list" border style="width: 100%">
                <el-table-column prop="beanName" label="spring bean名称" align="center"></el-table-column>
                <el-table-column prop="methodName" label="方法名" align="center"></el-table-column>
                <el-table-column prop="params" label="参数" align="center"></el-table-column>
                <el-table-column prop="cronExpression" label="cron表达式" align="center"></el-table-column>
                <el-table-column prop="status" label="任务状态  0：正常  1：暂停" align="center"></el-table-column>
                <el-table-column prop="remark" label="备注" align="center"></el-table-column>
                <el-table-column prop="createTime" label="创建时间" align="center"></el-table-column>
                <el-table-column label="操作" width="200" align="center">
                    <template slot-scope="scope">
                        <el-button v-allow="scheduleJob_put" size="mini" type="info" @click="edit(scope.$index,scope.row)">
                            编辑</el-button>
                        <el-button size="mini" type="danger" v-allow="scheduleJob_*_delete" @click="deleteHandel(scope.$index,scope.row)">
                            删除</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <!-- pagination start -->
            <el-pagination
                    background
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNumber"
                    :page-sizes="[15,50,100]"
                    :page-size=15
                    prev-text='上一页'
                    next-text='下一页'
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="totalCount">
            </el-pagination>
        </div>
        <!-- pagination end -->
        <!-- table end  -->

        <!-- 查看   新增   编辑  表单 -->
        <el-dialog
                :title="modelTitle"
                :visible.sync="dialogFormVisible01"
                width="50%" :center="center">
            <addpage :disabled="disabled" :fromdata="fromdata" ref="formPage"></addpage>
            <span slot="footer" class="dialog-footer">
        <el-button type="primary" v-if="!isView&&modelTitle=='新增'" @click="submitHandle">提 交</el-button>
        <el-button type="primary" v-if="!isView&&modelTitle=='编辑'" @click="editsubmit">提 交</el-button>
        <el-button @click="dialogFormVisible01 = false">取 消</el-button>
      </span>
        </el-dialog>

        <!-- 是否删除  确认 start -->
        <el-dialog
                title="删除"
                :visible.sync="dialogFormVisible"
                width="30%" :center="center">
			<span>
      </span>
            <span slot="footer" class="dialog-footer">
        <el-button type="primary">确 定</el-button>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
      </span>
        </el-dialog>
        <!-- 是否确认 提交 确认 end -->
    </div>
</template>

<script>
    import * as scheduleJob from '../../api/scheduleJob.js';
    import addpage from './view.vue';

    export default {
        components: {
            addpage
        },
        data() {
            return {
                queryParms:{},//查询参数
                fromdata:'',
                searchParam: '',                //当前查询条件
                center: true,
                list: [],
                loading: false,
                totalCount: 0,                   //数据总条数
                pageSize: 15,                    // 每页数据条数
                pageNumber: 1,                     //当前页
                order: 'asc',                    //排序方式
                dialogFormVisible: false,
                dialogFormVisible01: false,
                modelTitle: "新增",
                isView: false,
                islock: '',
                phone: "",
                options: [{
                    value: '0',
                    label: '未锁定'
                }, {
                    value: '1',
                    label: '锁定'
                }],
                value: ''
            }
        },
        methods: {
            search() {
                var vm = this;
                vm.fetchData();
            },
            formatter(val) {
                switch (val.islock) {
                    case 0 :
                        return "未锁定";
                        break;
                    case 1 :
                        return "锁定";
                        break;
                    default:
                        return "";
                        break;
                }
            },
            fetchData(param) {//查询
                var vm = this;
                vm.loading = true;
                let queryParms = this.queryParms;
                queryParms.pageSize = vm.pageSize;
                queryParms.pageNumber = vm.pageNumber

                var str = '';
                for (var i in queryParms) {
                    if (queryParms[i]) {
                        str += i + '=' + queryParms[i] + '&';
                    }
                }
                str.slice(0, str.length - 1)
                scheduleJob.list.r(str).then((res) => {
                    if (res.data.success && res.data.content.pages != null) {
                        vm.list = res.data.content.pages;
                        vm.pageNumber = res.data.content.pageNumber;
                        vm.pageSize = res.data.content.pageSize;
                        vm.totalCount = res.data.content.totle;
                        vm.loading = false;
                        vm.$message.success('数据请求成功');
                    } else if (res.data.success && res.data.content.pages == null) {
                        vm.list = res.data.content.pages;
                        vm.loading = false;
                        vm.$message.success('数据请求成功');
                    } else {
                        vm.loading = false;
                        vm.$message.error(res.data.msg);
                    }
                });
            },

            //分页函数
            handleCurrentChange(val) {
                var vm = this;
                vm.pageNumber = val;
                vm.fetchData({'pageNumber': vm.pageNumber, 'pageSize': vm.pageSize})
            },

            handleSizeChange(val) {
                var vm = this;
                vm.pageSize = val;
                vm.fetchData({'pageNumber': vm.pageNumber, 'pageSize': vm.pageSize})
            },
            //添加打开新建view
            add() {
                var vm = this;
                vm.dialogFormVisible01 = true;
                vm.isView = false,
                    vm.modelTitle = '新增'
                vm.disabled = '0';
                // vm.fromdata = '';
                if (vm.$refs.formPage) {
                    vm.$refs.formPage.$refs['ruleForm'].resetFields()
                }
            },
            edit(item, data) {
                var vm = this;
                vm.dialogFormVisible01 = true;
                vm.modelTitle = '编辑';
                vm.isView = false,
                    // vm.loading = true;
                    vm.fromdata = '';
                vm.disabled = '0';
                vm.getViewInfo(data)
            },
            view(item, data) {
                var vm = this;
                vm.isView = true,
                    vm.dialogFormVisible01 = true;
                // vm.loading = true;
                // 设置disablked
                vm.disabled = '1';
                vm.fromdata = '';
                vm.getViewInfo(data)
            },
            getViewInfo(data) {
                var vm = this;
                
                scheduleJob.view.r(data.jobId).then(res => {
                    if (res.data.success) {
                        vm.fromdata = JSON.stringify(res.data.content);
                        if (vm.$refs.formPage) {
                            vm.$refs.formPage.$refs['ruleForm'].resetFields()
                        }
                    } else {
                        vm.$message.error(res.data.msg)
                    }
                })
            },
            submitHandle() {//新增提交
                var vm = this;
                var flag = true;//默认允许提交
                vm.$refs.formPage.$refs["ruleForm"].validate((valid) => {
                    if (valid) {
                        flag = true;
                    } else {
                        flag = false
                        return false;
                    }
                });
                if (!flag) {
                    return false;
                }
                vm.loading = true
                scheduleJob.add.r(vm.$refs.formPage.form).then(res => {
                    if (res.data.success) {

                        vm.$message.success('保存成功');
                        this.search()
                        vm.dialogFormVisible01 = false;
                        vm.loading = false;

                    } else {
                        vm.loading = false;
                        vm.$message.error(res.data.msg);

                    }
                })
            },
            editsubmit() {//新增提交
                var vm = this;
                var flag = true;//默认允许提交
                vm.$refs.formPage.$refs["ruleForm"].validate((valid) => {
                    if (valid) {
                        flag = true;
                    } else {
                        flag = false
                        return false;
                    }
                });
                if (!flag) {
                    return false;
                }
                vm.loading = true
                scheduleJob.edit.r(vm.$refs.formPage.form).then(res => {
                    if (res.data.success) {

                        vm.$message.success('保存成功')
                        vm.dialogFormVisible01 = false;
                        this.search()
                        vm.loading = false;
                    } else {
                        vm.loading = false;
                        vm.$message.error(res.data.code);
                    }
                })
            },
            clock(item, data) {
                var vm = this;
                vm.loading = true;
                
                var param = data.jobId;
                scheduleJob.clock.r(param).then(res => {
                    if (res.data.success) {
                        vm.$message.success('切换');
                        vm.loading = false;
                        vm.search();
                    } else {
                        vm.$message.error(res.data.msg)
                        vm.loading = false;
                        // vm.fetchData();
                    }
                })
            },
            click(item, data) {
                var vm = this;
                vm.loading = true;
                
                var param = data.jobId;
                scheduleJob.click.r(param).then(res => {
                    if (res.data.success) {
                        vm.$message.success('切换');
                        vm.loading = false;
                        vm.search();
                    } else {
                        vm.$message.error(res.data.msg)
                        vm.loading = false;
                        // vm.fetchData();
                    }
                })
            },
            deleteHandel(item, data) {
                var vm = this;
                vm.loading = true;
                
                var param = data.jobId;
                scheduleJob.remove.r(param).then(res => {
                    if (res.data.success) {
                        vm.$message.success('已删除');
                        vm.loading = false;
                        vm.search();
                    } else {
                        vm.$message.error(res.data.msg)
                        vm.loading = false;
                        // vm.fetchData();
                    }
                })
            },
        },
        //启动时首先启动
        created() {
            this.fetchData()
        }
    }
</script>
