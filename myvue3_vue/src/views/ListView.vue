<template>
  <div class="container mt-3">
    <h5 class="display-5 text-center">사용자 목록</h5>
    <div class="btn-group">
      <router-link to="/user/save" class="display-5 btn btn-primary">
        <h4>사용자 추가</h4>
      </router-link>
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
      <tr class="cursor-pointer" v-for="row in result" :key="row.no" @click = "$event => href(row)">
<!--        `$event`는, 클릭된 이벤트 객체자체를 의미합니다.-->
<!--  `$event`는, Vue.js에서 이벤트 객체를 참조하는 특별한 변수입니다. 이벤트 핸들러 함수에서 이벤트 객체에 직접 접근해야 할 때 사용됩니다.-->
<!--   Vue.js에서 이벤트 핸들러에 대한 인자는 기본적으로 이벤트 객체입니다. 그러나 핸들러에서 이벤트 객체를 명시적으로 참조하기 위해 `$event`를 사용할 수 있습니다.
       이것은 Vue.js의 특수한 문법입니다.-->
<!--   예를 들어, 위의 코드에서 `@click="$event => href(row)"` 부분에서, `$event`는, 클릭 이벤트 객체를 의미합니다.-->
<!--  `href` 메서드는 클릭된 행에 대한 정보를 인자로 받습니다. `$event`는 클릭 이벤트 객체를 `href` 메서드에 전달하는 데 사용됩니다.-->
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
import apiCommon from "@/common/common";
import process from "@/common/process";

export default {
  name:'ListView',
  data(){
    return{
      result:[]
    }
  },
  created() {
    this.getData();
  },
  mounted() {
    //gainData();
  },
  methods:{
    async getData(){
      // axios.get('http://localhost:8082/findAll')
      //     .then(res=>{
      //       this.result = res.data.result;
      //       console.log('Listview.vue res>>', res);
      //     })
      //
      //     .catch((err)=>{
      //       console.log(err)
      //     })

//apiCommon.GET('/findAll')는, Promise를 반환하므로 결과를 받기 위해, .then() 또는 await를 사용해야 합니다.240405
      let gainData = await apiCommon.GET('/findAll');
      this.result = gainData.data.result;

      //console.log(' process.getList>>>', process.getList(gainData));


    },
    gainData(){
      //console.log(' process.getList>>>', process.getList(this.result));
    },
    href(row){
      console.log('Listview.vue row>>', row)
      store.commit('setUser', row); //7강. 09'00
      //sessionStorage.setItem('setUser', row); //10강. 첨.
      sessionStorage.setItem('setUser', JSON.stringify(row)); //row가 object이라, (JSON)문자열로 변경해야.
      // 콘솔창에 개인 데이터가 모두 보여, 그것을 암호화 하는 것. 10강. 1031
      // sessionStorage.setItem('setUser', this.base64(row)); //
      this.$router.push({name: 'SelectView'});
    },

    base64(user){
      return window.btoa(encodeURIComponent(JSON.stringify(user)))
    }
  }
}
</script>
