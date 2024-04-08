<template>
  <div class="home">
    <router-link to="/user">사용자 목록 ← 왼쪽 글씨 클릭</router-link>
    <br/>
    <button type="button" @click="getData">클릭시 밑에 자료 출력됨.</button>
    <br/>
    <table style="border: 2px;">
      <tr v-if="serverData.result">
        <th>이름</th>
        <th>이메일</th>
        <th>비밀번호</th>
        <th>등록일</th>
      </tr>
      <tr v-for="r in serverData.result" :key="r.name">
        <td>{{r.name}}</td>
        <td>{{r.email}}</td>
        <td>{{r.pwd}}</td>
        <td>{{r.regDate}}</td>
      </tr>
    </table>

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
      state:false,
      serverData:[],
      message:''
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
