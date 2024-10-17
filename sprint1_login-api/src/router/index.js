import Vue from 'vue';
import VueRouter from 'vue-router';
import Login from '@/components/LoginPage.vue';
import Home from '@/components/HomePage.vue';

Vue.use(VueRouter);

const routes = [
    { path: '/', name: 'Login', component: Login },
    { path: '/home', name: 'Home', component: Home }
  ];
  
  const router = new VueRouter({
    mode: 'history',
    routes
  });

  export default router;
    