package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class UserDao 
{
	
	Statement st;
    ResultSet rs;
    Connector con;
    
   public UserDao()
    {
       con=new Connector();
       st=con.getStmt();
    }
    
	 public int retrieveId(String userName,String password) throws SQLException
     {
             int id=-1;
             String query="SELECT id FROM `user` where `username`='"+userName+"' and password='"+password+"'";
             try {
				rs=st.executeQuery(query);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
			System.out.println("oops there's an exception!");
			}
             while(rs.next())
             {
            	 id=rs.getInt(1);
            	 System.out.println(rs.getInt(1));
             }
             return id;
             
     }
	 
	 public void insertUser(String userName,String password) throws SQLException 
	 {
		   String query="INSERT INTO  `user` (`username`,`password`) VALUES ('"+userName+"','"+password+"')";
           st.execute(query);
	 }
	 
	 public static void main(String[] args) throws SQLException
	 {
		 UserDao ld=new UserDao();
	    // ld.retrieveId("Smrita", "abc123");
	     ld.insertUser("abc", "efg");
	    
//		 if(ld.rs.wasNull())
//		 {
//			 System.out.println("Not found try again");
//		 }
		// else
		 //{
//			 
//			 	while(ld.rs.next())
//			 	{
//			 		if(ld.rs.wasNull())
//			 		{
//			 			System.out.println("value is null");
//			 		}
//			 		
//			 		System.out.println("id is "+ld.rs.getInt(1));
//			 	}
//			 	System.out.println("hello from login dao");
		// }
	 }

}
