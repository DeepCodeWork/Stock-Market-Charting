<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<form action="registerUser" commandName="userData" method="post">
	Username: <input type="text" name="username">
	Password: <input type="password" name="userPassword">
	Email : <input type="text" name="userEmail">
	Mobile: <input type="text" name="userMobileNumber">
	<input type="submit" value="SUBMIT">
</form>
</body>
</html>