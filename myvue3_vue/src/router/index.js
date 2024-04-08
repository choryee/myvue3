import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TestView from "@/views/TestView.vue";
import TestView2 from "@/views/TestView2.vue";
import vueTutorial from "@/views/vueTutorial1.vue";
import vueTutorial1 from "@/views/vueTutorial1.vue";
import vueTutorial2 from "@/views/vueTutorial2.vue";
import vueTutorial3 from "@/views/vueTutorial3.vue";
import vueTutorial4 from "@/views/vueTutorialFour.vue";
import vueTutorialFour from "@/views/vueTutorialFour.vue";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/test',
    name:'test',
    component: TestView
  },
  {
    path: '/test2',
    name: 'test2',
    component: TestView2
  },
  {
    path: '/vueTutorial1',
    name: 'vueTutorial1',
    component: vueTutorial1
  },
  {
    path: '/vueTutorial2',
    name: 'vueTutorial2',
    component: vueTutorial2
  },
  {
    path: '/vueTutorial3',
    name: 'vueTutorial3',
    component: vueTutorial3
  },
  {
    path: '/vueTutorialFour',
    name: 'vueTutorialFour',
    component: vueTutorialFour
  },
  {
    path: '/about',
    name: 'about',
     component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/user',
    name: 'ListView',
    component: () => import(/* webpackChunkName: "user" */ '../views/ListView.vue')
  },
  {
    path: '/user/findById',
    name: 'SelectView',
    component: () => import(/* webpackChunkName: "user" */ '../views/SelectView.vue')
  },
  {
    path: '/user/editById',
    name: 'UpdateView',
    component: () => import(/* webpackChunkName: "user" */ '../views/UpdateView.vue')
  },
  {
    path: '/user/save',
    name: 'CreateView',
    component: () => import(/* webpackChunkName: "user" */ '../views/CreateView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
