<template>
  <div>
    <CheckboxItem v-for="f in idols" :key="f.id" :fName="f.name" :fChecked="f.checked" :fPrice="f.price" :fNewMember="newMember"/>
    <select id="selectId" name="selectName" onchange="getSelected(event)">
<!--    <select id="selectId" name="selectName" >-->
      <option value="A">A</option>
      <option value="B">B</option>
      <option value="C">C</option>
    </select>
    <br/>
    <input type="checkbox" checked name="checkName" /> test
    <br/>
    {{updatedPrices}}
    <br/>
    {{showNewMember}}
    <li v-for="a in newMember" :key="a.nickName" >{{a.nickName}}</li>
    <br/>
    <InputName @nameChanged="nameChangeHandler"/>
    emitted data from InputName : {{parentName}}

  </div>

</template>

<script>
import CheckboxItem from "../views_vue3Book/CheckboxItem.vue";
import InputName from "@/views_vue3Book/InputName.vue";


export  default {
  name:'vueTutorialFour',
  components:{InputName, CheckboxItem},
  data(){
    return {
      idols : [
        {id:1, name:'banana', checked: false, price:1000},
        {id:2, name:'orange', checked: true,  price:1200},
        {id:3, name:'apple', checked: false,  price:1700},
        {id:4, name:'pear', checked: false,  price:700}
      ],
      newMember:[],
      parentName:''
    }
  },
  created() {
    this.addNewMember();
  },
  computed:{
    updatedPrices(){
      return this.idols.map(a => a.price+1);
    },

    showNewMember(){
      //return this.newMember.forEach(a=>console.log(`added>>${a.nickName}`));
      return this.newMember;
    }
  },
  mounted() {

    // HTML 속성으로 직접 이벤트 핸들러를 설정할 때, 사용할 함수를 전역 범위에 등록
    window.getSelected = this.getSelected;

    let selectId = document.querySelector('#selectId');
    selectId.addEventListener('change', function (e){
      console.log(`e>>${e.target.value}`)
    })
  },
  methods: {
    nameChangeHandler(e){
      console.log(`from nameChangeHandler>>${e.name}`)
      this.parentName = e.name;
    },
    addNewMember(){
      return this.idols.map(item => this.newMember.push(({nickName : item.name})))
    },
    getSelected(event) {
      //let chkElement = document.querySelector('input[name='checkName']:checked');
      let chkElement = document.querySelector('input[name="checkName"]:checked').value;
      let selectElementValue = document.querySelector('select[name="selectName"]').value;
      let targetSelectedValue = event.target.value;
      console.log(`selectElementValue>> ${selectElementValue}`);
      console.log(`targetSelectedValue>> ${targetSelectedValue}`);
      console.log(`checkbox>>${chkElement}`)

      // selectElement.addEventListener('change', function(event) {
      //   let selectedOption = event.target.value;
      //   console.log(`selected option: ${selectedOption}`);
      // });
    }// getSelected(event)





  } //methods

}
</script>

<style>
.red {
  color: red;
}
</style>