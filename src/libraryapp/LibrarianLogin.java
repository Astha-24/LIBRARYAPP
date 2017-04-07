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

public class LibrarianLogin implements ActionListener  {
    JFrame jfrm;
    JLabel jlab,jlabpass;
    JTextField jtf;
    JButton jbtn;
    JPasswordField jpass;
    public LibrarianLogin(){
        jfrm=new JFrame();
        jfrm.setTitle("Library Management System") ;
        jlab=new JLabel("LIBRARIAN ID");
        jtf=new JTextField(25);
        jlabpass=new JLabel("LIBRARIAN PASSWORD");
        jpass=new JPasswordField(25);
        jbtn=new JButton("Enter System");
        
        
        //jtf.setToolTipText("Enter Librarian ID");
        
        /* Screen Layout */
        jlab.setBounds(10,10,200,25);
        jtf.setBounds(220, 10, 200, 25);
        jlabpass.setBounds(10,45,200,25);
        jpass.setBounds(220,45,200,25);
        jbtn.setBounds(230,80,150,25);
        
        
        
        jfrm.setSize(470,160);
        jfrm.setLocationRelativeTo(null);
        jfrm.setLayout(null);
        jfrm.add(jlab);
        jfrm.add(jtf);
        jfrm.add(jlabpass);
        jfrm.add(jpass);
        jfrm.add(jbtn);
        jbtn.addActionListener(this);
        jfrm.setVisible(true);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        String user_name,password;
        user_name=jtf.getText();
        password=jpass.getText();
        
        
        /* Database Connections */
        DatabaseConnection dbconn;
        Connection conn;
        Statement stmt;
        String sql; 
        ResultSet res;        
        
        
        
        
        try{
            dbconn=new DatabaseConnection();
            conn=dbconn.setConnection();
            stmt=conn.createStatement();
            sql="select * from Librarian";
            res=stmt.executeQuery(sql);
            int flag=0;
            while(res.next()){
                if (res.getString("ID").equals(user_name)){
                    if(res.getString("PASSWORD").equals(password)){
                        jfrm.dispose();
                        new LibrarianInterface();
                        flag=1;
                        break;
                    }
                
                }}
            if (flag==0){
              JOptionPane.showMessageDialog(jfrm,"Authentication Not Succesful");  
            }
            
           
            
        }
        catch(Exception err){
            err.printStackTrace();
        }
        
                
        }

}

