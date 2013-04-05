package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;

public class SignUpValidation  extends HttpServlet
{

	String userName;
	String password;
	UserDao userDao;
	int id;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
	  	userName=request.getParameter("username");
	  	password=request.getParameter("password");
	  	response.setContentType("text/html");
     	PrintWriter out = response.getWriter();
     	out.println(userName+"\t"+password);
	  	userDao=new UserDao();
	  	try 
	  	{
			id=userDao.retrieveId(userName, password);
		} 
	  	catch (SQLException e)
	  	{
			System.out.println("id coulnot be retrieved properly");
			e.printStackTrace();
		}
	  	
	  	if(id>0)
	  	{
	  		response.sendRedirect("./index.jsp");
			
	  	}
	  	
	  	else
	  	{
	  		try {
				userDao.insertUser(userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("couldnot insert from signup");
				e.printStackTrace();
			}
	  		response.sendRedirect("./confirmation.jsp");
	  	}
	  	
	  	
	}
}
