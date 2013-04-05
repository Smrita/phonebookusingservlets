package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Contacts;

import model.DataManipulatorDao;
import model.UserDao;

public class LoginValidation extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	String userName;
	String password;
	UserDao userDao;
	int id;
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
    {
//    	response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("TestServlet says hi<br/>");
//    	
//		RequestDispatcher dispatcher =request.getRequestDispatcher("/loginn.jsp");
//				dispatcher.forward(request,response);
//	
//	    getServletContext().setAttribute("Name", username);
	//    getServletContext().setAttribute("pass", password);
  // 	response.sendRedirect("NewFile.jsp");
	    
	   
		
		
    }
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
//    	

      // response.sendRedirect("./home.jsp");
    //	userName="Smrita";
    //	password="abc123";
        userName=request.getParameter("username");    	
        password=request.getParameter("password");
    	userDao=new UserDao();
    	try {
			id=userDao.retrieveId(userName, password);
		    }
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(id<0)
				{
					response.sendRedirect("./index.jsp");
				}
				
				else
				{
					HttpSession session=request.getSession(true);
					session.setAttribute("userId", id);
					ArrayList<Contacts> contacts=new ArrayList<Contacts>();
					DataManipulatorDao dataManipulator=new DataManipulatorDao();
					try {
						contacts=dataManipulator.retrieveAllData(id);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					request.setAttribute("allContacts", contacts);	
					RequestDispatcher displayAll = request.getRequestDispatcher("dashboard.jsp");
					try {
						displayAll.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					

					//response.sendRedirect("./dashboard.jsp");
				}
			
		
    	
    	
    	
    	
    	
   }
}
