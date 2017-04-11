<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>

<% Cookie[] cookies=request.getCookies();
	for(Cookie cookie:cookies){
		out.println(cookie.getName()+" description:"+cookie.getValue());
	}
%>

<jsp include="right.jsp" />