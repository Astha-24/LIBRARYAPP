/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class LIBRARYAPP extends JFrame implements ActionListener {
    public LIBRARYAPP(){
        setTitle("Library Management System") ;        
        setSize(400,175);
        setLocationRelativeTo(null);     
             
        
        //Buttons Inserted
        JButton jbtn1;
        jbtn1=new JButton("Admin Login");   
        JButton jbtn2;
        jbtn2=new JButton("Librarian Login");
        add(jbtn1);
        add(jbtn2);
        setLayout(null);
        
        //layouts
        jbtn1.setBounds(125,25,150,25);
        jbtn2.setBounds(125,75,150,25);
        
        //Listner Interface
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    Admin ad=new Admin();
    public static void main(String[] args) {
       LIBRARYAPP lib=new LIBRARYAPP();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Admin Login")){
            this.setVisible(false);
           
            ad.jfrm.setVisible(true);            
        }
        if(e.getActionCommand().equals("Librarian Login")){
        }
    }
    
}
