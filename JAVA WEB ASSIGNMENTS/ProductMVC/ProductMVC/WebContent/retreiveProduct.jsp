<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>PId</th>
		<th>PName</th>
		<th>Price</th>
	</tr>
	
	<%
		Object obj = session.getAttribute("productInfo");
		List<Product> listOfPro = (List<Product>)obj;
		Iterator<Product> li = listOfPro.iterator();
		while(li.hasNext()){
			Product pro = li.next();
	%>
		<tr>
			<td><%=pro.getPid() %></td>
			<td><%=pro.getPname() %></td>
			<td><%=pro.getPrice() %></td>
		</tr>
	<% 
		}
	%>
</table>
</body>
</html>