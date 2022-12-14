<template>
  <!-- dealSelect  statr-->
  <div class="dealSelect">




    

    <div id="btn-box">
    <div >
         <b-button
                    style="font-weight:bold; background-color: #037"
                    
                    @click="searchFavloc()"
                    >관심지역 조회 <img  style="display: inline; width: 18px; color:white;" src="@/assets/images/deal_dot.png" alt="" srcset=""></b-button
                >
</div>

    <div style="">
         <b-button
                    style="margin-left:2px;font-weight:bold; background-color: #037"
                    
                    @click="addFavloc()"
                    >관심지역 추가 <span style="font-size:15px">+</span></b-button
                >
      </div>

</div>
<!-- fix branch -->

    <div class="selectBox">
      <div>
        <select @change="selectSido($event)">
          <option value="">Si / Do</option>
          <option value="서울특별시">서울특별시</option>
          <option value="부산광역시">부산광역시</option>
          <option value="인천광역시">인천광역시</option>
          <option value="광주광역시">광주광역시</option>
          <option value="대전광역시">대전광역시</option>
          <option value="대구광역시">대구광역시</option>
          <option value="울산광역시">울산광역시</option>
          <option value="세종특별자치시">세종특별자치시</option>
          <option value="제주특별자치도">제주특별자치도</option>
          <option value="경기도">경기도</option>
          <option value="강원권">강원권</option>
          <option value="충청북도">충청북도</option>
          <option value="충청남도">충청남도</option>
          <option value="전라북도">전라북도</option>
          <option value="전라남도">전라남도</option>
          <option value="경상북도">경상북도</option>
          <option value="경상남도">경상남도</option>
        </select>
      </div>

      <div>
        <select @change="selectGugun($event)" v-model="selectedgugun">
          <option value="">Gu / Gun</option>
          <option
            v-for="gugun in guguns"
            :key="gugun.value"
            :value="gugun.value"
          >
            {{ gugun.text }}
          </option>
        </select>
      </div>

      <div>
        <select @change="selectDong($event)" v-model="selecteddong">
          <option value="">Dong</option>
          <option v-for="dong in dongs" :key="dong.value" :value="dong.value">
            {{ dong.text }}
          </option>
        </select>
      </div>

      <div>
        <select @change="selectYear($event)" v-model="selectedyear" id="year">
          <option value="">Year</option>
          <option value="2022">2022</option>
          <option value="2021">2021</option>
          <option value="2020">2020</option>
          <option value="2019">2019</option>
          <option value="2018">2018</option>
          <option value="2017">2017</option>
        </select>
      </div>

      <div>
        <select
          @change="selectMonth($event)"
          v-model="selectedmonth"
          id="month"
        >
          <option value="">Month</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
        </select>
      </div>
      
    </div>


<!--스크롤바 시작 -->
<div v-show="isList" id="scroller" style="overflow:scroll; width:600px; height:980px; overflow-x: hidden" class="mt-3">
<div v-if="info && info.length != 0">
<div v-for="(deal, index) in info"
              :key="index"
              :info="deal">
<b-card @click="openPopup(deal)"
    no-body
    :title="deal.apartmentName"
    style="max-width: 40rem;"
    img-src=http://placeimg.com/640/480/arch
    img-alt="Image"
    img-top
  >
   <table class="table">
                    <tbody>
                        <tr>
                            <td colspan="2" class="text-white" style="text-align:center; font-size:24px;  background-color: #037; color:#9999" >{{ deal.apartmentName }}</td>
  
                        </tr>
                        <tr>
                            <td class="text-secondary"><div id="deal-lst"><div ><img style="width:42px; heigt:42px" src="@/assets/images/deal_marker.png"></div><div style="padding-top:10px">주소</div></div></td>
                            <td style="padding-top:10px">{{ deal.roadName }}</td>
                        </tr>
                        <tr>
                            <td class="text-secondary">건축일자</td>
                            <td>{{ this.selectedyear }}년 {{ this.selectedmonth }}월</td>
                        </tr>
                        <tr>
                            <td class="text-secondary">층</td>
                            <td>{{ deal.floor }} 층</td>
                        </tr>
                        <tr>
                            <td class="text-secondary">면적</td>
                            <td>{{ deal.lng }} ㎡</td>
                        </tr>
                        <tr>
                            <td class="text-secondary">거래가</td>
                            <td>{{ deal.dealAmount }} 만원</td>
                        </tr>
                    </tbody>
                </table>
     

  </b-card>

</div>
</div>
<!--스크롤바 끝 -->
</div>

