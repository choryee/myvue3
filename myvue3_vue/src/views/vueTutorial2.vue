<template>
  <div>
    <h3>vueTutorial 2</h3>
    <p :class="{red: isRed}" @click="toggleRed">
      This should be red.. but click me to toggle it.
    </p>
    <p :style="{ color }" @click="toggleColor">
      This should be green, and should toggle between green and blue on click.
    </p>
  </div>

</template>

<script setup>
import {ref}   from "vue";

const message = ref('Hello World');
const isRed = ref(true);
const color = ref('green');

function toggleRed(){
  isRed.value = ! isRed.value;
}

function toggleColor(){
  color.value = color.value ==='green' ? 'blue' : 'yellow';
}

</script>
<style>
.red {
  color: red;
}
</style>