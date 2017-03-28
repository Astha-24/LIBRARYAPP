package libraryapp;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin implements ActionListener  {
    JFrame jfrm;
    JLabel jlab,jlabpass;
    JTextField jtf;
    JButton jbtn;
    JPasswordField jpass;
    public Admin(){
        jfrm=new JFrame();
        jfrm.setTitle("Library Management System") ;
        jlab=new JLabel("ADMIN NAME");
        jtf=new JTextField(25);
        jlabpass=new JLabel("PASSWORD");
        jpass=new JPasswordField(25);
        jbtn=new JButton("Enter System");
        
        
        jtf.setToolTipText("Enter your name");
        
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
        //jfrm.setVisible(true);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        String user_name,password;
        user_name=jtf.getText();
        password=jpass.getText();
        if (password.equals("admin123")&& user_name.equals("admin")){
        JOptionPane.showMessageDialog(jfrm, "Authentication Succesful");}
        else{
            JOptionPane.showMessageDialog(jfrm, "Authentication Failed");}
        }
        //
        }



