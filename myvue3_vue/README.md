spring boot+vue3 게시판 만들기(한국인)
230630. 아주 심한 장마인 제주에서. 내 인생아.

https://www.youtube.com/watch?v=PACW_Wmafns&list=PLfpRlCqycThkmL-HIcAf542NefEZtQFrV&index=2
https://github.com/vignekim/Shell/blob/main/Boot_VUE/vue-app/src/views/ListView.vue

서버 port 8082
cd myvue3_vue/ 해서, npm run serve하고,
인텔리J에서는 그 서버 삼각형클릭해 구동함.
http://localhost:8080 를 통해, http://localhost:8082/맵핑주소 가 보임.
 
mapper를 사용.
뷰단에서는 axios.post('http://localhost:8082/findAll')
서버에서는 @CrossOrigin(origins = "http://localhost:8080"<--vue현재 사용 포트에 대해 CORS헤제시켜줌)을 해줌.
mapper를 원초적인 자바 코드위에 @Select("select * from user3")써서 작성.

-store, route 사용


UserDaoImp.java - UserDao인터페이스에 선언된 것을 재정의해서 사용. 여기에 UserMapper.java정의된 것 Autowired해서 사용함.
UserServiceImp.java - UserService 인터페이스에서 선언된 것을 재정의해서 사용. 여기에, UserDao를 autowired에서 사용해, CRUD 서비스를 실제로 구현 하는 것.


//5강. 13'33
@DeleteMapping("/delete")
public ResultDTO delete(@RequestParam("no") int no){// RequestParam로 받을때는, 화면에서 밑처럼 데이터 보내야.
// const params={ 
//  params:{no:1}
//}
return userService.delete(no);
}

7강. 05'00에 리스트에서 개별리스트 클릭시, 주소창에 찍히는 query를 보내는 방법 설명.
query는 컴퓨터용어로, 데이터를 받기위해 보내는 질의/요구 라는 뜻.
이것은 주소창에 아뒤,pwd등이 노출되므로, vuex의 store라는 다른 방식으로 구현함.

store.commit('setUser', row); //7강. 09'00

//10강. sessionStorage 사용해 세션 저장 및 세션 암호화로 보안 강화.
sessionStorage.setItem('setUser', row); //10강. 첨.
- $store에 저장된 것이, 다른 페이지가 가면, 그 가져온 정보를 버리므로, 세션을 유지할 필요가 있어서.
sessionStorage.setItem('setUser', JSON.stringify(row)); //row가 objec(사용 못하는 형태의 object로 브라우저에 찍힘.)이라, 문자열(json형태로)로 변경해야.

const user=sessionStorage.getItem('setUser');
console.log((JSON.parse(user)); //10강.  이젠 위 json형태{"name": "kim"}는 우리가 사용을 못하므로, 객체형태{name: "kim"}로 바꾸어야.
