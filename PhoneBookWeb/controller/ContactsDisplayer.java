package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataManipulatorDao;
import dto.*;

public class ContactsDisplayer 
{

	DataManipulatorDao dataManipulator;
	ResultSet rs;
	ArrayList<Contacts> contacts=new ArrayList<Contacts>();
	Contacts contact;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
		{
		
			dataManipulator=new DataManipulatorDao();
		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			try {
				rs=dataManipulator.retrieveAllData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next())
				{
					contact=new Contacts();
					contact.setFirstName(rs.getString(2));
					contact.setMiddleName(rs.getString(3));
					contact.setLastName(rs.getString(4));
					contact.setMobile(rs.getString(5));
					contact.setLandLine(rs.getString(6));
					contact.setFax(rs.getString(7));
					
					contacts.add(contact);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			request.setAttribute("allContacts", contacts);	
			RequestDispatcher displayAll = request.getRequestDispatcher("displayall.jsp");
			displayAll.forward(request, response);
			
			
			
			
	
		}
}
