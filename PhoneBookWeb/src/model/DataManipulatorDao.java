/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Contacts;

/**
 *
 * @author smrita
 */
public class DataManipulatorDao 
{
      Statement st;
      ResultSet rs;
      Connector con;

      
      public DataManipulatorDao()
      {
         con=new Connector();
         st=con.getStmt();
      }
      
       public void insert(String[]colName,String[] values) throws SQLException
   {
              String query="INSERT INTO  `phonebook` (`"+colName[0]+"`) values ('"+values[0]+"')";
              st.execute(query);
              System.out.println("inserting values! outside for");
              
              String query2="SELECT id FROM  `phonebook` WHERE `"+colName[0]+"` ='"+values[0]+"'AND `mobilenumber`='-'";
              rs=st.executeQuery(query2);
              int id = -1;
              while(rs.next())
              {
            	  id=rs.getInt(1);
              }
              
              
              for(int i=1;i<colName.length;i++)
              {
            	  System.out.println("inside for insert update");
                  String update="UPDATE `phonebook` set `"+colName[i]+ "` ='"+values[i]+"' where `id`="+id;//`"+colName[0]+"` ='"+values[0]+"' AND `mobilenumber`='-'";   
                  st.execute(update);
              }
        
   }
       
       public void insertId(String colName,int userId,String mobile) throws SQLException
       {
                  String query="UPDATE  `phonebook` set`"+colName+"`= "+userId+" where `mobilenumber`='"+mobile+"'";
                  st.execute(query);
                  
            
       }
       
       
       public void removeContact(int contactId,int userId) throws SQLException
       {
    	   String query="DELETE FROM `phonebook` where id='"+contactId+"' and user_id='"+userId+"'";
           st.execute(query);

       }
       

      
       public ArrayList<Contacts>retrieveDataForEdit(int contactId) throws SQLException
       {
    	   String query="SELECT * FROM `phonebook` where `id`="+contactId;
           rs=st.executeQuery(query);
           ArrayList<Contacts> allContacts=formatResultSet(rs);
           
           return allContacts;
       
       }
       
       public ArrayList<Contacts> retrieveAllData(int id) throws SQLException
       {
               String query="SELECT * FROM `phonebook` where `user_id`="+id;
               rs=st.executeQuery(query);
               ArrayList<Contacts> allContacts=formatResultSet(rs);
               return allContacts;
               
       }

      
      public void update(String[] cols,String[] values,int id) throws SQLException
      {

          for(int i=0;i<cols.length;i++)
          {
              String query="UPDATE `phonebook` SET `"+cols[i]+"`='"+values[i]+"' WHERE `id`='"+id+"'";
              st.executeUpdate(query);
          }
      }
      
      public void updateContact(String[] cols,String[] values,int id,int userId) throws SQLException
      {
       
          for(int i=0;i<cols.length;i++)
          {
        	  String query="UPDATE `phonebook` SET `"+cols[i]+"`='"+values[i]+"' WHERE id='"+id+"' and user_id='"+userId+"'";
              st.executeUpdate(query);
          }
      }
      
      public ArrayList<Contacts> search(String constraint,int userId) throws SQLException
      {
    	  String query="SELECT * FROM `phonebook` WHERE `user_id=`'"+userId+"' AND ( firstname LIKE'%"+constraint+"%'  OR lastname LIKE'%"+constraint+"%'  OR mobilenumber LIKE '%"+constraint+"%'   OR homenumber LIKE '%"+constraint+"%' OR fax LIke '%"+constraint+"%')";
    	  rs=st.executeQuery(query);
    	  ArrayList<Contacts> contacts=formatResultSet(rs);
	      return contacts;		
    			
      }
      
      public static void main(String[] args) throws SQLException {
        DataManipulatorDao dm=new DataManipulatorDao();
   
        String[] cols={"mobilenumber","homenumber"};
        String[] values={"gggg","gggg"};
      //  dm.updateContact(cols, values, 53,2);
   //     ArrayList<Contacts> contacts=dm.search("pokharel");
//        
//        for(Contacts c:contacts)
//        {
//        	System.out.println(c.getFirstName());
//        	System.out.println(c.getLandLine());
//        }
        
     
    }
      
      private ArrayList<Contacts> formatResultSet(ResultSet rs)
      {
    	  ArrayList<Contacts> allContacts = new ArrayList<Contacts>();
    	  Contacts contact;
    		try {
				while(rs.next())
				{
					contact=new Contacts();
					contact.setId(rs.getInt(1));
					contact.setFirstName(rs.getString(2));
				    contact.setLastName(rs.getString(3));
					contact.setMobile(rs.getString(4));
					contact.setLandLine(rs.getString(5));
					contact.setFax(rs.getString(6));
					allContacts.add(contact);
					
				}
				
			} 
    		catch (SQLException e) 
    		{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  
    	  return allContacts;
      }
      
      
}
