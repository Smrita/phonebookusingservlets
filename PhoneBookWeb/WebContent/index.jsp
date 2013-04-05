<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href='http://fonts.googleapis.com/css?family=Merienda' rel='stylesheet' type='text/css'>

</head>
<body>

<div class="contentBox">
   <!-- div id="header">
     PHONEBOOK
   </div-->
	<div class="content">
	   <div class="content_left">
	   <div id="homeMessage">
	     Welcome to PHONEBOOK
	     </div> 
	     <div id="homeQuote">
	      An online tool to simplify your 'PhoneLife'
	     </div>
	     </div>
       <div class="content_right">
       <div id="loginBox">
 		<form action="login" method="post" >
    	<p> Username<input type="text" name="username" placeholder="username..."></p>
     	 <p>Password <input type="text" name="password" placeholder="password..."></p>
            <input class="button" type="submit" value="Login" name="login">
                  
		 </form>
		 </div>
     
      
      <div id="signUpBox">
      <div id="signupMsg">New to PhoneBook?Sign Up.</div>
 		<form action="signup" method="post" >
 		<p>EmailAddress<input type="text" name="email" placeholder="email..."></p>
     	<p>Username<input type="text" name="username" placeholder="username..."></p>
     	<p>Password<input type="text" name="password" placeholder="password..."></p>
     		<input class="button" type="submit" value="Sign Up" name="signUp">
     		
		</form>
		</div>
		 </div><!-- end of content_right-->
	</div><!-- end of content -->
  </div><!-- end of contentBox -->
</div>
</body>
</html>