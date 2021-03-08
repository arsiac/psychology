<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" size="small" @keyup.enter.native="query">
      <el-form-item>
        <el-input v-model="dataForm.name" placeholder="名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="query">查询</el-button>
        <el-button v-if="$auth(authUrl, 'post)" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="$auth(authUrl, 'delete)" type="danger" @click="deleteHandle()"
                   :disabled="dataListSelections.length <= 0">批量删除
        </el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      max-height="500"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        fixed="left"
        width="50">
      </el-table-column>
      <el-table-column
        header-align="center"
        align="center"
        label="序号"
        width="80"
        fixed="left"
      >
        <template slot-scope="scope">
          <span>{{ scope.$index + 1 }}</span>
        </template>
      </el-table-column>

                  <el-table-column
            prop="id"
            header-align="center"
            align="center"
            label="项目id">
          </el-table-column>
                  <el-table-column
            prop="name"
            header-align="center"
            align="center"
            label="项目名称">
          </el-table-column>
                  <el-table-column
            prop="code"
            header-align="center"
            align="center"
            label="项目编码">
          </el-table-column>
                  <el-table-column
            prop="schoolCode"
            header-align="center"
            align="center"
            label="校内编码">
          </el-table-column>
                  <el-table-column
            prop="projectSourceId"
            header-align="center"
            align="center"
            label="项目来源id">
          </el-table-column>
                  <el-table-column
            prop="subjectTypeId"
            header-align="center"
            align="center"
            label="课题类型id">
          </el-table-column>
                  <el-table-column
            prop="projectStartDate"
            header-align="center"
            align="center"
            label="立项时间">
          </el-table-column>
                  <el-table-column
            prop="projectEndDate"
            header-align="center"
            align="center"
            label="结束时间">
          </el-table-column>
                  <el-table-column
            prop="money"
            header-align="center"
            align="center"
            label="经费(万元)">
          </el-table-column>
                  <el-table-column
            prop="managerId"
            header-align="center"
            align="center"
            label="项目负责人">
          </el-table-column>
                  <el-table-column
            prop="projectIsEnd"
            header-align="center"
            align="center"
            label="是否结题(0未结题, 1已结题)">
          </el-table-column>
                  <el-table-column
            prop="status"
            header-align="center"
            align="center"
            label="状态(0未提交, 1已提交, 2审核通过, 3退回修改)">
          </el-table-column>
                  <el-table-column
            prop="returnMessage"
            header-align="center"
            align="center"
            label="退回修改建议">
          </el-table-column>
                  <el-table-column
            prop="createBy"
            header-align="center"
            align="center"
            label="创建者">
          </el-table-column>
                  <el-table-column
            prop="createTime"
            header-align="center"
            align="center"
            label="创建时间">
          </el-table-column>
                  <el-table-column
            prop="updateBy"
            header-align="center"
            align="center"
            label="更新者">
          </el-table-column>
                  <el-table-column
            prop="updateTime"
            header-align="center"
            align="center"
            label="更新时间">
          </el-table-column>
                  <el-table-column
            prop="version"
            header-align="center"
            align="center"
            label="版本">
          </el-table-column>
              <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button
            type="text"
            size="small"
            @click="addOrUpdateHandle(scope.row)"
            :disabled="!$auth(authUrl, 'put')"
          >修改
          </el-button>
          <el-button
            type="text"
            size="small"
            @click="deleteHandle(scope.row)"
            :disabled="!$auth(authUrl, 'delete')"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      style="margin-top: 20px;"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import projectApi from '@/api/path/project'
  import AddOrUpdate from './project-add-or-update'

  export default {
    data() {
      return {
        authUrl: 'base/teacher',
        dataForm: {
          name: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    mounted() {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList() {
        this.dataListLoading = true
        projectApi.fuzzy(Object.assign({}, this.dataForm, {
          pageNum: this.pageIndex,
          pageSize: this.pageSize
        })).then(({data}) => {
          this.dataList = data.data
          this.totalPage = parseInt(data.total)
          this.dataListLoading = false
        }).catch(_ => {
          this.dataListLoading = false
        })
      },
      query() {
        this.pageIndex = 1
        this.getDataList()
      },
      // 每页数
      sizeChangeHandle(val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle(val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle(val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle(row) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
            this.$refs.addOrUpdate.init(row)
        })
      },
      // 删除
      deleteHandle(row) {
        const rows = row ? [row] : this.dataListSelections
        this.$confirm(`确定对[${rows.map(item => item.name).join(',')}]进行[${row ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          teacherApi.remove(rows).then(({data}) => {
            if (data.data) {
              this.$notify.success({
              message: '删除成功',
              title: '删除'
              })
              this.getDataList()
            }
          })
        }).catch(_ => {
          this.$notify.info({
          message: '用户取消操作',
          title: '删除'
          })
        })
      }
    }
  }
</script>