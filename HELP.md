
spring boot+vue3
https://www.youtube.com/watch?v=PACW_Wmafns&list=PLfpRlCqycThkmL-HIcAf542NefEZtQFrV&index=2
https://github.com/vignekim/Shell/blob/main/Boot_VUE/vue-app/src/views/ListView.vue

** myvue3 프로젝트(vue, java 모두 있음)(<-- Vue + Spring Boot 프로젝트 만들어 보기_11강)- vue3문법. 한국인 vue-springBoot연동 단순 게시판만 구현. mapper를 사용.
뷰단에서는 axios.post('http://localhost:8082/findAll')
서버에서는 @CrossOrigin(origins = "http://localhost:8080"<--vue현재 사용 포트에 대해 CORS헤제시켜줌)을 해줌.
mapper를 원초적인 자바 코드위에 @Select("select * from user3")써서 작성.

