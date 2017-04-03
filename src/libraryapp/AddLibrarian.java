
package libraryapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AddLibrarian extends JFrame implements ActionListener{
   /*Database Connections*/
    Connection conn;
    DatabaseConnection dbconn;
    Statement stmt,stmt1;
    String sql,sql1;
    ResultSet res;
    JTextField jtf1,jtf2,jtf4,jtf5,jtf6;
    JPasswordField jtf3;
    
    public AddLibrarian(){
        setTitle("Library Management System") ;
        JLabel jlab1=new JLabel("ID");
        jtf1=new JTextField(25);
        JLabel jlab2=new JLabel("NAME");
        jtf2=new JTextField(25);
        JLabel jlab3=new JLabel("PASSWORD");
        jtf3=new JPasswordField(25);
        
        JLabel jlab4=new JLabel("EMAIL");
        jtf4=new JTextField(25);
        JLabel jlab5=new JLabel("CITY");
        jtf5=new JTextField(25);
        JLabel jlab6=new JLabel("CONTACT");
        jtf6=new JTextField(25);
        
        JButton jbtn=new JButton("Register");
        
        
        
        
        
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
        jlab6.setBounds(10,185,200,25);
        jtf6.setBounds(220,185,200,25);
        
        
        jbtn.setBounds(230,220,150,25);
        
        
        
        setSize(470,320);
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
        add(jlab6);
        add(jtf6);
        
        jtf1.setToolTipText("ID must be an Integer");
        
        
        
        add(jbtn);
        jbtn.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*DatabaseConnection*/
        dbconn=new DatabaseConnection();
        conn=dbconn.setConnection();
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Register")){
            int id;
            String name,pass,email,city,contact; 
            
            id=Integer.parseInt(jtf1.getText());
            try{
            stmt1=conn.createStatement();
            sql1="select * from librarian";
            res =stmt1.executeQuery(sql1);
            while (res.next()){
                if (res.getString("id").equals(jtf1.getText())){
                    JOptionPane.showMessageDialog(this, "This ID is not unique");
                    break;
                }
            }}catch(Exception esss){
                //esss.printStackTrace();
            }
            
            
            
            
        name=jtf2.getText();
        pass=jtf3.getText();
        email=jtf4.getText();
        city=jtf5.getText();
        contact=jtf6.getText();
        
        if (jtf1.getText().trim().length()!=0 && name.trim().length()!=0 && pass.trim().length()!=0 && email.trim().length()!=0 && city.trim().length()!=0 && contact.trim().length()!=0){
                
            try{
            stmt=conn.createStatement();
            sql= "insert into librarian values ('"+id+"','"+name+"','"+pass+"','"+email+"','"+city+"','"+contact+"')";
            
            int i=stmt.executeUpdate(sql);
            
            if (i>0){
                System.out.println("Row Inserted");
                JOptionPane.showMessageDialog(this, "Added successfully");
                this.setVisible(false);
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(this, "Check your input parameters");
                System.out.println("Row Not Inserted");
            }
        }catch(Exception est){
            //est.printStackTrace();
        }}else{
            JOptionPane.showMessageDialog(this, "All Fields are Mandatory");       
                            
        }
            }
    }
}
