<template>
  <div class="container mt-3">
    <h1 class="display-5 text-center">사용자 수정</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="name" class="form-label">이름:</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" autocomplete="off" v-model="result.name" />
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" autocomplete="off" readonly v-model="result.email" />
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" autocomplete="off" v-model="result.pwd" />
      </div>
      <div class="d-flex">
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="gender" v-bind:value="true" v-model="result.gender" />
            <label class="form-check-label" for="radio1">남성</label>
          </div>
        </div>
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="gender" v-bind:value="false" v-model="result.gender" />
            <label class="form-check-label" for="radio2">여성</label>
          </div>
        </div>
      </div>
    </form>
    <div class="d-flex">
      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="save">저장</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="cancel">취소</button>
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";

export default {
  name:'UpdateView',
  data(){
    return{
      result:{}
    }
  },
  created() {
    this.result = this.$store.state.user;
  },
  methods:{
    save(){
      axios.post('http://localhost:8082/editById', this.result)
          .then(res=>{
            if(res.data.state===1){
              alert(res.data.message); // UserServiceImp.java에 내용 저장된 것 표출하는 것.
              this.$store.commit('setUser', this.result); //사용자 메인 화면에도 업데된 정보 가지게.8강.
              sessionStorage.setItem('setUser', JSON.stringify(this.result)); //10강. 07'31
             // sessionStorage.setItem('setUser', this.base64(res.data.result)); //10강.
              //this.$router.push({name:'SelectView'});
              this.cancel();
            }else {
              alert(res.data.message)
            }
          })
    },
    cancel(){
      this.$router.push({name: 'ListView'});
    },
    base64(user){
      return window.btoa(encodeURIComponent(JSON.stringify(user)))
    }
  }
}
</script>