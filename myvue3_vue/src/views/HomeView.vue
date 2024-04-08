<template>
  <div class="home">
    <h4 class="display-5 text-center">
<!-- to="/user"는 uri주소부분이 됨. sessionStorage저장은 리스트화면에서, 1개행이 선택된 게 저장됨.
     store.commit('setUser', row);나
     sessionStorage.setItem('setUser', JSON.stringify(row));는
     모두 ListView.vue에 있음. 240405
     자바 서버에 delete은 del=true로 업데하는 형식임.
-->
      <router-link to="/user">사용자 목록 ← (왼쪽 글씨 클릭)</router-link>
    </h4>
    <br/>
    <button type="button" @click="getData">클릭시 아래에 자료 출력됨.</button>
    <br/>
    <table style="border: 2px;">
      <tr v-if="serverData.studentList">
        <th>이름</th>
        <th>나이</th>
      </tr>
      <tr v-for="s in serverData.studentList" :key="s.name">
        <td>{{s.name}}</td>
        <td>{{s.age}}</td>
      </tr>
    </table>
    <br/>
    <div>
      <h6>---- store practice start----</h6>
      <p>User : {{ $store.state.user }}</p>
      <button @click="addUser('name:kim')">Add User</button>
      <h6>---- store practice end----</h6>
    </div>
  </div>

</template>

<script>
import axios from "axios";
import data from "bootstrap/js/src/dom/data";
import store from "../store";

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
  computed : {
    store() {
      return store
    }
  },

  data(){
    return {
      key:'',
      serverData:[],
      name:''
    }
  },

  methods:{
    getData(){
      axios.get('http://localhost:8082/findAll')
          .then(res=> {
            this.serverData = res.data;
            console.log('getData() res.data는>>>', res.data);
            console.log('this.serverData>>> ', this.serverData);
          })
          .catch((err)=>{
            console.log(err)
          })
    },
    addUser : function (value){
      this.$store.commit('setUser', value);
    }
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
