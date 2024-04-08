vue3문법.
- vue로 게시판 만들기임.

여기 밑부분에 각 강의별 설명 있음.

app.js:269 Uncaught SyntaxError: Unexpected token 'J', "JTdCJTIybm"... is not valid JSON
at JSON.parse (<anonymous>)
위 이런 뜨면,F12/application/Session storage에서 세션 제거하면 됨.
------------
vueTutorialFour.vue에 연습.240318

------------
axios를 모듈로 구성 성공함.240405
<--이건 axios 실무 설정.txt를 보라.

------------

spring boot+vue3
https://www.youtube.com/watch?v=PACW_Wmafns&list=PLfpRlCqycThkmL-HIcAf542NefEZtQFrV&index=2
https://github.com/vignekim/Shell/blob/main/Boot_VUE/vue-app/src/views/ListView.vue

-- 구동
화면 myvue3/myvue3_vue 폴더에서 npm run serve
서버 Myvue3Application.java에서 삼각형 클릭 <--annotation등이 없다고, 빨간색으로 나오면, gradle로 빌드해보라. 2403218

'클릭시 밑에 자료 출력됨'. <--이게 작동할려면, // @GetMapping("/findAll") StudentDatabaseController.java에서 풀어야.
'사용자 목록 ← (왼쪽 글씨 클릭)'' <--이게 작동할려면, // @GetMapping("/findAll") DataController.java에서 풀어야.
-------------
뷰화면은 router/index.js를 보라
-------------

** myvue3 프로젝트(vue, java 모두 있음)(<-- Vue + Spring Boot 프로젝트 만들어 보기_11강)- vue3문법.
한국인 vue-springBoot연동 단순 게시판만 구현. mapper를 사용.
뷰단에서는 axios.post('http://localhost:8082/findAll')
서버에서는 @CrossOrigin(origins = "http://localhost:8080"<--vue현재 사용 포트에 대해 CORS헤제시켜줌)을 해줌.
mapper를 원초적인 자바 코드위에 @Select("select * from user3")써서 작성.

===========================================
spring boot+vue3 게시판 만들기(한국인)
230630. 아주 심한 장마인 제주에서.
마지막 강의 도커는 어려워서 다시 봐야.

https://www.youtube.com/watch?v=PACW_Wmafns&list=PLfpRlCqycThkmL-HIcAf542NefEZtQFrV&index=2
https://github.com/vignekim/Shell/blob/main/Boot_VUE/vue-app/src/views/ListView.vue

-----------------
소켓서버 시 포트 8083

app.js:269 Uncaught SyntaxError: Unexpected token 'J', "JTdCJTIybm"... is not valid JSON
at JSON.parse (<anonymous>)
위 이런 뜨면,F12/application/Session storage에서 세션 제거하면 됨.


1. 현재 MyVue3Application.java로 서버 실행,
위와 같은 인텔리j안에 AboutView.vue에서 클 실행. but 소켓통신은 안 됨.

-----------------
** 서버 구동방법
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


-------
11강. 프로젝트 배포
docker-compose.yml파일은, 밑의 두개의 docker file를 yml파일을 실행만으로 돌리게 하는 것.


vue폴더에서 docker file 생성하기.
FROM node:latest as builder  # Docker Image중 Node 최신버전을 다운로드후 사용

WORKDIR /app  # Project 파일 작업할 위치 설정
COPY package.json ./  # Project에 필요한 Module 받기 위해서 package.json 파일 먼저 복사
RUN yarn install  # Module 다운로드하여 Project 환경 설정
COPY . .  # Project 파일 전부 복사
RUN yarn run build  # Project Build 하기

FROM nginx:latest  # Docker Image NginX 사용
#COPY --from=builder /app/dist /usr/share/nginx/html  # 기본으로 사용 시 기본 위치에 복사
COPY --from=builder /app/dist /app  # nginx.conf 파일 사용시 특정 위치에 복사
COPY nginx.conf /etc/nginx/nginx.conf  # Vue의 SPA 단점으로 새로 고침시 404 에러 해결를 위한 설정파일
EXPOSE 80  # Port 80 허용하기

------
spring boot프로젝트에서 docker file생성하기.

FROM gradle:latest as builder  # Docker Image Gradle 사용

WORKDIR /app  # Project 파일 작업할 위치 설정
COPY . .  # Project 파일 전부 복사 하기
RUN ./gradlew bootJar  # Gradle Build 하기

FROM openjdk:latest  # Docker Image OpenJDK 사용
COPY --from=builder /app/build/libs/ /app  # Gradle Build한 파일 복사해 오기

EXPOSE 8080  # Port 8080 허용하기
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=prod", "/app/app.jar" ]
# Docker Run 될때 무조건 실행되는 명령어 (Project 실행)