<!--  -->
<div v-show="isRec" id="scroller" style="overflow:scroll; width:600px; height:980px; overflow-x: hidden" class="mt-3">
<div v-if="starinfo && starinfo.length != 0">
<div v-for="(deal, index) in starinfo"
              :key="index"
              :starinfo="deal">
<b-card @click="openPopup(deal)"
    no-body
    :title="deal.apartmentName"
    style="max-width: 40rem;"
    img-src=http://placeimg.com/640/480/arch
    img-alt="Image"
    img-top
  >
   <table class="table">
                    <tbody>
                        <tr>
                            <td colspan="2" class="text-white" style="text-align:center; font-size:24px;  background-color: #037; color:#9999" >{{ deal.apartmentName }}</td>
          
                        </tr>
                        <tr>
                            <td class="text-secondary"><div id="deal-lst"><div ><img style="width:42px; heigt:42px" src="@/assets/images/deal_marker.png"></div><div style="padding-top:10px">주소</div></div></td>
                            <td> {{ deal.roadName }}</td>
                        </tr>
                       
                        <tr>
                            <td class="text-secondary">   층수</td>
                            <td>{{ deal.floor }} 층</td>
                        </tr>
                        <tr>
                            <td class="text-secondary">면적</td>
                            <td>{{ deal.lng }} ㎡</td>
                        </tr>
                        <tr>
                            <td class="text-secondary">거래가</td>
                            <td>{{ deal.dealAmount }} 만원</td>
                        </tr>
                    </tbody>
                </table>
     

  </b-card>

</div>
</div>
<!--스크롤바 끝 -->
</div>

<!-- <table class="table">
                    <tbody>
                        <tr>
                            <td colspan="2" class="text-white" style="text-align:center; font-size:24px;  background-color: #037; color:#9999" >dd</td>
          
                        </tr>
                        <tr>
                            <td colspan="1" style="font-weight: bold; font-size:18px" class="text-secondary">주소<font-awesome-icon icon="fas fa-map-marker-alt" /></td>
                            <td>dd</td>
                        </tr><font-awesome-icon icon="fas fa-map-marker-alt" />
                        <tr>
                            <td  style="font-weight: bold; font-size:18px" class="text-secondary">건축일자</td>
                            <td>ddddddddddddd</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold; font-size:18px" class="text-secondary">층</td>
                            <td>ddddd</td>
                        </tr>
                        <tr>
                            <td  style="font-weight: bold; font-size:18px" class="text-secondary">면적</td>
                            <td>ddd ㎡</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold; font-size:18px" class="text-secondary">거래가</td>
                            <td>dd만원</td>
                        </tr>
                    </tbody>
                </table> -->
    <!--  -->

    
  </div>
</template>


