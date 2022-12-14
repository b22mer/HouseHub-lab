<script>
import feather from 'feather-icons';

export default {
	name: 'Home',
	data: () => {
		return {
			theme: '',
		};
	},
	created() {
		this.theme = localStorage.getItem('theme') || 'light';
	},
	mounted() {
		feather.replace();
		this.theme = localStorage.getItem('theme') || 'light';
	},
	updated() {
		feather.replace();
	},
	methods: {},
};
</script>

// 1. 페이지 배너 vue
// 홈 페이징 중단 디자인 담당


<template>
	<section
		class="flex flex-col sm:justify-between items-center sm:flex-row mt-12 sm:mt-10"
	>
		<!-- Banner left contents -->
		<div class="w-full md:w-1/3 text-left">
			<h1
				class="font-general-semibold text-3xl md:text-3xl xl:text-4xl text-center sm:text-left text-ternary-dark dark:text-primary-light uppercase"
			>
				where Is Myhome company
			</h1>
			<p
				class="font-general-medium mt-2 text-lg sm:text-xl  xl:text-2xl text-center sm:text-left leading-none text-gray-400"
			>
			Having my own home is no longer a dream.
			</p>
			<div class="flex justify-center sm:block">
				<router-link
				to="/deal"
					class="flex justify-center items-center w-36 sm:w-48 ml-5 mt-12 mb-6 sm:mb-0 text-lg border border-indigo-900 dark:border-ternary-dark py-2.5 sm:py-3 shadow-lg rounded-lg bg-indigo-900 focus:ring-1 focus:ring-indigo-900 hover:bg-indigo-800 text-gray-500 hover:text-white duration-500"
					aria-label="Download Resume"
				>
					<i
						data-feather="arrow-down-circle"
						class="ml-0 text-white sm:ml-1 mr-2 sm:mr-3 w-5 sm:w-6 duration-100"
					></i>
					<span
						class="text-sm sm:text-lg text-white font-general-medium duration-100"
						>Find House</span
					></router-link
				>
			</div>
		</div>

		<!-- Banner right illustration -->
		<div class="w-full md:w-2/3 text-right float-right">
			<img
				v-if="theme === 'light'"
				src="@/assets/images/home_pic6.png"
				alt="Developer"
			/>
			<img
				v-else
				src="@/assets/images/developer-dark.svg"
				alt="Developer"
			/>
		</div>
	</section>
</template>

<style scoped>

a{
	text-decoration: none;
}
</style>
