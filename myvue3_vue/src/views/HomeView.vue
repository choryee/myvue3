<template>
  <div class="home">
    <router-link to="/user">사용자 목록-- 클릭</router-link>
      <br/>
    <button @click="getData">call data</button>

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
      serverdata:[],
    }

  },

  methods:{
    // getData(){
    //   axios.get('http://localhost:8082/findAll')
    //       .then(res=>res.data)
    //       .then(data=>{
    //         this.serverdata=data;
    //       })
    //       .catch((err)=>{
    //         console.log(err)
    //       })
    // },
    getData1(){
      axios.get('http://localhost:8082/findAll')
          .then((res)=>{console.log('res>>', res)
          })
          .catch((err)=>{
            console.log(err)
          })
    },
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
