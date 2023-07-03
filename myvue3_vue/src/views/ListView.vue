<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 목록</h1>
    <div class="btn-group">
      <router-link to="/user/save" class="btn btn-primary">사용자 추가</router-link>
    </div>
    <table class="table table-hover mt-3">
      <thead class="table-dark">
      <tr>
        <th>이름</th>
        <th>이메일</th>
        <th>가입날짜</th>
      </tr>
      </thead>
      <tbody>
      <tr class="cursor-pointer" v-for="row in result" :key="row.no" @click="$event=>href(row)">
        <td>{{row.name}}</td>
        <td>{{row.email}}</td>
        <td>{{row.regDate}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
import store from '../store';

export default {
  name:'ListView',
  data(){
    return{
      result:[ ]
    }
  },
  created() {
    this.getData();
  },
  methods:{
    getData(){
      axios.get('http://localhost:8082/findAll')
          .then(res=>{
            this.result=res.data.result;
            console.log('res>>', res);
          })

          .catch((err)=>{
            console.log(err)
          })
    },
    href(row){
      console.log('row>>', row)
      store.commit('setUser', row); //7강. 09'00
      //sessionStorage.setItem('setUser', row); //10강. 첨.
      sessionStorage.setItem('setUser', JSON.stringify(row)); //row가 object이라, 문자열려 변경해야.
      this.$router.push({name: 'SelectView'});
    }
  }
}
</script>
