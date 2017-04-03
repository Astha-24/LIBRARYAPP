
package libraryapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    
    Connection conn;
    
    public DatabaseConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver for mysql is loaded"); 
            
        }catch(Exception e){
            System.out.println("Connection not succesful");
            
        }
    }
    
    public Connection setConnection(){
        try{
            conn=DriverManager.getConnection("jdbc:mysql://localhost/libraryapp", "astha", "astha");
            System.out.println("Database Connected");
            return conn;
        }
        catch(Exception e){
            
             System.out.println("Unable to connect Database");
            return null;
        }
    
    }
    public static void main(String[] args) {
        DatabaseConnection dbconn=new DatabaseConnection();
        dbconn.setConnection();
    }
}