<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Contacts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
			out.println("<table><tr><th>Firstname</th><th>Middlename</th><th>Lastname</th><th>Mobile</th><th>Landline</th><th>Fax</th></tr>");
			ArrayList<Contacts> contacts = (ArrayList<Contacts>) application.getAttribute("allContacts");
			for (Contacts c : contacts) 
			{
				out.println("<tr><td>" + c.getFirstName() + "</td><td>"
						+ c.getLastName()
						+ "</td><td>"+c.getMobile()+"</td><td>"+c.getLandLine()+"</td><td>"+c.getFax()+"</td></tr>");
			}
			out.println("</table>");
	%>	
</body>
</html>