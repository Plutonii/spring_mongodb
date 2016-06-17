<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>
 
		<form action="aim/save" method="post">
			<input type="hidden" name="id">
			<label for="name">Person Name</label>
			<input type="text" id="name" name="name"/>
			<label for="cost">Cost</label>
			<input type="text" id="cost" name="cost"/>
			<input type="submit" value="Submit"/>
		</form>
 
	<table border="1">
		<c:forEach var="aim" items="${aimList}">
			<tr>
				<td>${aim.name}</td>
				<td>${aim.cost}</td>
				<td><input type="button" value="delete" onclick="window.location='aim/delete?id=${aim.id}'"/></td>
				<!-- <td><input type="button" value="edit" onclick="window.location='aim/edit?id=${person.id}'"/></td>-->
			</tr>
		</c:forEach>
	</table>	
</body>
</html>