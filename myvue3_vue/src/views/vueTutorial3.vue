<template>
  <div>
    <h3>vueTutorial 3</h3>
    <input type="text" v-model="aaa"/><br>
    {{aaa}}
    <br/>
    <h4>checkbox</h4>
    <input type="checkbox" v-model="checked"/>
    <label for=""> checked >> {{checked}} </label>
    <br/>
    <h4>---- select ------ </h4>
    <select name="" id="" v-model="selected">
      <option value="A">A</option>
      <option value=""> B</option>
      <option value="C">C</option>
      <option value="D">D</option>
    </select>
    <label for="">{{selected}}</label>

  </div>
</template>

<script setup>
import {ref}   from "vue";

const aaa = ref('');
const checked = ref(true);
const selected = ref('A')


</script>
<style>
.red {
  color: red;
}
</style>