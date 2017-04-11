<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>

<% Cookie cookie=new Cookie("death","die") ;
   cookie.setMaxAge(24*60);
   cookie.setPath("127.0.0.1");
   response.addCookie(cookie);
%>

<a href="getCookie.jsp">get cookie</a>