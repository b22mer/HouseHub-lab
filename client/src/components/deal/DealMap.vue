<template>
  <div class="dealMap">
 
    <div id="dealmap"></div>
       <div>
    <deal-select
          :dealInfo="dealInfo"
          :popInfo="popInfo"
          @child1="parents"
          @child2="getDetail"
          @child3="getFav">
          </deal-select>
    </div>
    </div>
</template>


<script>
import dealSelect from "./DealSelect.vue";
export default {
  components:{
dealSelect,
  },
  data(){
    return{
      dealInfo:{},
      popInfo:{},
      map:"",
      marker:"",
      infowindow:"",
      customOverlay:"",
      positions:[],
      mapOptions:{},
      temp:[],
      x:33.450701,
      y:126.570667,
    }
  },
 
  mounted() {
    window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
  },
  methods: {

    getDetail(deal){
      this.setCenter(deal.lat,deal.lng)
    },
    parents(deal){ 
      console.log("안녕!");
     for(let i=0; i<deal.length; i++){
        this.x=deal[0].lat;
        this.y=deal[0].lng;
        
        
        this.positions.push({
          title: deal[i].apartmentName,
          lating:new kakao.maps.LatLng(Number(deal[i].lat),Number(deal[i].lng))
        })
      }
      this.setCenter(this.x,this.y);
      this.kakaoDealListMarker();
    },

    getFav(deal){ 
      console.log("여기 맵인데 관심지역 조회까지 왔다!");
      console.log(deal);
      this.positions=[]
     for(let i=0; i<deal.length; i++){
        this.x=deal[0].lat;
        this.y=deal[0].lng;
         
        this.positions.push({
          title: deal[i].apartmentName,
          lating:new kakao.maps.LatLng(Number(deal[i].lat),Number(deal[i].lng))
        })
      }
      console.log( this.positions)
      
      this.initMap();
      this.setCenter(this.x,this.y);
      this.kakaoDealListMarker();
    },
    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=d162619984216a37e85bbf4799648857&libraries=services";
      document.head.appendChild(script);
    },
    initMap() {
      var mapContainer = document.getElementById("dealmap"); //지도를 담을 영역의 DOM 레퍼런스
      this.mapOptions = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
      };
this.map = new kakao.maps.Map( mapContainer,this.mapOptions); //지도 생성 및 객체 리턴
    this.kakaoDealListMarker();
   this.map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
    },

    kakaoDealListMarker(){

  var imageSrc = require("@/assets/images/Marker.png")
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(40, 50); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 


  for (var i = 0; i < this.positions.length; i ++) {
    


    
    // 마커를 생성합니다
        const marker = new kakao.maps.Marker({
        map: this.map, // 마커를 표시할 지도
        position: this.positions[i].lating, // 마커를 표시할 위치
        title : this.positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
  var content ='<div class="customoverlay">' +
                    `  <a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=${this.positions[i].title}" target="_blank">` +
                    `    <span class="title">${this.positions[i].title}</span>` +
                    "</div>";

 marker.setMap(this.map);

  const customOverlay = new kakao.maps.CustomOverlay({
    map: this.map,
    position: this.positions[i].lating,
    content: content,
    yAnchor: 0, 
  });

   customOverlay.setMap(this.map);
    
}
},
setCenter(x,y) {            
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(x,y);
    // 지도 중심을 이동 시킵니다
    this.map.setCenter(moveLatLon);
},
panTo(x,y) {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(x,y);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    this.panTo(moveLatLon);            
}    
  }
}

    

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >


.dealMap{
display: flex;

}

#dealmap{
  margin-top: 60px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  border-radius:5px;
  width: 700px; 
  height: 1045px;
  margin-left: auto; 


  /* 가운데로 가보자고~ */
}

#deal-title-bar{

  margin-top: 10px;
  margin-bottom: 10px;

}

.customoverlay {position:relative;bottom:85px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;}
.customoverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.customoverlay a {display:block;text-decoration:none;color:#000;text-align:center;border-radius:6px;font-size:14px;font-weight:bold;overflow:hidden;background: rgb(54,54,126);background: rgb(54,54,126) url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.customoverlay .title {display:block;text-align:center;background:#fff;margin-right:35px;padding:10px 15px;font-size:14px;font-weight:bold;}
.customoverlay:after {content:'';position:absolute;margin-left:-12px;left:50%;bottom:-12px;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
</style>