<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ProductController" method="post">
		<label>ProductId</label>
		<input type="hidden" name="pro" value="insert"><br/>
		<input type="text" name="pid"><br/>
		<label>PName</label>
		<input type="text" name="pname"><br/>
		<label>Price</label>
		<input type="text" name="price"><br/>
		<input type="submit" value="Store Product Info">
		</form>
</body>
</html>