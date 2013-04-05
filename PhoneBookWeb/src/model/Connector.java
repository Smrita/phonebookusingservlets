
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smrita
 */
public class Connector 
{
   private Connection connection;
   private Statement stmt;
    
    public Connector() 
    {
       try {
          Class.forName("com.mysql.jdbc.Driver");//loading the jdbc driver
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt=(Statement) connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

   
    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
//     */
//    public void setStmt(Statement stmt) throws SQLException 
//    {   stmt=(Statement) getConnection().createStatement();
//        this.stmt = stmt;
//    }
    
    public void closeConnection() throws SQLException
    {
          this.connection.close();
    }
    
}