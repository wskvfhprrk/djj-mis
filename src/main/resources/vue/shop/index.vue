<template>
    <div v-loading="loading">
        <!-- 操作 start -->
        <div class="searchBox">
            <el-row v-model="queryParms" :gutter="20" class="operation">
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">店铺名称： </span>
                    <el-input class="SearchInput" v-model="queryParms.name" placeholder="请输入店铺名称"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">logo图片： </span>
                    <el-input class="SearchInput" v-model="queryParms.logoImage" placeholder="请输入logo图片"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">图片（可以多张）： </span>
                    <el-input class="SearchInput" v-model="queryParms.images" placeholder="请输入图片（可以多张）"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">商圈： </span>
                    <el-input class="SearchInput" v-model="queryParms.businessDistrictId" placeholder="请输入商圈"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">省： </span>
                    <el-input class="SearchInput" v-model="queryParms.province" placeholder="请输入省"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">市： </span>
                    <el-input class="SearchInput" v-model="queryParms.city" placeholder="请输入市"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">县： </span>
                    <el-input class="SearchInput" v-model="queryParms.county" placeholder="请输入县"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">区： </span>
                    <el-input class="SearchInput" v-model="queryParms.area" placeholder="请输入区"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">详细地址： </span>
                    <el-input class="SearchInput" v-model="queryParms.address" placeholder="请输入详细地址"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">经度： </span>
                    <el-input class="SearchInput" v-model="queryParms.longitude" placeholder="请输入经度"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">纬度： </span>
                    <el-input class="SearchInput" v-model="queryParms.latitude" placeholder="请输入纬度"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">联系方式： </span>
                    <el-input class="SearchInput" v-model="queryParms.phone" placeholder="请输入联系方式"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">负责人： </span>
                    <el-input class="SearchInput" v-model="queryParms.custodian" placeholder="请输入负责人"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">行业： </span>
                    <el-input class="SearchInput" v-model="queryParms.profession" placeholder="请输入行业"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">店面介绍： </span>
                    <el-input class="SearchInput" v-model="queryParms.details" placeholder="请输入店面介绍"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">入驻时间： </span>
                    <el-date-picker class="SearchInput"  v-model="queryParms.createTime" type="date" placeholder="选择入驻时间"></el-date-picker>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">状态（0-未审核 1-已发布 2-已下架）： </span>
                    <el-input class="SearchInput" v-model="queryParms.status" placeholder="请输入状态（0-未审核 1-已发布 2-已下架）"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">营业开始时间： </span>
                    <el-input class="SearchInput" v-model="queryParms.startTime" placeholder="请输入营业开始时间"></el-input>
                </el-col>
                <el-col class="marginBottom" :span="8">
                    <span class="labelSpan">营业结束时间： </span>
                    <el-input class="SearchInput" v-model="queryParms.stopTime" placeholder="请输入营业结束时间"></el-input>
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
                    <el-button size="medium" type="primary" v-allow="shop_get" @click="search">查询</el-button>
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
                <el-button class="addBtn" v-allow="shop_post" @click="add" size="medium" type="primary">新增
                </el-button>
            </el-row>
            <el-table :data="list" border style="width: 100%">
                <el-table-column prop="name" label="店铺名称" align="center"></el-table-column>
                <el-table-column prop="logoImage" label="logo图片" align="center"></el-table-column>
                <el-table-column prop="images" label="图片（可以多张）" align="center"></el-table-column>
                <el-table-column prop="businessDistrictId" label="商圈" align="center"></el-table-column>
                <el-table-column prop="province" label="省" align="center"></el-table-column>
                <el-table-column prop="city" label="市" align="center"></el-table-column>
                <el-table-column prop="county" label="县" align="center"></el-table-column>
                <el-table-column prop="area" label="区" align="center"></el-table-column>
                <el-table-column prop="address" label="详细地址" align="center"></el-table-column>
                <el-table-column prop="longitude" label="经度" align="center"></el-table-column>
                <el-table-column prop="latitude" label="纬度" align="center"></el-table-column>
                <el-table-column prop="phone" label="联系方式" align="center"></el-table-column>
                <el-table-column prop="custodian" label="负责人" align="center"></el-table-column>
                <el-table-column prop="profession" label="行业" align="center"></el-table-column>
                <el-table-column prop="details" label="店面介绍" align="center"></el-table-column>
                <el-table-column prop="createTime" label="入驻时间" align="center"></el-table-column>
                <el-table-column prop="status" label="状态（0-未审核 1-已发布 2-已下架）" align="center"></el-table-column>
                <el-table-column prop="startTime" label="营业开始时间" align="center"></el-table-column>
                <el-table-column prop="stopTime" label="营业结束时间" align="center"></el-table-column>
                <el-table-column label="操作" width="200" align="center">
                    <template slot-scope="scope">
                        <el-button v-allow="shop_put" size="mini" type="info" @click="edit(scope.$index,scope.row)">
                            编辑</el-button>
                        <el-button size="mini" type="danger" v-allow="shop_*_delete" @click="deleteHandel(scope.$index,scope.row)">
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
    import * as shop from '../../api/shop.js';
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
                shop.list.r(str).then((res) => {
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
                
                shop.view.r(data.shopId).then(res => {
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
                shop.add.r(vm.$refs.formPage.form).then(res => {
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
                shop.edit.r(vm.$refs.formPage.form).then(res => {
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
                
                var param = data.shopId;
                shop.clock.r(param).then(res => {
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
                
                var param = data.shopId;
                shop.click.r(param).then(res => {
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
                
                var param = data.shopId;
                shop.remove.r(param).then(res => {
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
