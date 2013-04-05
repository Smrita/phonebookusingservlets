package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataManipulatorDao;

import dto.Contacts;


public class ContactsAdder extends HttpServlet
{
	
	    final String FIRSTNAME="FirstName";
	    final String LASTNAME="LastName";
	    final String MOB="MobileNumber";
	    final String HOME="HomeNumber";
	    final String FAX="Fax";
	    final String USER_ID="user_id";
		final String[] col={FIRSTNAME,LASTNAME,MOB,HOME,FAX};
	    DataManipulatorDao dataManipulator;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String query=request.getQueryString();
		
		out.println("user id  is "+query);
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
		{
		    ArrayList<Contacts> contacts=new ArrayList<Contacts>();
		    dataManipulator=new DataManipulatorDao();
		    
		    
			String firstName= request.getParameter("firstName");
		    String lastName = request.getParameter("lastName");
		    String mobile= request.getParameter("mobile");
		    String fax= request.getParameter("fax");
		    String landLine= request.getParameter("landLine");
		    Integer userId=(Integer) request.getSession().getAttribute("userId");
		    String[] data={firstName,lastName,mobile,landLine,fax};
		
		  //  Contacts contact=new Contacts(firstName,lastName,mobile,landLine,fax);
		 
 
		    try
		    {
        	  	dataManipulator.insert(col, data);
        	  	dataManipulator.insertId("user_id",userId,mobile);
          	}
		    catch (SQLException e)
		    {
		    	
		    	e.printStackTrace();
		    }
          
		    try
		    {
		    	contacts=dataManipulator.retrieveAllData(userId);
		    } 
		    catch (SQLException e) 
		    {
        	  e.printStackTrace();
		    }
 			
 		
 			
 			request.setAttribute("allContacts", contacts);	
 			RequestDispatcher displayAll = request.getRequestDispatcher("dashboard.jsp");
 			displayAll.forward(request, response);
          
           
 			
    
		
	}

}
