<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" 
	import="java.%>

<form action="EditHero" method="post">
	<input type="text" name="name" value='${hero.name}'>
	<input type="text" name="hp" value='${hero.hp}'>
	<input type="text" name="damage" value='${hero.damage}'>
	<input type="submit" value="edit">
</form>