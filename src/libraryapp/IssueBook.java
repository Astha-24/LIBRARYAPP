
package libraryapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class IssueBook extends JFrame implements ActionListener{
   
    JTextField jtf1,jtf2,jtf3,jtf4;
     DatabaseConnection dbconn;
    Connection conn;
    Statement stmt;
    ResultSet res;
    String sql,sql1,sql2;
    String a[]=new String[3];
    int i=0;
    
    public IssueBook(){
        setTitle("Library Management System") ;
        JLabel jlab1=new JLabel("STUDENT_ID");
        jtf1=new JTextField(25);
        JLabel jlab2=new JLabel("STUDENT NAME");
        jtf2=new JTextField(25);
        JLabel jlab4=new JLabel("STUDENT CONTACT");
        jtf4=new JTextField(25);
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
        jlab4.setBounds(10,80,200,25);
        jtf4.setBounds(220,80,200,25);
        jlab3.setBounds(10,115,200,25);
        jtf3.setBounds(220,115,200,25);
        jbtn.setBounds(340,150,75,25);
        jbtn1.setBounds(10,150,75,25);
        jbtn2.setBounds(150,150,75,25);
        
        
        setSize(470,240);
        setLocationRelativeTo(null);
        setLayout(null);
        add(jlab1);
        add(jtf1);
        add(jlab2);
        add(jtf2);
        add(jlab3);
        add(jtf3);
        add(jlab4);
        add(jtf4);
        
        
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
           

            //getting strings from textfields
            String student_id,student_name,student_contact;
            student_id=jtf1.getText();
            student_name=jtf2.getText();
            student_contact=jtf4.getText();
               
            // Create an instance of SimpleDateFormat used for formatting 
            // the string representation of date (month/day/year)
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            // Get the date today using Calendar object.
            Date current = Calendar.getInstance().getTime();        
            // Using DateFormat format method we can create a string 
            // representation of a date with the defined format.
            String issueDate = df.format(current);
            ArrayList<String> list = new ArrayList<String>();
            
            while(res.next()){
                list.add(res.getString("book_id"));
             }
            Object[] result = list.toArray();
            int n=Integer.parseInt(jtf3.getText());
            if(i<n && i<3){
            String input = (String) JOptionPane.showInputDialog(null, "Book ID","Library Management System", JOptionPane.INFORMATION_MESSAGE, null, result, result[0]);
            
            if (i==0){
            a[i]=input;
            sql1="insert into issue_book values(default,'"+a[i]+"','"+student_id+"','"+student_name+"','"+student_contact+"','"+issueDate+"')";
            int m=stmt.executeUpdate(sql1);
            sql2="UPDATE book SET issued = issued + 1 WHERE book_id = '"+a[i]+"'";
           int m1=stmt.executeUpdate(sql2);
            }else if(i==1 && a[0].equals(input)){
            JOptionPane.showMessageDialog(this, "Cannot Issue Same Book Twice");               
            i=i-1;
            }else if(i==2 &&( a[0].equals(input) || a[1].equals(input))){
            JOptionPane.showMessageDialog(this, "Cannot Issue Same Book Twice");               
            i=i-1;}
            else{           
            a[i]=input;
            sql1="insert into issue_book values(default,'"+a[i]+"','"+student_id+"','"+student_name+"','"+student_contact+"','"+issueDate+"')";
            int m=stmt.executeUpdate(sql1);
            sql2="UPDATE book SET issued = issued + 1 WHERE book_id = '"+a[i]+"'";
            int m1=stmt.executeUpdate(sql2);
            }
            i++;
            
          
            
            
            
            
            }         
            
            else{
            JOptionPane.showMessageDialog(this, "NO MORE BOOKS CAN BE ISSUED");
            this.dispose();
            new LibrarianInterface();
            }
            
            
            }
            catch(Exception err){
           err.printStackTrace();
       }
        }
        
    }
}
