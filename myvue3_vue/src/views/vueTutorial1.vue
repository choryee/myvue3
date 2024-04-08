<template>
  <div>
    <h3>vueTutorial 1</h3>
    <h2>{{message}}</h2>
    <button @click="reverseMessage"> Reverse Message </button>
    <button @click="message +='i'"> Append i </button>
    <hr>
    <h2>{{count}}</h2>

<!--    <button @click="count +=5">Add</button>-->
    <button @click="addCount">Add</button>
  </div>

</template>

<script setup>
import {computed, ref} from "vue";
//message.value는 message 변수의 현재 값(value)에 접근하는 방법입니다.
// ref 함수는 객체를 반환하며, 이 객체의 value 속성에 현재 값이 저장되어 있습니다.
const message = ref('Hello World!');
const count = ref(0);

// const addNum=computed(count+5);
const addNum = computed(()=>count.value+5);

function addCount(){
  count.value = addNum.value;
}
function reverseMessage(){
  message.value=message.value.split('').reverse().join('');
}

</script>
<style>
button, a {
  display: block;
  margin-bottom: 1em;
}
</style>