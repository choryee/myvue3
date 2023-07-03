spring boot+vue3 게시판 만들기(한국인)
230630. 아주 심한 장마인 제주에서. 내 인생아.

https://www.youtube.com/watch?v=PACW_Wmafns&list=PLfpRlCqycThkmL-HIcAf542NefEZtQFrV&index=2
https://github.com/vignekim/Shell/blob/main/Boot_VUE/vue-app/src/views/ListView.vue

서버 port 8082

-store, route 사용


//5강. 13'33
@DeleteMapping("/delete")
public ResultDTO delete(@RequestParam("no") int no){// RequestParam로 받을때는, 화면에서 밑처럼 데이터 보내야.
// const params={ 
//  params:{no:1}
//}
return userService.delete(no);
}

7강. 05'00에 리스트에서 개별리스트 클릭시, 주소창에 찍히는 query를 보내는 방법 설명.
이것은 주소창에 아뒤,pwd등이 노출되므로, vuex의 store라는 다른 방식으로 구현함.

store.commit('setUser', row); //7강. 09'00

sessionStorage.setItem('setUser', row); //10강. 첨.
sessionStorage.setItem('setUser', JSON.stringify(row)); //row가 object이라, 문자열(json형태로)로 변경해야.

const user=sessionStorage.getItem('setUser');
console.log((JSON.parse(user)); //10강.  이젠 위 json형태는 우리가 사용못하므로, 객체형태로 바꾸어야.