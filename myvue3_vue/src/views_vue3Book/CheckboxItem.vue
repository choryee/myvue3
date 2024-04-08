<template>
    <li>
        <input type="checkbox" v-model="checked" /> {{fName}}
    </li>
    {{}}
</template>

<script>
    export default {
        name : "CheckboxItem",
        props : ['fName', 'fChecked', 'fPrice', 'newMember'],
        data() {
            return {
                checked: this.fChecked,
                price : this.fPrice,
                oldMember :[
                  {name: 'kim', age:12},
                  {name:'jon', age:30}
                ]
            };
        }
    }
</script>

<style scoped>

</style>