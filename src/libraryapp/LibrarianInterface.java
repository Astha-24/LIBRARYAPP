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
public class LibrarianInterface extends JFrame implements ActionListener {
    public LibrarianInterface(){
        setTitle("Library Management System") ;        
        setSize(400,370);
        setLocationRelativeTo(null);     
             
        
        JButton jbtn1;
        jbtn1=new JButton("Add Book");   
        JButton jbtn2;
        jbtn2=new JButton("View Books");
        add(jbtn1);
        add(jbtn2);
        JButton jbtn3;
        jbtn3=new JButton("Issue Books");   
        JButton jbtn4;
        jbtn4=new JButton("View Issued Books");
         JButton jbtn5;
        jbtn5=new JButton("Return Book");
         JButton jbtn6;
        jbtn6=new JButton("Logout");
        add(jbtn3);
        add(jbtn4);
        add(jbtn5);
        add(jbtn6);
        setLayout(null);
        
        //layouts
        jbtn1.setBounds(125,25,150,25);
        jbtn2.setBounds(125,75,150,25);
        jbtn3.setBounds(125,125,150,25);
        jbtn4.setBounds(125,175,150,25);
        jbtn5.setBounds(125,225,150,25);
        jbtn6.setBounds(125,275,150,25);
        //Listner Interface
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        jbtn3.addActionListener(this);
        jbtn4.addActionListener(this);
        jbtn5.addActionListener(this);
        jbtn6.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    
    
    }
    
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Add Book")){
           
           this.dispose();
           new AddBooks();
       
       }
       if(e.getActionCommand().equals("View Books")){
           
           this.dispose();
           new ViewBooks();
       
       }
     if(e.getActionCommand().equals("Issue Books")){
           
           this.dispose();
           new IssueBook();
       
       }
    /* if(e.getActionCommand().equals("Logout")){
           
           this.setVisible(false);
           new LIBRARYAPP();
       
       }
    }*/
    
}
}