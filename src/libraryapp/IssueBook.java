
package libraryapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class IssueBook extends JFrame implements ActionListener{
   
    JTextField jtf1,jtf2,jtf3;
     DatabaseConnection dbconn;
    Connection conn;
    Statement stmt;
    ResultSet res;
    String sql;
    String a[]=new String[3];
    int i=0;
    
    public IssueBook(){
        setTitle("Library Management System") ;
        JLabel jlab1=new JLabel("STUDENT_ID");
        jtf1=new JTextField(25);
        JLabel jlab2=new JLabel("STUDENT NAME");
        jtf2=new JTextField(25);
        JLabel jlab3=new JLabel("NO.OF BOOKS");
        jtf3=new JTextField(25);       
      
        
        JButton jbtn=new JButton("Done");
        JButton jbtn1=new JButton("Back");
        JButton jbtn2=new JButton("Add");
        
        
        
        
        /* Screen Layout */
        jlab1.setBounds(10,10,200,25);
        jtf1.setBounds(220, 10, 200, 25);
        jlab2.setBounds(10,45,200,25);
        jtf2.setBounds(220,45,200,25);
        jlab3.setBounds(10,80,200,25);
        jtf3.setBounds(220,80,200,25);
        jbtn.setBounds(340,115,75,25);
        jbtn1.setBounds(10,115,75,25);
        jbtn2.setBounds(150,115,75,25);
        
        
        setSize(470,200);
        setLocationRelativeTo(null);
        setLayout(null);
        add(jlab1);
        add(jtf1);
        add(jlab2);
        add(jtf2);
        add(jlab3);
        add(jtf3);
    
        
        
        add(jbtn);
        add(jbtn1);
        add(jbtn2);
        jbtn.addActionListener(this);
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        setVisible(true);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
     
    }
    
   
    public void actionPerformed(ActionEvent e) {
          /*database connection*/ 
        
           
        
        if(e.getActionCommand().equals("Done")){
                this.dispose();
                new LibrarianInterface();
                
            }
        if(e.getActionCommand().equals("Back")){
            this.dispose();
            new LibrarianInterface();
        }
        
        if (e.getActionCommand().equals("Add")){
            try{
            dbconn= new DatabaseConnection();
            conn=dbconn.setConnection();
            stmt=conn.createStatement();
            sql="select book_id from book where book.issued<book.quantity";
            res=stmt.executeQuery(sql);
           
            
            ArrayList<String> list = new ArrayList<String>();
            
            while(res.next()){
                list.add(res.getString("book_id"));
             }
            Object[] result = list.toArray();
            int n=Integer.parseInt(jtf3.getText());
            if(i<n && i<3){
            String input = (String) JOptionPane.showInputDialog(null, "Book ID","Library Management System", JOptionPane.INFORMATION_MESSAGE, null, result, result[0]);
            
            a[i]=input;           
            //System.out.println(a[i]);
            //System.out.println(i);
            i++;}         
            
            else{
            JOptionPane.showMessageDialog(this, "NO BOOKS");
            }}catch(Exception err){
           err.printStackTrace();
       }
        }
        
    }
}
