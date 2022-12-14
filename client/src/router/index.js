import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';

const routes = [
	{
		path: '/',
		name: 'Home',
		component: Home,
		meta: {
			title: 'WhereIsMyhome - Project',
		},
	},

	//Todo 라우트 추가 (왜 여길 고쳤는데 이름 이 바뀌지)
	// {
	// 	path: '/todo',
	// 	name: 'Todo',
	// 	component: () =>
	// 	import('../views/Todo.vue'),
	// 	meta: {
	// 		title: 'WhereIsMyhome - Project',
	// 	},
	// },

	//Deal Info 라우트 추가 
	{
		path: '/deal',
		name: 'Deal',
		component: () =>
		import('../views/Deal.vue'),
		meta: {
			title: 'WhereIsMyhome - Project',
		},
	},
	{
		path: '/projects',
		name: 'Projects',
		component: () =>
			import( '../views/Projects.vue'),
		meta: {
			title: 'WhereIsMyhome - Project',
		},
	},
	{
		path: '/projects/single-project',
		name: 'Single Project',
		component: () =>
			import('../views/SingleProject.vue'),
		meta: {
			title: 'WhereIsMyhome - Project',
		},
	},

	// 회원 가입 이동
	{
		path: '/regist',
		name: 'Regist',
		component: () =>
			import('../views/Register.vue'),
		meta: {
			title: 'WhereIsMyhome - Project',
		},
	},  
	// 게시판 이동
	{
    path: "/board",
    name: "board",
    component: () => import("@/views/Board"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardlist",
        component: () => import("@/components/board/BoardList"),
				meta: {
					title: 'WhereIsMyhome - Project',
				},
      },
      {
        path: "write",
        name: "boardwrite",
        component: () => import("@/components/board/BoardWrite"),
				meta: {
					title: 'WhereIsMyhome - Project',
				},
      },
      {
        path: "view",
        name: "boardview",
        component: () => import("@/components/board/BoardView"),
				meta: {
					title: 'WhereIsMyhome - Project',
				},
      },
      {
        path: "modify",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"),
				meta: {
					title: 'WhereIsMyhome - Project',
				},
      },
      {
        path: "delete",
        name: "boarddelete",
        component: () => import("@/components/board/BoardDelete"),
				meta: {
					title: 'WhereIsMyhome - Project',
				},
      },
    ],
  },
];

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes,
	scrollBehavior() {
		document.getElementById('app').scrollIntoView();
	},
});

export default router;

router.beforeEach((to, from, next) => {
	
	const nearestWithTitle = to.matched
		.slice()
		.reverse()
		.find((r) => r.meta && r.meta.title);

	const nearestWithMeta = to.matched
		.slice()
		.reverse()
		.find((r) => r.meta && r.meta.metaTags);

	const previousNearestWithMeta = from.matched
		.slice()
		.reverse()
		.find((r) => r.meta && r.meta.metaTags);

	if (nearestWithTitle) {
		document.title = nearestWithTitle.meta.title;
	} else if (previousNearestWithMeta) {
		document.title = previousNearestWithMeta.meta.title;
	}


	Array.from(
		document.querySelectorAll('[data-vue-router-controlled]')
	).map((el) => el.parentNode.removeChild(el));


	if (!nearestWithMeta) return next();


	nearestWithMeta.meta.metaTags
		.map((tagDef) => {
			const tag = document.createElement('meta');

			Object.keys(tagDef).forEach((key) => {
				tag.setAttribute(key, tagDef[key]);
			});

	
			tag.setAttribute('data-vue-router-controlled', '');

			return tag;
		})
		.forEach((tag) => document.head.appendChild(tag));

	next();
});