<script>
//import { eventBus }  from "main.js"
import http from "@/api/http";
//import DealMap from "../deal/DealMap.vue";
export default {
  name: "dealSelect",
  components: {
   
  },
  data() {
    return {
      isRec:false,
      isList:false,
      isOk:false,
      details: {},
      popupView: false,
      selectedsido: "",
      selectedgugun: "",
      selecteddong: "",
      selectedyear: "",
      selectedmonth: "",
      recLoc:"",
      info: [],
      starinfo:[],
      guguns: [{ value: null, text: "시/군을 선택해주세요" }],
      dongs: [{ value: null, text: "동을 선택해주세요" }],
    };
  },
  methods: {

    favInfo(deal){
    console.log("관심지역 내역!"+deal);
     this.$emit('child3',deal) //자식 컴포넌트가 부모컴포넌트에게 데이터전달을 하기 위한 것. 
  },

    searchFavloc(){
        http
        .get(`favorite/myfavdong`)
        .then(({ data }) => {
              this.starinfo = data.body;
              if(this.starinfo.length!=0){
                  console.log(this.starinfo[0]);
                  this.favInfo(this.starinfo);
                  this.isRec=true;
                  this.isList=false;
                  
                  alert(this.starinfo.length+"건 조회 완료!");
              }else{
                  console.log("관심지역을 설정하지 않았습니다. 설정해보세요!");
              }
          });
    }
    ,
    addFavloc(){
      if(this.recLoc!=""){
           http
        .post(`favorite/favdong`,{dongCode: this.recLoc})
        .then(({ data }) => {
              this.starinfo = data.body;
              console.log(this.starinfo);
              alert("관심지역이 추가되었습니다.");
          });
      }else{
        alert("아직 지역이 선택되지 않았습니다.")
      }
    }
    ,
    // 시도를 선택 -> 구군 추출
    selectSido(event) {
      this.selectedsido = event.target.value;
      console.log(event.target.value);
      http
        .post(`house/gugun`, { sidoName: event.target.value })
        .then(({ data }) => {
          console.log("selectsido 입성!");

          this.guguns = [];
          data.body.forEach((gugun) => {
            this.guguns.push({
              value: gugun,
              text: gugun,
            });
          });
          console.log(this.guguns);
        });
    },

    // 구군을 선택 -> 동 추출
    selectGugun(event) {
      console.log(event.target.value);
      console.log(this.selectedsido);
      http
        .post(`house/dong`, {
          sidoName: this.selectedsido,
          gugunName: event.target.value,
        })
        .then(({ data }) => {
          console.log("selectgugun 입성!");
          console.log(data);
          this.dongs = [];
          data.body.forEach((dong) => {
            this.dongs.push({
              value: dong,
              text: dong,
            });
          });
          console.log(this.dongs);
        });
    },

    // 선택된 동 저장
    selectDong(event) {
      this.selecteddong = event.target.value;
    },

    // 선택된 년 저장
    selectYear(event) {
      this.selectedyear = event.target.value;
    },

    //선택된 달 저장
    selectMonth(event) {
      this.selectedmonth = event.target.value;
      this.searchDeal();
    },

    // 정보 검색 추출
    searchDeal() {
      console.log("건물정보 검색 입성!");
      http
        .post(`house/dealinfo`, {
          sidoName: this.selectedsido,
          gugunName: this.selectedgugun,
          dong: this.selecteddong,
          year: this.selectedyear,
          month: this.selectedmonth,
        })
        .then(({ data }) => {
          this.info = data.body;
          this.editInfo();
          if (this.info.length == 0){
          alert("해당 조건의 거래가 존재하지 않습니다.");
          }else{
            this.recLoc=this.info[0].dongCode;
                  this.isRec=false;
                  this.isList=true;
            alert(this.info.length + "건의 매매정보가 조회되었습니다.")
          
          }

            
          
        });
    },



    editInfo(){
    console.log("dsdsd");
     console.log(this.info);
     this.$emit('child1',this.info) //자식 컴포넌트가 부모컴포넌트에게 데이터전달을 하기 위한 것. 
  },

    openPopup(deal){
    console.log("popupInfo");
    console.log(deal);
    this.$emit('child2',deal) //자식 컴포넌트가 부모컴포넌트에게 데이터전달을 하기 위한 것. 
  },

    closePopup() {
      //this.popupView = this.popupView ? false : true;
      this.details = {};
    },
  },
};
</script>


