<template>
  <div>
    name: <input type="text" v-model="name"/>
    <button @click="$emit('nameChanged', {name})"> EMIT!! </button>
  </div>
</template>

<script>
export default {
  name: "InputName",
  emits: ['nameChanged'],
  // emits: {
  //   nameChanged: (e) => {
  //     console.log(`e>>>${e.name}`)
  //     return e.name && typeof(e.name) === "string" && e.name.trim().length >= 3 ?
  //         true : false
  //   }
  // },
  data() {
    return {
      name: ''
    };
  }
}
</script>

<style scoped>

</style>
