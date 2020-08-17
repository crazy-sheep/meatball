<template>
  <div id="login">
    <el-main >
      <div style="width: 450px; margin-left: 35%; ">
        <el-form :model="userInfo" status-icon :rules="rules" ref="userInfo" label-width="100px">
          <el-form-item label="账号" prop="account">
            <el-input type="account" v-model="userInfo.account" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="userInfo.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('userInfo')">登录</el-button>
            <el-button @click="resetForm('userInfo')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-main>
  </div>
</template>


<script>
  import CryptoJS from './../../static/lib/crypto-js'

  export default {
    data() {
      var validateAccount = (rule, value, callback) => {
        /*debugger*/
        if (value === '') {
          callback(new Error('请输入账号'));
        } else {
          callback();
          //this.$refs.userInfo.validateField('account');

        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          callback();
          //this.$refs.userInfo.validateField('password');

        }
      };
      return {
        userInfo: {
          account: '',
          password: ''
        },
        rules: {
          account: [
            { validator: validateAccount, trigger: 'change' }
          ],
          password: [
            { validator: validatePass,trigger: 'change' }
          ],
        }
      };
    },
    methods: {

      submitForm(data) {
        this.$refs[data].validate((valid) => {
          if (valid) {

            this.userInfo.account = CryptoJS.MD5(this.userInfo.account).toString();
            this.userInfo.password = CryptoJS.MD5(this.userInfo.password).toString();
            this.axios.post('http://localhost:8866/login', this.userInfo).then(res => {
              if (res.data.code === '200'){
                this.$router.push({ path:'/index'  })
              }else {
                console.log(res.data.msg);
                return false;
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(data) {
        this.$refs[data].resetFields();
      }
    }
  }
</script>


<style scoped>
  #login {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
