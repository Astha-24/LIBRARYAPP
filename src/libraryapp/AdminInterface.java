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
public class AdminInterface extends JFrame implements ActionListener {
    public AdminInterface(){
        setTitle("Library Management System") ;        
        setSize(400,250);
        setLocationRelativeTo(null);     
             
        
        JButton jbtn1;
        jbtn1=new JButton("Add Librarian");   
        JButton jbtn2;
        jbtn2=new JButton("View Librarian");
        add(jbtn1);
        add(jbtn2);
        JButton jbtn3;
        jbtn3=new JButton("Delete Librarian");   
        JButton jbtn4;
        jbtn4=new JButton("Logout");
        add(jbtn3);
        add(jbtn4);
        setLayout(null);
        
        //layouts
        jbtn1.setBounds(125,25,150,25);
        jbtn2.setBounds(125,75,150,25);
        jbtn3.setBounds(125,125,150,25);
        jbtn4.setBounds(125,175,150,25);
        
        //Listner Interface
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        jbtn3.addActionListener(this);
        jbtn4.addActionListener(this);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
