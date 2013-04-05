<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a contact</title>
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href='http://fonts.googleapis.com/css?family=Merienda' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="contentBox">
   <div id="header">
     PHONEBOOK-add
  <div id="menu"> 
    
 <a href="viewall?<%=session.getAttribute("userId")%>">Viewall</a>
 <a href="index.jsp">Logout</a>

</div>
</div>
<div class="content_left">

<form method="post" action="insert">
<p>Firstname<input type="text" name="firstName"></p>

<p>Lastname<input type="text" name="lastName"></p>
<p>Mobile<input type="text" name="mobile"></p>
<p>Landline<input type="text" name="landLine"></p>
<p>Fax<input type="text" name="fax"></p>

<p><input class="button" type="submit" value="Insert"></p>
</form>
</div><!-- end of content left -->
</div><!-- end of content box -->
</body>
</html>