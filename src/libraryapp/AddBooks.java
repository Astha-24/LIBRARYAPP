
package libraryapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddBooks extends JFrame implements ActionListener{
   /*Database Connections*/
    Connection conn;
    DatabaseConnection dbconn;
    Statement stmt,stmt1;
    String sql,sql1;
    ResultSet res;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
   
    
    public AddBooks(){
        setTitle("Library Management System") ;
        JLabel jlab1=new JLabel("ACCESSION NO.");
        jtf1=new JTextField(25);
        JLabel jlab2=new JLabel("BOOK NAME");
        jtf2=new JTextField(25);
        JLabel jlab3=new JLabel("AUTHOR");
        jtf3=new JTextField(25);
        
        JLabel jlab4=new JLabel("PUBLISHER");
        jtf4=new JTextField(25);
        JLabel jlab5=new JLabel("QUANTITY");
        jtf5=new JTextField(25);
        
        
        JButton jbtn=new JButton("OK");
        JButton jbtn1=new JButton("Back");
        
        
        
        
        /* Screen Layout */
        jlab1.setBounds(10,10,200,25);
        jtf1.setBounds(220, 10, 200, 25);
        jlab2.setBounds(10,45,200,25);
        jtf2.setBounds(220,45,200,25);
        jlab3.setBounds(10,80,200,25);
        jtf3.setBounds(220,80,200,25);
        jlab4.setBounds(10,115,200,25);
        jtf4.setBounds(220,115,200,25);
        jlab5.setBounds(10,150,200,25);
        jtf5.setBounds(220,150,200,25);
        
        
        
        jbtn.setBounds(350,185,75,25);
        jbtn1.setBounds(10,185,75,25);
        
        
        setSize(470,270);
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
        add(jlab5);
        add(jtf5);
        
        
        
        
        
        
        
        add(jbtn);
        add(jbtn1);
        jbtn.addActionListener(this);
        jbtn1.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*DatabaseConnection*/
        dbconn=new DatabaseConnection();
        conn=dbconn.setConnection();
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("OK")){
            
            String accession_no,name,author,pub,qty; 
            
           
            
            
            
        accession_no=jtf1.getText();
        name=jtf2.getText();
        author=jtf3.getText();
        pub=jtf4.getText();
        qty=jtf5.getText();
       
        // Create an instance of SimpleDateFormat used for formatting 
// the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

// Get the date today using Calendar object.
        Date current = Calendar.getInstance().getTime();        
    // Using DateFormat format method we can create a string 
// representation of a date with the defined format.
        String reportDate = df.format(current);
        
        if (jtf1.getText().trim().length()!=0 && name.trim().length()!=0 && author.trim().length()!=0 && pub.trim().length()!=0 && qty.trim().length()!=0){
                
            try{
            stmt=conn.createStatement();
            sql= "insert into book values ('"+accession_no+"','"+name+"','"+author+"','"+pub+"','"+qty+"','0','"+reportDate+"')";
            
            int i=stmt.executeUpdate(sql);
            
            if (i>0){
                System.out.println("Row Inserted");
                JOptionPane.showMessageDialog(this, "Added successfully");
                this.setVisible(false);
                new LibrarianInterface();
            }else{
                JOptionPane.showMessageDialog(this, "Check your input parameters");
                System.out.println("Row Not Inserted");
            }
        }catch(Exception est){
            est.printStackTrace();
        }}else{
            JOptionPane.showMessageDialog(this, "All Fields are Mandatory");       
                            
        }
            }
            if(e.getActionCommand().equals("Back")){
                this.dispose();
                new LibrarianInterface();
            }
    
    }
}
