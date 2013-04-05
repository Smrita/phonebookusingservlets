package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
	    DataManipulatorDao dataManipulator;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
		{
		
		dataManipulator=new DataManipulatorDao();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String firstName= request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middleName= request.getParameter("middleName");
		String mobile= request.getParameter("mobile");
		String fax= request.getParameter("fax");
		String landLine= request.getParameter("landLine");
		
		
		Contacts contact=new Contacts(firstName,lastName,middleName,mobile,landLine,fax);
		
		 String[] col={FIRSTNAME,LASTNAME,MOB,HOME,FAX};
         String[] data={firstName,lastName,mobile,landLine,fax};
      
         // dataAdder.insert(col,data);*****
          try {
			dataManipulator.insert(col, data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          response.sendRedirect("./add.jsp");
    
		
	}

}
