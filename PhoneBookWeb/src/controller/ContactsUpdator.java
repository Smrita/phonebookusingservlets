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

import dto.Contacts;

import model.DataManipulatorDao;

public class ContactsUpdator extends HttpServlet 
{
	
	    final String FIRSTNAME="FirstName";
	    final String LASTNAME="LastName";
	    final String MOB="MobileNumber";
	    final String HOME="HomeNumber";
	    final String FAX="Fax";
	    final String USER_ID="user_id";
		final String[] col={FIRSTNAME,LASTNAME,MOB,HOME,FAX};
	    DataManipulatorDao dataManipulator;
	    
	    String firstName;
	    String lastName;
	    int id;
	    String mobile;
	    String landLine;
	    String fax;
      public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
      {
    	  dataManipulator=new DataManipulatorDao();
    	  response.setContentType("text/");
    	  PrintWriter out=response.getWriter();
    	  firstName=request.getParameter("firstName");
    	  lastName=request.getParameter("lastName");
    	  landLine=request.getParameter("landLine");
    	  mobile=request.getParameter("mobile");
    	  fax=request.getParameter("fax");
    	  String contactId=request.getParameter("contactId");
    	  int userIdd=(Integer) request.getSession().getAttribute("userId");
    	  out.println(fax);
    	  out.println(contactId);
    	  
    	  id=Integer.parseInt(contactId);
//    	  
   	  String[] values={firstName,lastName,mobile,landLine,fax};
   	  

    	  
    	  try
    	  {
			//dataManipulator.update(col, values, id);
    		  dataManipulator.updateContact(col, values, id,userIdd);
		  }
    	  catch (SQLException e) 
    	  {
			System.out.println("couldnot update from servlet");
			e.printStackTrace();
		  }
    	  
    	  try
    	  {
    		  Integer userId=(Integer) request.getSession().getAttribute("userId");
    		  ArrayList<Contacts> contacts=new ArrayList<Contacts>();
    		  contacts=dataManipulator.retrieveAllData(userId);
    		  
    		  request.setAttribute("allContacts", contacts);	
   			  RequestDispatcher displayAll = request.getRequestDispatcher("dashboard.jsp");
   			  displayAll.forward(request, response);
    		  
			//response.sendRedirect("./dashboard.jsp");
		  } 
    	  catch (SQLException e) 
    	  {
			System.out.println("couldnot redirect to dashboard");
			e.printStackTrace();
		  }
//    	  
    	  
    	  
    	  
      }
}
