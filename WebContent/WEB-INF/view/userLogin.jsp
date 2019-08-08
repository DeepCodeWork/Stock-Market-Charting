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
<form action="userAuthenticate" method="post">
	username: <input type="text" name="username">
	password: <input type="password" name ="userPassword">
	<input type="submit" name="Login">
</form>
</body>
</html>