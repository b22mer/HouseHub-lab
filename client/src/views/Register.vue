<script>
import feather from 'feather-icons';
import RegisterForm from '@/components/register/RegisterForm.vue';
import RegisterDetail from '@/components/register/RegisterDetails.vue';

export default {
	components: {
		RegisterForm,
		RegisterDetail,
	},
	data: () => {
		return {
			contacts: [
				{
					id: 1,
					name: 'Gangnam gu, Seoul-si, Repulic Of Korea',
					icon: 'map-pin',
				},
				{
					id: 2,
					name: 'SSAFY@ssafy.co.kr',
					icon: 'mail',
				},
				{
					id: 3,
					name: '02 1234 1234',
					icon: 'phone',
				},
			],
		};
	},
	mounted() {
		feather.replace();
	},
	updated() {
		feather.replace();
	},
	methods: {},
};
</script>

<template>
	<div
		class="container mx-auto flex flex-col-reverse md:flex-row py-5 md:py-10 md:mt-10"
	>
	<div><img src="../assets/images/banner_regist.png" style="width: 300px;"></div>
		
		
		
		<div id="registbox">
		<!-- Contact form -->
		<RegisterForm />

		<!-- Contact details -->
		<RegisterDetail :contacts="contacts" />

		</div>

	</div>
</template>

<style scoped>
#registbox{
	display: flex;
}
</style>