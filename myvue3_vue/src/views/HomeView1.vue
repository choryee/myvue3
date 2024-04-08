<template>
  <div class="home">
    <router-link to="/user">사용자 목록 ← 왼쪽 글씨 클릭</router-link>
    <h3>이 페이지는 HomeView.vue 임.</h3>
      <br/>
    <button @click="getData">여기 클릭해서, 저장된 테이터를 밑에 출력..</button>
    <hr/>
    <div>
      <tr v-for="r in serverData.result" :key="r.name">
        <td>{{r.name}}</td>
        <td>{{r.email}}</td>
        <td>{{r.regDate}}</td>
      </tr>
    </div>



  </div>
</template>

<script>


import axios from "axios";
import data from "bootstrap/js/src/dom/data";

const uForm={
  no:2,
  name:'테스트3',
  email:'3@naver.com',
  pwd:'2345',
  gender: true
}

const params={
  params:{no:1}
}
export default {
  name: 'HomeView',
  data(){
    return{
      serverData:[],
    }

  },

  methods:{
    getData(){
      axios.get('http://localhost:8082/findAll')
          .then(res=> {
            this.serverData=res.data;
            console.log('res.data는>>>', res.data);
          })
          .catch((err)=>{
            console.log(err)
          })
    },
    // getData1(){
    //   axios.get('http://localhost:8082/findAll')
    //       .then((res)=>{console.log('res>>', res)
    //       })
    //       .catch((err)=>{
    //         console.log(err)
    //       })
    // },
  }
}
</script>

<style scoped>
a {
  color:black;
  text-decoration: none;
  font-weight: bold;
  font-size: 30px;
}
</style>
