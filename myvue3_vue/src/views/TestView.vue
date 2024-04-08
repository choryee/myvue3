<template>
  <div>
    count : {{count}}
    <br/>
    doubleCount : {{doubleCount}}
    <button type="button" @click="increment">수 증가버튼</button>
    <br/>
    <hr/>

    <div>
     <form  @click.prevent="inputSubmit">
        이름: <input type="text" v-model="name" placeholder="Input your name"/>
        나이: <input type="text" v-model="age" placeholder="Input your age"/>
        <button type="submit">제출</button>
     </form>
    </div>
    <hr/>

      <div>
        <button type="button" @click="addData">객체추가</button>

        <div  v-if="data.length">
          <tr >
            <th>이름</th>
            <th>나이</th>
          </tr>
          <tr v-for="d in data" :key="d.name">
            <td>{{d.name}}</td>
            <td>{{d.age}}</td>
          </tr>
        </div>
      </div>
  </div>
</template>

<script>
import {ref, reactive, computed, watch} from 'vue';

export default{

  setup(){
    const name = ref('');
    const age = ref('');
    const count = ref(0);
    const data = reactive([{ // 여기 객체 속성이 변경되면, 자동으로 화면을 업데이트함.
      name: '',
      age: ''
    }])
    //버튼 클릭을 통해 count 값이 변경되고 이에 따라 doubleCount 값도 업데이트됩니다
    const doubleCount = computed(()=> count.value*2);

    // const data=([{// 이렇게 해도 받아 오긴 함. 하지만, 화면 업데가 안 되, 바로 안 보임.
    //   name: '',
    //   age: ''
    // }])
    const increment=()=>{
      count.value++;
    }

    const added={name: 'added', age: 28};
    //위 코드에서 addData 메서드는 setup 함수 내에서 정의되어 있으며,
    // 최종적으로 return 문에서 반환되도록 설정되어 있습니다.
    // 이렇게 하면 템플릿 내에서 해당 메서드를 @click 디렉티브를 통해 호출할 수 있게 됩니다.
    const addData=()=>{ // 이 함수를 위 버튼에서 쓸려면, 밑에 return에서 리턴해야.
      console.log('addData 클릭함...');
      data.push(added);
    }

    const inputSubmit=()=>{
      data.push({name:name.value, age:age.value });
      name.value='';
      age.value='';
    }


    // watch(count, (newCount, oldCount)=>{ //count의 변화를 감지하면서, 전의 값을 oldCount에, 나중 값을 newCount에
    //   console.log(`count changed from ${oldCount} to ${newCount}`)
    // })
    // watch(data, (preData, nowData)=>{
    //   console.log(`data changed from ${preData.length} to ${nowData.length}`)
    // })

    return {
      name, age, count, data, doubleCount, increment,addData, inputSubmit
    }
  }//-- setup()

}


</script>