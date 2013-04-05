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

public class ContactsRemover extends HttpServlet
{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		DataManipulatorDao remover=new DataManipulatorDao();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("contactId");
		int contactId=Integer.parseInt(id);
		int userId=(int) request.getSession().getAttribute("userId");
		
		out.println("contactId"+contactId);
		out.println("userId"+userId);
		
		try
		{
			remover.removeContact(contactId, userId);
			ArrayList<Contacts> contacts=new ArrayList<Contacts>();
			DataManipulatorDao dataManipulator=new DataManipulatorDao();
			try {
				contacts=dataManipulator.retrieveAllData(userId);
				
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
		catch (SQLException e)
		{
			out.println("couldnot delete ");
			out.println("<a href='./dashboard.jsp'>Click here to return</a>");
			
		}
		
		
			
	}
}
