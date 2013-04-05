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

public class ContactsEditor extends HttpServlet
{
	public void doGet(){}
    public void doPost(HttpServletRequest request,HttpServletResponse response) 
    {
   
   	
    	DataManipulatorDao dataManipulator=new DataManipulatorDao();
    	String id=request.getParameter("contactId");
    	int contactId=Integer.parseInt(id);
    	
    	ArrayList<Contacts> contact=new ArrayList<Contacts>();
    	
    	try
    	{
			contact=dataManipulator.retrieveDataForEdit(contactId);
		} 
    	catch (SQLException e)
    	{
			System.out.println("fail  to retrieved data for edit");
			e.printStackTrace();
		}
    	
    	request.setAttribute("contactToEdit",contact);
    	
    	RequestDispatcher displayContactToEdit=request.getRequestDispatcher("edit.jsp");
    	
    	try 
    	{
			displayContactToEdit.forward(request, response);
		} 
    	catch (ServletException e) 
    	{
			System.out.println("servlet error!");
			e.printStackTrace();
		} 
    	catch (IOException e)
    	{
			System.out.println("IOException");
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	
        //response.setContentType("text/html");
        //PrintWriter out=response.getWriter();
      
    	   
    	  
    }     

      
}
