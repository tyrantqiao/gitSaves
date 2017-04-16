
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<table border='1' >
    <tr>
        <td>id</td>
        <td>name</td>
        <td>hp</td>
        <td>damage</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${Heros}" var="hero" varStatus="st">
        <tr>
            <td>${hero.id }</td>
             <td>${hero.name}</td>
             <td>${hero.hp }</td>
             <td>${hero.damage }</td>
        </tr>
    </c:forEach>
</table>