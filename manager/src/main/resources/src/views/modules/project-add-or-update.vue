<template>
  <el-dialog
    :title="title"
    width="400px"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="项目名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="项目名称"></el-input>
    </el-form-item>
    <el-form-item label="项目编码" prop="code">
      <el-input v-model="dataForm.code" placeholder="项目编码"></el-input>
    </el-form-item>
    <el-form-item label="校内编码" prop="schoolCode">
      <el-input v-model="dataForm.schoolCode" placeholder="校内编码"></el-input>
    </el-form-item>
    <el-form-item label="项目来源id" prop="projectSourceId">
      <el-input v-model="dataForm.projectSourceId" placeholder="项目来源id"></el-input>
    </el-form-item>
    <el-form-item label="课题类型id" prop="subjectTypeId">
      <el-input v-model="dataForm.subjectTypeId" placeholder="课题类型id"></el-input>
    </el-form-item>
    <el-form-item label="立项时间" prop="projectStartDate">
      <el-input v-model="dataForm.projectStartDate" placeholder="立项时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="projectEndDate">
      <el-input v-model="dataForm.projectEndDate" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="经费(万元)" prop="money">
      <el-input v-model="dataForm.money" placeholder="经费(万元)"></el-input>
    </el-form-item>
    <el-form-item label="项目负责人" prop="managerId">
      <el-input v-model="dataForm.managerId" placeholder="项目负责人"></el-input>
    </el-form-item>
    <el-form-item label="是否结题(0未结题, 1已结题)" prop="projectIsEnd">
      <el-input v-model="dataForm.projectIsEnd" placeholder="是否结题(0未结题, 1已结题)"></el-input>
    </el-form-item>
    <el-form-item label="状态(0未提交, 1已提交, 2审核通过, 3退回修改)" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态(0未提交, 1已提交, 2审核通过, 3退回修改)"></el-input>
    </el-form-item>
    <el-form-item label="退回修改建议" prop="returnMessage">
      <el-input v-model="dataForm.returnMessage" placeholder="退回修改建议"></el-input>
    </el-form-item>
    <el-form-item label="创建者" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建者"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新者" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新者"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="版本" prop="version">
      <el-input v-model="dataForm.version" placeholder="版本"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        title: '',
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          code: '',
          schoolCode: '',
          projectSourceId: '',
          subjectTypeId: '',
          projectStartDate: '',
          projectEndDate: '',
          money: '',
          managerId: '',
          projectIsEnd: '',
          status: '',
          returnMessage: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          version: ''
        },
        dataRule: {
          name: [
            { required: true, message: '项目名称不能为空', trigger: 'blur' }
          ],
          code: [
            { required: true, message: '项目编码不能为空', trigger: 'blur' }
          ],
          schoolCode: [
            { required: true, message: '校内编码不能为空', trigger: 'blur' }
          ],
          projectSourceId: [
            { required: true, message: '项目来源id不能为空', trigger: 'blur' }
          ],
          subjectTypeId: [
            { required: true, message: '课题类型id不能为空', trigger: 'blur' }
          ],
          projectStartDate: [
            { required: true, message: '立项时间不能为空', trigger: 'blur' }
          ],
          projectEndDate: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          money: [
            { required: true, message: '经费(万元)不能为空', trigger: 'blur' }
          ],
          managerId: [
            { required: true, message: '项目负责人不能为空', trigger: 'blur' }
          ],
          projectIsEnd: [
            { required: true, message: '是否结题(0未结题, 1已结题)不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态(0未提交, 1已提交, 2审核通过, 3退回修改)不能为空', trigger: 'blur' }
          ],
          returnMessage: [
            { required: true, message: '退回修改建议不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建者不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新者不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (row) {
        this.dataForm = Object.assign({}, row) || {}
        this.title    = !row ? '新增' : '修改'
        this.visible  = true
      },
      // 表单提交
      dataFormSubmit () {
        api.add(Object.assign({}, this.dataForm)).then(({ data }) => {
          if (data.data) {
            this.$notify.success({
            title: this.title,
            message: '操作成功'
            })
            this.visible = false
            this.$emit('refreshDataList')
          }
        })
      }
    }
  }
</script>
