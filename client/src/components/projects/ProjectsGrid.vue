<script>
import feather from 'feather-icons';
// import ProjectsFilter from './ProjectsFilter.vue';
// import ProjectSingle from './ProjectSingle.vue';
// import projects from '../../data/projects';


// front-대문 페이지 whereismyhome, 타이틀 설정  
export default {
	//components: { ProjectSingle, ProjectsFilter },
	data: () => {
		return {
		//	projects,
			projectsHeading: 'Introduce',
			//selectedCategory: '',
			//searchProject: '',
		};
	},
	// computed: {
	// 	// Get the filtered projects
	// 	filteredProjects() {
	// 		if (this.selectedCategory) {
	// 			return this.filterProjectsByCategory();
	// 		} else if (this.searchProject) {
	// 			return this.filterProjectsBySearch();
	// 		}
	// 		return this.projects;
	// 	},
	// },
	// methods: {
	// 	// Filter projects by category
	// 	filterProjectsByCategory() {
	// 		return this.projects.filter((item) => {
	// 			let category =
	// 				item.category.charAt(0).toUpperCase() +
	// 				item.category.slice(1);
	// 			console.log(category);
	// 			return category.includes(this.selectedCategory);
	// 		});
	// 	},
	// 	// Filter projects by title search
	// 	filterProjectsBySearch() {
	// 		let project = new RegExp(this.searchProject, 'i');
	// 		return this.projects.filter((el) => el.title.match(project));
	// 	},
	// },
	mounted() {
		feather.replace();
	},
};
</script>

<template>
	<!-- Projects grid -->
	<section class="pt-0 sm:pt-0">
		<!-- Projects grid title -->
		<div class="text-center">
			<p
				class="font-general-semibold text-3xl sm:text-4xl font-semibold mb-2 text-ternary-dark dark:text-ternary-light"
			>
				{{ projectsHeading }}
			</p>
		</div>


		<!-- Filter and search projects -->
		<div class="mt-0 sm:mt-0">
			<h3
				class="font-general-regular
					text-center text-secondary-dark
					dark:text-ternary-light
					text-md
					sm:text-xl
					font-normal
					mb-0
				"
			>
			We always dream about the future.
			</h3>
			<hr>
			
			<!-- <img src="@/assets/images/front_logo1.png" alt=""> -->
			
			<div class="slider">
    <input type="radio" name="slide" id="slide1" checked>
    <input type="radio" name="slide" id="slide2">
    <input type="radio" name="slide" id="slide3">
    <input type="radio" name="slide" id="slide4">
    <ul id="imgholder" class="imgs">
        <li><img src="@/assets/images/front_logo1.png"></li>
        <li><img src="@/assets/images/front_logo2.png"></li>
        <li><img src="@/assets/images/front_logo3.png"></li>
        
    </ul>
    <div class="bullets">
        <label for="slide1">&nbsp;</label>
        <label for="slide2">&nbsp;</label>
        <label for="slide3">&nbsp;</label>
    </div>
</div>
			</div>
		
			



	</section>
</template>

<style scoped>

.slider{
    width: 1000px;
    height: 680px;
    position: relative;
    margin: 0 auto;
    overflow: hidden; /* 현재 슬라이드 오른쪽에 위치한 나머지 슬라이드 들이 보이지 않도록 가림 */
}
.slider input[type=radio]{
    display: none;
}

ul.imgs{
    padding: 0;
    margin: 0;
    list-style: none;    
}
ul.imgs li{
    position: absolute;
    left: 640px;
    transition-delay: 1s; /* 새 슬라이드가 이동해 오는 동안 이전 슬라이드 이미지가 배경이 보이도록 지연 */

    padding: 0;
    margin: 0;
}

.bullets{
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    bottom: 20px;
    z-index: 2;
}
.bullets label{
    display: inline-block;
    border-radius: 50%;
    background-color: rgba(0,0,0,0.55);
    width: 20px;
    height: 20px;
    cursor: pointer;
}
/* 현재 선택된 불릿 배경 흰색으로 구분 표시 */
.slider input[type=radio]:nth-child(1):checked~.bullets>label:nth-child(1){
    background-color: #037;
}
.slider input[type=radio]:nth-child(2):checked~.bullets>label:nth-child(2){
    background-color: #037;
}
.slider input[type=radio]:nth-child(3):checked~.bullets>label:nth-child(3){
    background-color:  #037;
}

.slider input[type=radio]:nth-child(1):checked~ul.imgs>li:nth-child(1){
    left: 0;
    transition: 0.5s;
    z-index:1;
}
.slider input[type=radio]:nth-child(2):checked~ul.imgs>li:nth-child(2){
    left: 0;
    transition: 0.5s;
    z-index:1;
}
.slider input[type=radio]:nth-child(3):checked~ul.imgs>li:nth-child(3){
    left: 0;
    transition: 0.5s;
    z-index:1;
}
.slider input[type=radio]:nth-child(4):checked~ul.imgs>li:nth-child(4){
    left: 0;
    transition: 0.5s;
    z-index:1;
}
</style>
