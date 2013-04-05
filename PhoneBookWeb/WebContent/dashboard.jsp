<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="dto.Contacts" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PhoneBook Dashboard</title>
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link rel="stylesheet" type="text/css" href="css/table.css"></link>
<link href='http://fonts.googleapis.com/css?family=Merienda' rel='stylesheet' type='text/css'>
</head>
<body>

<div class="contentBox">
   <div id="header">
     PHONEBOOK
	  <div id="search">  
  		<form method="post" action="./search">
  			<input id="searchBar" type="text" name="search" placeholder="search..."/>
  			<input class="button" type="submit" name="search" value="search" placeholder="search..." />
 		</form> 
      </div>
      
     <div id="menu">
      <a href="viewall?<%=session.getAttribute("userId")%>">Viewall</a>	
 	  <a href="add.jsp">Add a contact</a>
  	  <a href="index.jsp">Logout</a>
    </div>

</div>
    <%
        out.println("<table class='CSSTableGenerator'><tr><td>NAME</td><td>MOBILE NUMBER</td><td>LANDLINE NUMBER</td><td width='20%'>FAX</td><td width='20%'>Setting</td></tr>");//<td width='20%'>Setting</td></tr>");
        ArrayList<Contacts> contacts = (ArrayList<Contacts>) request.getAttribute("allContacts"); 
  
      
       for(Contacts c:contacts)
        {
         out.println("<tr>");
         //out.println("<td><input type='checkbox'  value='"+c.getId()+"' name='checkbox'></td>");
         out.println("<td>"+c.getFirstName()+"\t"+c.getLastName()+"</td>");
         out.println("<td>"+c.getMobile()+"</td>");
         out.println("<td>"+c.getLandLine()+"</td>");
         out.println("<td>"+c.getFax()+"</td>");
         out.println("<td><form action='edit' method='post'><input type='hidden' value="+c.getId()+" name='contactId'><input class='dashboardButton' type='submit' name='edit' value='edit'></form>");
         out.println("<form action='delete' method='post'><input type='hidden' value="+c.getId()+" name='contactId'><input class='dashboardButton' type='submit' name='delete' value='delete'></form></td>");
         out.println("</tr>");   
        }
       out.println("</table>");
    %>
   
</div><!-- end of contentBox --> 
</body>
</html>