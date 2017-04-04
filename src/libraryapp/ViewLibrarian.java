
package libraryapp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ViewLibrarian extends JFrame {
    /*DB Connections*/
    DatabaseConnection dbconn;
    Connection conn;
    Statement stmt;
    ResultSet res;
    String sql;

     JTable table;
     JScrollPane jsp;
     TableModel model;
            
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
                    
                    
                }                
                System.out.print("\n");
                data.add(row);
            }       
           model=new DefaultTableModel(data,coloumn)   ;
           table=new JTable(model);
           jsp=new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLayout(new BorderLayout());
           setSize(500,300);
           getContentPane().add(new JLabel("Drag to move", JLabel.CENTER),
                BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem item = new JMenuItem("Back");
            
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminInterface();
                
            }
        });
        menu.add(item);
        setJMenuBar(menuBar);
           
           add(jsp,BorderLayout.CENTER);
           setLocationRelativeTo(null);
           setVisible(true);
            
       }catch(Exception e){
           e.printStackTrace();
       }    
    
    }
    
}
