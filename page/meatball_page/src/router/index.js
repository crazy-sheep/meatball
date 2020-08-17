import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  mode:'history',    //新添加的一行
  routes: [
    /*{
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }*/
    {
      path:'/',
      name:'login',
      component: () => import('@/views/login')
    },
    {
      path: '/index',
      name: 'index',
      component: () => import('@/views/index')
    }
  ]

})
