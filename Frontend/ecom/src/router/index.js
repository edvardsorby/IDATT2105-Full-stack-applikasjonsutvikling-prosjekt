import { createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import EditView from '../views/EditView.vue'


const routes = [
    {
        path: '/1',
        name: 'Home',
        component: HomeView
    },
    {
        path: '/l',
        name: 'Login',
        component: LoginView
    },
    {
        path: '/1',
        name: 'Register',
        component: RegisterView
    },
    {
        path: '/',
        name: 'Edit',
        component: EditView
    }

]


const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router