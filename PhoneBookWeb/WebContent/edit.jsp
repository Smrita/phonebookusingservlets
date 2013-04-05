<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Contacts" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Contacts</title>
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href='http://fonts.googleapis.com/css?family=Merienda' rel='stylesheet' type='text/css'>

</head>
<body>
<div class="contentBox">
   <div id="header">
    PHONEBOOK-edit 
  <div id="menu">  

   <a href="viewall?<%= session.getAttribute("userId")%>">Viewall</a>
 <a href="index.jsp">Logout</a>

</div>
</div>
<div class="content_left">
<form action="./update" method="post">

<%
   ArrayList<Contacts> contact=(ArrayList<Contacts>)request.getAttribute("contactToEdit");
   for(Contacts c:contact)
   {
	 out.println("<p>FirstName:<input type='text' name='firstName' value='"+c.getFirstName()+"'</p>");
	 out.println("<p>LastName:<input type='text' name='lastName' value='"+c.getLastName()+"'</p>");
	 out.println("<p>MobileNumber:<input type='text' name='mobile' value='"+c.getMobile()+"'</p>");
	 out.println("<p>LandLine:<input type='text' name='landLine' value='"+c.getLandLine()+"'</p>");
	 out.println("<p>Fax:<input type='text' name='fax' value='"+c.getFax()+"'</p>");
	// out.println("<input type='hidden' value="+c.getId()+"name='contactId'>");
	 out.println("<input type='hidden' name='contactId' value='"+c.getId()+"'");
   }

%> 
<p><input class="button" type="submit" value="Update" name="update" style="float:right;"></p>


</form>

</div>
</div>
</body>
</html>
