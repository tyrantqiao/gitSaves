<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

first test

<% List<String> heroList=new ArrayList<String>();
   heroList.add("kill");
   heroList.add("death");
 %>

<table border=1>

<%for(String hero:heroList){%> <tr><td><%=hero%></td></tr> <%}%>

</table>


<%=new Date().toGMTString() %>

<jsp:include page="right.jsp" />