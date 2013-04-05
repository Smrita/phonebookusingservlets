package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Contacts;

import model.DataManipulatorDao;

public class SearchEngine extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
    	DataManipulatorDao dataManipulator=new DataManipulatorDao();
    	String searchString=request.getParameter("search");
    	ArrayList<Contacts> contacts=new ArrayList<Contacts>();
    	Integer userId=(Integer) request.getSession().getAttribute("userId");
    	try 
    	{
			contacts=dataManipulator.search(searchString,userId);
		}
    	catch (SQLException e)
    	{
			System.out.println("Couldnot search the string");
			e.printStackTrace();
		}
    	
    	request.setAttribute("allContacts",contacts);
    	
    	RequestDispatcher dispatcher=request.getRequestDispatcher("dashboard.jsp");
    	dispatcher.forward(request,response);
    	
    	
    	
    	
    	
    	
    }
}
