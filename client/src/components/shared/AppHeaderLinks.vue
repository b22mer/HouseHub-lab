<script>
export default {
	props: ['showModal', 'isOpen'],
};
</script>

<template>
	<!-- Header links -->
	<div
		:class="isOpen ? 'block' : 'hidden'"
		class="m-0 sm:ml-4 mt-0 sm:mt-3 sm:flex p-5 sm:p-0 justify-center items-center"
	>


		<router-link
			to="/projects"
			class="font-general-medium block text-left text-lg mt-3 font-medium text-primary-dark dark:text-ternary-light hover:text-indigo-800 dark:hover:text-indigo-300  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
			aria-label="Projects"
			><span id="banner">Introduce</span></router-link
		>
	


<!-- 거래정보 탭 -->
<router-link
			to="/deal"
			class="font-general-medium block mt-3 text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-indigo-800 dark:hover:text-indigo-300  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
			aria-label="Contact"
			><span id="banner">DealInfo</span></router-link
		>



		<!--contact -> Regist, 회원가입 -->
		<router-link
			to="/board"
			class="font-general-medium block mt-3 text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-indigo-800 dark:hover:text-indigo-300  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
			aria-label="Contact"
			type="button"
			><span id="banner">Board</span></router-link
		>


<!--contact -> Regist, 회원가입 -->
		<router-link
			to="/regist"
			class="font-general-medium block mt-3 text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-indigo-800 dark:hover:text-indigo-300  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
			aria-label="Contact"
			type="button"
			><span id="banner">Regist</span></router-link
		>


<!-- 투두 리스트 탭(삭제예정)-->
		<!-- <router-link
			to="/todo"
			class="font-general-medium block text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-indigo-600 dark:hover:text-indigo-300  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
			aria-label="Contact"
			>Todo</router-link
		> -->


		<div
			class="border-t-2 mt-5  pt-3 sm:pt-0 sm:border-t-0 border-primary-light dark:border-secondary-dark"
		>
			<button
				class="font-general-medium sm:hidden block text-left text-md font-medium bg-indigo-500 hover:bg-indigo-100 text-white shadow-sm rounded-sm px-4 py-2 mt-2 duration-500"
				@click="showModal()"
				aria-label="Hire Me Button"
			>
				LOGIN
			</button>
		</div>
		
	</div>
</template>

<style scoped>
a{
	text-decoration: none;
}

#banner{
	font-size: 20px;
	font-weight: 600;
	;
}

</style>
