import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about', 
      component: () => import('./views/About.vue')
    },
    {
      path: '/lancamentos',
      name: 'lancamentos', 
      component: () => import('./views/Lancamentos.vue')
    },
    {
      path: '/entrada',
      name: 'entrada', 
      component: () => import('./views/Entradas.vue')
    },
    {
      path: '/saida',
      name: 'saida', 
      component: () => import('./views/Saidas.vue')
    },
  ]
})
