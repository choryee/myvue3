package com.example.myvue3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;


@RestController
public class HomeController {
    //생성자 문제: HomeController의 생성자가 매개변수를 받도록 정의되어 있지만, Spring의 컨트롤러에서는 매개변수가 없는 생성자를 사용해야 합니다. Spring이 컨트롤러 객체를 생성할 때 생성자에 매개변수를 주입할 수 없습니다. 대신에 @Autowired 어노테이션을 사용하여 필요한 의존성을 주입해야 합니다.

    //정적 필드 사용 문제: HomeController에서 req와 res를 정적(static) 필드로 선언한 후 생성자에서 할당하려고 하고 있지만, 이렇게 하지 않아도 됩니다. Spring은 요청 및 응답 객체를 메서드의 매개변수로 주입해줄 수 있습니다.

    //Spring 컨트롤러 설정 문제: Spring 컨트롤러를 사용하려면 Spring MVC 구성과 컨트롤러를 올바르게 설정해야 합니다.

    static HttpServletRequest req;
    static HttpServletResponse res;
    HomeController(HttpServletRequest req, HttpServletResponse res){
        this.req=req;
        this.res=res;
    }

    // http://localhost:8082/test?name=kim
    // http://localhost:8082/test?name=kim&id=3   <--이 주소를 쳐야, 밑 list가 Json으로 출력됨.

    //HomeController 클래스의 test 메서드에서 반환하는 리스트인 list에 들어있는 데이터를 출력하는 방법은 여러 가지가 있습니다.
    // 가장 간단한 방법 중 하나는 해당 데이터를 System.out.println을 사용하여 콘솔에 출력하는 것입니다.
    // 그러나 Spring에서는 일반적으로 컨트롤러에서 데이터를 반환하면 이 데이터를 View에 전달하거나,
    // REST API의 경우 JSON 형식으로 반환하는 것이 더 일반적입니다.

    //여기서는 test 메서드가 REST API 스타일로 동작하도록 정의되어 있다고 가정하고,
    // 반환하는 list 데이터를 JSON 형식으로 출력하는 방법을 보여드리겠습니다.

    //이렇게 설정하면 test 메서드는 리스트를 반환하고, Spring은 자동으로 해당 리스트를 JSON 형식으로 변환하여 응답합니다.
    // 따라서 이 엔드포인트에 접근하면 브라우저에서 JSON 데이터를 볼 수 있습니다.
    @GetMapping("/test")
    public static List<Map<String,String>> test() throws IOException {
        Map<String, String> map=new HashMap<>();
        List<Map<String,String>> list=new ArrayList<>();

        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String protocol=req.getProtocol();
        String ip = req.getHeader("x-forwarded-for"); // apache
        String cookies= Arrays.toString(req.getCookies()); //null
        String getURI=req.getRequestURI(); // /test
        String getSession=req.getRequestedSessionId(); //null

        map.put("id", id);
        map.put("protocol", protocol); //HTTP/1.1
        map.put("ip", ip); //null
        map.put("cookies", cookies);
        map.put("URI", getURI);
        map.put("Session", getSession);

        list.add(map);
        

//        res.getWriter().write("Hello from Servlet! You sent: " + name);

        System.out.println("HomeController 탐...");

        return list;
    }
}
