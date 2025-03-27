import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import jiankangtianbao from '@/views/modules/jiankangtianbao/list'
    import jiankangyizhan from '@/views/modules/jiankangyizhan/list'
    import jiankangyizhanCollection from '@/views/modules/jiankangyizhanCollection/list'
    import jiankangyizhanLiuyan from '@/views/modules/jiankangyizhanLiuyan/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import news from '@/views/modules/news/list'
    import tijian from '@/views/modules/tijian/list'
    import tijianCollection from '@/views/modules/tijianCollection/list'
    import tijianLiuyan from '@/views/modules/tijianLiuyan/list'
    import tijianYuyue from '@/views/modules/tijianYuyue/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghuqingjia from '@/views/modules/yonghuqingjia/list'
    import ziceyichang from '@/views/modules/ziceyichang/list'
    import config from '@/views/modules/config/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryJiankangyizhan from '@/views/modules/dictionaryJiankangyizhan/list'
    import dictionaryJiankangyizhanCollection from '@/views/modules/dictionaryJiankangyizhanCollection/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryTijian from '@/views/modules/dictionaryTijian/list'
    import dictionaryTijianCollection from '@/views/modules/dictionaryTijianCollection/list'
    import dictionaryTijianYuyueYesno from '@/views/modules/dictionaryTijianYuyueYesno/list'
    import dictionaryYonghuqingjia from '@/views/modules/dictionaryYonghuqingjia/list'
    import dictionaryYonghuqingjiaYesno from '@/views/modules/dictionaryYonghuqingjiaYesno/list'
    import dictionaryZiceyichang from '@/views/modules/dictionaryZiceyichang/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryJiankangyizhan',
        name: '驿站类型',
        component: dictionaryJiankangyizhan
    }
    ,{
        path: '/dictionaryJiankangyizhanCollection',
        name: '收藏表类型',
        component: dictionaryJiankangyizhanCollection
    }
    ,{
        path: '/dictionaryNews',
        name: '资讯类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryTijian',
        name: '体检服务类型',
        component: dictionaryTijian
    }
    ,{
        path: '/dictionaryTijianCollection',
        name: '收藏表类型',
        component: dictionaryTijianCollection
    }
    ,{
        path: '/dictionaryTijianYuyueYesno',
        name: '预约状态',
        component: dictionaryTijianYuyueYesno
    }
    ,{
        path: '/dictionaryYonghuqingjia',
        name: '请假类型',
        component: dictionaryYonghuqingjia
    }
    ,{
        path: '/dictionaryYonghuqingjiaYesno',
        name: '申请状态',
        component: dictionaryYonghuqingjiaYesno
    }
    ,{
        path: '/dictionaryZiceyichang',
        name: '隔离状态',
        component: dictionaryZiceyichang
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '校园论坛',
        component: forum
      }
    ,{
        path: '/jiankangtianbao',
        name: '每日健康填报',
        component: jiankangtianbao
      }
    ,{
        path: '/jiankangyizhan',
        name: '健康驿站',
        component: jiankangyizhan
      }
    ,{
        path: '/jiankangyizhanCollection',
        name: '驿站收藏',
        component: jiankangyizhanCollection
      }
    ,{
        path: '/jiankangyizhanLiuyan',
        name: '驿站留言',
        component: jiankangyizhanLiuyan
      }
    ,{
        path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
    ,{
        path: '/news',
        name: '校园健康资讯',
        component: news
      }
    ,{
        path: '/tijian',
        name: '体检服务',
        component: tijian
      }
    ,{
        path: '/tijianCollection',
        name: '服务收藏',
        component: tijianCollection
      }
    ,{
        path: '/tijianLiuyan',
        name: '服务留言',
        component: tijianLiuyan
      }
    ,{
        path: '/tijianYuyue',
        name: '体检预约',
        component: tijianYuyue
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }
    ,{
        path: '/yonghuqingjia',
        name: '学生请假',
        component: yonghuqingjia
      }
    ,{
        path: '/ziceyichang',
        name: '自测异常信息',
        component: ziceyichang
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