<style scoped>
@import url(https://fonts.googleapis.com/css?family=Roboto+Slab:400,700);
body {
  text-align: center;
  padding: 24px 24px 96px;
  font-family: 'Roboto Slab', serif;
}

h1, h2 {
  margin-bottom: 48px;
  font-weight: normal;
}

.button {
  width: auto;
  display: inline-block;
  padding: 0 18px 0 6px;
  border: 0 none;
  border-radius: 5px;
  text-decoration: none;
  transition: all 250ms linear;
}
.button:hover {
  text-decoration: none;
}

.button--social-login {
  margin-bottom: 12px;
  margin-right: 12px;
  color: white;
  height: 50px;
  line-height: 46px;
  position: relative;
  text-align: left;
}
.button--social-login .icon {
  margin-right: 12px;
  font-size: 24px;
  line-height: 24px;
  width: 42px;
  height: 24px;
  text-align: center;
  display: inline-block;
  position: relative;
  top: 4px;
}
.button--social-login .icon:before {
  display: inline-block;
  width: 40px;
}
.button--social-login .icon:after {
  content: "";
}

.button--bitbucket {
  background-color: #205081;
  border: 1px solid #163758;
}
.button--bitbucket .icon {
  border-right: 1px solid #163758;
}
.button--bitbucket .icon:after {
  border-right: 1px solid #2a69aa;
}
.button--bitbucket:hover {
  background-color: #1b436d;
}

.button--dropbox {
  background-color: #007DE1;
  border: 1px solid #0061ae;
}
.button--dropbox .icon {
  border-right: 1px solid #0061ae;
}
.button--dropbox .icon:after {
  border-right: 1px solid #1597ff;
}
.button--dropbox:hover {
  background-color: #006fc8;
}

.button--facebook {
  background-color: #4b70ab;
  border: 1px solid #3b5988;
}
.button--facebook .icon {
  border-right: 1px solid #3b5988;
}
.button--facebook .icon:after {
  border-right: 1px solid #6b8bbe;
}
.button--facebook:hover {
  background-color: #436499;
}

.button--flickr {
  background-color: #FF0084;
  border: 1px solid #cc006a;
}
.button--flickr .icon {
  border-right: 1px solid #cc006a;
}
.button--flickr .icon:after {
  border-right: 1px solid #ff339d;
}
.button--flickr:hover {
  background-color: #e60077;
}

.button--github {
  background-color: #333;
  border: 1px solid #1a1a1a;
}
.button--github .icon {
  border-right: 1px solid #1a1a1a;
}
.button--github .icon:after {
  border-right: 1px solid #4d4d4d;
}
.button--github:hover {
  background-color: #262626;
}

.button--google {
  background-color: #3F85F4;
  border: 1px solid #0f66f1;
}
.button--google .icon {
  border-right: 1px solid #0f66f1;
}
.button--google .icon:after {
  border-right: 1px solid #6fa4f7;
}
.button--google:hover {
  background-color: #2776f3;
}

.button--googleplus {
  background-color: #DD4B39;
  border: 1px solid #c23321;
}
.button--googleplus .icon {
  border-right: 1px solid #c23321;
}
.button--googleplus .icon:after {
  border-right: 1px solid #e47365;
}
.button--googleplus:hover {
  background-color: #d73925;
}

.button--linkedin {
  background-color: #0087be;
  border: 1px solid #00638b;
}
.button--linkedin .icon {
  border-right: 1px solid #00638b;
}
.button--linkedin .icon:after {
  border-right: 1px solid #00abf1;
}
.button--linkedin:hover {
  background-color: #0075a5;
}

.button--microsoft {
  background-color: #00A4EF;
  border: 1px solid #0081bc;
}
.button--microsoft .icon {
  border-right: 1px solid #0081bc;
}
.button--microsoft .icon:after {
  border-right: 1px solid #23baff;
}
.button--microsoft:hover {
  background-color: #0093d6;
}

.button--openid {
  background-color: #F78C40;
  border: 1px solid #f56f0f;
}
.button--openid .icon {
  border-right: 1px solid #f56f0f;
}
.button--openid .icon:after {
  border-right: 1px solid #f9a971;
}
.button--openid:hover {
  background-color: #f67d28;
}

.button--soundcloud {
  background-color: #FF5500;
  border: 1px solid #cc4400;
}
.button--soundcloud .icon {
  border-right: 1px solid #cc4400;
}
.button--soundcloud .icon:after {
  border-right: 1px solid #ff7733;
}
.button--soundcloud:hover {
  background-color: #e64d00;
}

.button--spotify {
  background-color: #2EBD59;
  border: 1px solid #249446;
}
.button--spotify .icon {
  border-right: 1px solid #249446;
}
.button--spotify .icon:after {
  border-right: 1px solid #4bd374;
}
.button--spotify:hover {
  background-color: #29a84f;
}

.button--twitter {
  background-color: #3B94D9;
  border: 1px solid #257abc;
}
.button--twitter .icon {
  border-right: 1px solid #257abc;
}
.button--twitter .icon:after {
  border-right: 1px solid #66abe1;
}
.button--twitter:hover {
  background-color: #2988d2;
}



#deal-lst{
  display: flex
}

#btn-box{
  display: flex;
  margin-left: 55%;
  width: 350px;
}
#scroller::-webkit-scrollbar {
   overflow-y:hidden;
  }

#detail-img{
  border-radius: 5px;
}
#detail-title{
  font-size: 24px;
}
table {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;

}
table thead th {
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #369;
  border-bottom: 3px solid #036;
}
table tbody th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #f3f6f7;
}
table td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}
.detail-list-box {
  /* margin-top: 30px; */
  display: flex;
}

#detail-list-box-info {
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  background: #fff;
  border-radius: 5px;
  width: 500px;
  height: 500px;

}

#detail-list-box-list {
  width: 700px;
  margin-right: 40px;
}
.dealSelect{
   display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: 10px;
  

}
.selectBox {
  display: flex;
  width: 630px;
  justify-content: space-evenly;
  margin-top: 20px;
}

select {
  width: 110px; 
  padding: .8em .5em; /* 여백으로 높이 설정 */
  color: white;
  font-weight: 500;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgb(46,49,126);
  /* background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; 네이티브 화살표 대체   */
  border: 2px solid rgb(46,49,126);
  border-radius: 5px; /* iOS 둥근모서리 제거 */
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  appearance: none;
}

#list-btn {
  border-radius: 5px;
  border: 2px solid lightskyblue;
  background-color: lightskyblue;
  font-weight: bold;
  height: 42px;
  font-size: 12px;
  padding: 2px;
}
.popup-view {
  opacity: 0;
  display: none;
  visibility: hidden;
}
.active {
  opacity: 1;
  display: block;
  visibility: visible;
}
</style>

