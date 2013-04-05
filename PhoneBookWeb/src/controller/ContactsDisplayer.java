package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataManipulatorDao;
import dto.Contacts;

public class ContactsDisplayer extends HttpServlet
{
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	    String userId=request.getQueryString();
	    int user_id=Integer.parseInt(userId);
	   
	    ArrayList<Contacts> contacts=new ArrayList<Contacts>();
		DataManipulatorDao dataManipulator=new DataManipulatorDao();
		try 
		{
			contacts=dataManipulator.retrieveAllData(user_id);
			
		}
		catch (SQLException e1)
		{
			System.out.println("couldnot retrieve all data");
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
		
   }
	
}
