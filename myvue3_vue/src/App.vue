<template>
  <router-view/>
</template>

<script>
export default {

  created() {
    const user = sessionStorage.getItem('setUser');
    console.log('App.vue JSON.parse(user)>>', JSON.parse(user));
      if(user){
        console.log('App.vue 사용자정보가 있습니다');
        this.$store.commit('setUser', JSON.parse(user) ); // JSON.parse(user)는 JSON->객체로 만드는 것. 왜냐면, 객체여야 사용 가능하므로.
        console.log(user, this.base64(user)); //10강.
      }else {
        console.log('App.vue if-else 사용자정보가 없습니다')
      }
  },
   methods:{
    base64(user){
      return JSON.parse(decodeURIComponent(window.atob(user))); //JSON.parse은 JSON-->객채로 만드는 것.
    }

   }
}
</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script setup>
</script>