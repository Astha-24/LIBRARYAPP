
package libraryapp;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ViewLibrarian extends JFrame {
    /*DB Connections*/
    DatabaseConnection dbconn;
    Connection conn;
    Statement stmt;
    ResultSet res;
    String sql;
    public ViewLibrarian(){
        //Vector Coloumn;
        try{   
            dbconn= new DatabaseConnection();
            conn=dbconn.setConnection();
            stmt=conn.createStatement();
            sql="select * from librarian";
            res=stmt.executeQuery(sql);
            ResultSetMetaData rsmt=res.getMetaData();
            int c=rsmt.getColumnCount();
            Vector coloumn=new Vector(c);
            for (int i=1;i<=c;i++){
                coloumn.add(rsmt.getColumnName(i));
            }
            Vector data=new Vector();
            Vector row=new Vector();
            while(res.next()){
                row=new Vector(c);
                for (int i=1;i<=c;i++){
                    row.add(res.getString(i));
                    System.out.println("Done");
                }
                data.add(row);
            }       
              
        
       setSize(500,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setTitle("Library Managment System");
       JPanel panel=new JPanel();
       JTable table=new JTable(data,coloumn);
       JScrollPane jsp=new JScrollPane();
       panel.setLayout(new BorderLayout());
       panel.add(jsp,BorderLayout.CENTER);
       setContentPane(panel);
       setVisible(true);    
       }catch(Exception e){
           e.printStackTrace();
       }    
    
    }
    public static void main(String[] args) {
        ViewLibrarian vl=new ViewLibrarian();
    }
}
