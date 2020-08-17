import axios from 'axios'
import { MessageBox, Message,Loading  } from 'element-ui'
import store from '@/store'
import { getToken } from '@/utils/auth'
import Utils from '@/utils/common'

// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000000, // request timeout
  headers: {
    "Content-Type": "application/json;charset=utf-8",
    "X-Requested-With": "XMLHttpRequest"
  }
})

// request interceptor
service.interceptors.request.use(
  config => {
    if(!config.hideMask){
      config.maskRef = Loading.service({ target:document.body,fullscreen:false, lock: true, text:" ", background: 'rgba(0, 0, 0, 0)'});
    }
    // do something before request is sent
    if (store.getters.token) {
      // let each request carry token
      // ['token'] is a custom headers key
      // please modify it according to the actual situation
      config.headers['token'] = getToken();


      if(typeof  config.params == 'object'){
        Utils.trimObj(config.params);
      }
      if(!config.params){
        config.params = {};
      }
      config.params["token"] = getToken();

      if(typeof  config.data == 'object'){
        Utils.trimObj(config.data);
      }else if(typeof  config.data == 'string' && Utils.isJSON(config.data)){
        var data = JSON.parse(config.data);
        config.data = JSON.stringify(Utils.trimObj(data));
      }
    }

    return config
  },
  error => {
    if(error.config && error.config.maskRef){
      error.config.maskRef.close();
      error.config.maskRef = null;
    }
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
  */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    if(response.config && response.config.maskRef){
      response.config.maskRef.close();
      response.config.maskRef = null;
    }
    const res = response.data
    // if the custom code is not 0, it is judged as an error.
    if (res.code !== 0) {
      Message({
        message: res.msg || 'error',
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(res.msg || 'error')
    }else if(res["_needLogin_"]){
      //重新登录
      top.window.document.location.reload(true);
      // return  Promise.reject(res.msg || 'error')
    }else {
      return res
    }
  },
  error => {
    if(error.config && error.config.maskRef){
      error.config.maskRef.close();
      error.config.maskRef = null;
    }
    console.log('err' + error) // for debug
    Message({
      message: error.msg ? error.msg : error.response.data,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
