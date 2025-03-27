<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan'">
                    <el-form-item class="select" v-if="type!='info'"  label="健康驿站" prop="jiankangyizhanId">
                        <el-select v-model="ruleForm.jiankangyizhanId" :disabled="ro.jiankangyizhanId" filterable placeholder="请选择健康驿站" @change="jiankangyizhanChange">
                            <el-option
                                    v-for="(item,index) in jiankangyizhanOptions"
                                    v-bind:key="item.id"
                                    :label="item.jiankangyizhanName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="驿站名称" prop="jiankangyizhanName">
                        <el-input v-model="jiankangyizhanForm.jiankangyizhanName"
                                  placeholder="驿站名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="驿站名称" prop="jiankangyizhanName">
                            <el-input v-model="ruleForm.jiankangyizhanName"
                                      placeholder="驿站名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jiankangyizhanPhoto" label="驿站照片" prop="jiankangyizhanPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (jiankangyizhanForm.jiankangyizhanPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jiankangyizhanPhoto" label="驿站照片" prop="jiankangyizhanPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.jiankangyizhanPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="驿站地址" prop="jiankangyizhanAddress">
                        <el-input v-model="jiankangyizhanForm.jiankangyizhanAddress"
                                  placeholder="驿站地址" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="驿站地址" prop="jiankangyizhanAddress">
                            <el-input v-model="ruleForm.jiankangyizhanAddress"
                                      placeholder="驿站地址" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="负责人" prop="jiankangyizhanFzr">
                        <el-input v-model="jiankangyizhanForm.jiankangyizhanFzr"
                                  placeholder="负责人" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="负责人" prop="jiankangyizhanFzr">
                            <el-input v-model="ruleForm.jiankangyizhanFzr"
                                      placeholder="负责人" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="jiankangyizhanPhone">
                        <el-input v-model="jiankangyizhanForm.jiankangyizhanPhone"
                                  placeholder="联系方式" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="联系方式" prop="jiankangyizhanPhone">
                            <el-input v-model="ruleForm.jiankangyizhanPhone"
                                      placeholder="联系方式" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="驿站类型" prop="jiankangyizhanValue">
                        <el-input v-model="jiankangyizhanForm.jiankangyizhanValue"
                                  placeholder="驿站类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="驿站类型" prop="jiankangyizhanValue">
                            <el-input v-model="ruleForm.jiankangyizhanValue"
                                      placeholder="驿站类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jiankangyizhan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="驿站热度" prop="jiankangyizhanClicknum">
                        <el-input v-model="jiankangyizhanForm.jiankangyizhanClicknum"
                                  placeholder="驿站热度" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="驿站热度" prop="jiankangyizhanClicknum">
                            <el-input v-model="ruleForm.jiankangyizhanClicknum"
                                      placeholder="驿站热度" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="jiankangyizhanId" name="jiankangyizhanId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="标题" prop="ziceyichangName">
                       <el-input v-model="ruleForm.ziceyichangName"
                                 placeholder="标题" clearable  :readonly="ro.ziceyichangName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="标题" prop="ziceyichangName">
                           <el-input v-model="ruleForm.ziceyichangName"
                                     placeholder="标题" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="隔离人名称" prop="ziceyichangMingc">
                       <el-input v-model="ruleForm.ziceyichangMingc"
                                 placeholder="隔离人名称" clearable  :readonly="ro.ziceyichangMingc"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="隔离人名称" prop="ziceyichangMingc">
                           <el-input v-model="ruleForm.ziceyichangMingc"
                                     placeholder="隔离人名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="体温" prop="ziceyichangTiwen">
                       <el-input v-model="ruleForm.ziceyichangTiwen"
                                 placeholder="体温" clearable  :readonly="ro.ziceyichangTiwen"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="体温" prop="ziceyichangTiwen">
                           <el-input v-model="ruleForm.ziceyichangTiwen"
                                     placeholder="体温" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="隔离状态" prop="ziceyichangTypes">
                        <el-select v-model="ruleForm.ziceyichangTypes" :disabled="ro.ziceyichangTypes" placeholder="请选择隔离状态">
                            <el-option
                                v-for="(item,index) in ziceyichangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="隔离状态" prop="ziceyichangValue">
                        <el-input v-model="ruleForm.ziceyichangValue"
                            placeholder="隔离状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="详情信息" prop="ziceyichangText">
                        <el-input type="textarea"  :readonly="ro.ziceyichangText" v-model="ruleForm.ziceyichangText" placeholder="详情信息"></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.ziceyichangText" label="详情信息" prop="ziceyichangText">
                            <span v-html="ruleForm.ziceyichangText"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                jiankangyizhanForm: {},
                ro:{
                    jiankangyizhanId: false,
                    ziceyichangName: false,
                    ziceyichangMingc: false,
                    ziceyichangTiwen: false,
                    ziceyichangTypes: false,
                    ziceyichangText: false,
                    insertTime: false,
                },
                ruleForm: {
                    jiankangyizhanId: '',
                    ziceyichangName: '',
                    ziceyichangMingc: '',
                    ziceyichangTiwen: '',
                    ziceyichangTypes: '',
                    ziceyichangText: '',
                    insertTime: '',
                },
                ziceyichangTypesOptions : [],
                jiankangyizhanOptions : [],
                rules: {
                   jiankangyizhanId: [
                              { required: true, message: '驿站不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   ziceyichangName: [
                              { required: true, message: '标题不能为空', trigger: 'blur' },
                          ],
                   ziceyichangMingc: [
                              { required: true, message: '隔离人名称不能为空', trigger: 'blur' },
                          ],
                   ziceyichangTiwen: [
                              { required: true, message: '体温不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   ziceyichangTypes: [
                              { required: true, message: '隔离状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   ziceyichangText: [
                              { required: true, message: '详情信息不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '记录时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }else{
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=ziceyichang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ziceyichangTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `jiankangyizhan/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.jiankangyizhanOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            jiankangyizhanChange(id){
                this.$http({
                    url: `jiankangyizhan/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jiankangyizhanForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `ziceyichang/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.jiankangyizhanChange(data.data.jiankangyizhanId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`ziceyichang/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.ziceyichangCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.ziceyichangCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

