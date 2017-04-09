
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ReturnBook extends JFrame implements ActionListener{
    DatabaseConnection dbconn;
    Connection conn;
    Statement stmt,stmt1;
    String sql,sql1,sql2,sql3;
    JLabel jlb1;
    JComboBox jcb;
    JButton jb1,jb2;
    ResultSet res,res1;
    
    
    public ReturnBook(){
        jlb1=new JLabel("ENTER STUDENT ID");
        jcb=new JComboBox();
          try{
            dbconn= new DatabaseConnection();
            conn=dbconn.setConnection();
            stmt=conn.createStatement();
            sql="SELECT DISTINCT(student_id) AS student_id FROM issue_book";
            res=stmt.executeQuery(sql);
            while(res.next()){
                jcb.addItem(res.getString("student_id"));
            }
          } catch(Exception e){
          
          }
        jb1=new JButton("OK");
        jb2=new JButton("Back");
        add(jlb1);
        add(jcb);
        add(jb1);
        add(jb2);
        jlb1.setBounds(10,10,200,25);
        jcb.setBounds(220, 10, 200, 25);
        jb1.setBounds(220,50,100,25);
        jb2.setBounds(10,50,100,25);
        setSize(470,140);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
          if (e.getActionCommand().equals("OK")){
            try{
            String student_id;
            student_id=jcb.getSelectedItem().toString();
            dbconn= new DatabaseConnection();
            conn=dbconn.setConnection();
            stmt1=conn.createStatement();
            sql1="select accession_no from issue_book where student_id='"+student_id+"'";
            res1=stmt.executeQuery(sql1);
           ArrayList<String> list = new ArrayList<String>();
            
            while(res1.next()){
                list.add(res1.getString("accession_no"));
             }
            Object[] result = list.toArray();
            String input = (String) JOptionPane.showInputDialog(null, "Accession No","Library Management System", JOptionPane.INFORMATION_MESSAGE, null, result, result[0]);
            sql2="delete from issue_book where accession_no='"+input+"'";
            int i=stmt1.executeUpdate(sql2);
            sql="select book_id from issue_book WHERE accession_no='"+input+"'";
            res=stmt.executeQuery(sql);
           sql3="UPDATE book SET issued = issued - 1 WHERE book_id = '"+input+"'";
           int m1=stmt.executeUpdate(sql2);
            
         }catch(Exception err){
             err.printStackTrace();
         }}
    if(e.getActionCommand().equals("Back")){
        this.dispose();
        new LibrarianInterface();
    }
    
    
    }

}
