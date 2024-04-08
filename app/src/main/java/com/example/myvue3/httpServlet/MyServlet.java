//package com.example.myvue3.httpServlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/myServlet")
//public class MyServlet extends HttpServlet {
//
//    // http://localhost:8082/myvue3/myServlet?parameterName=Hello
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("doGet 탐..");
//
//        // 클라이언트로부터 요청 파라미터 가져오기
//        String clientParameter = request.getParameter("parameterName");
//
//        // 응답 설정
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().write("Hello from MyServlet! You sent: " + clientParameter);
//    }
//
//
//}
