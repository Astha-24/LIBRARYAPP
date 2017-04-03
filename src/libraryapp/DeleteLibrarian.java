
package libraryapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteLibrarian extends JFrame implements ActionListener{
    DatabaseConnection dbconn;
    Connection conn;
    Statement stmt;
    String sql;
    JLabel jlb1;
    JTextField jt1;
    JButton jb1;
    public DeleteLibrarian(){
        jlb1=new JLabel("ENTER ID");
        jt1=new JTextField(25);
        jb1=new JButton("OK");
        add(jlb1);
        add(jt1);
        add(jb1);
        jlb1.setBounds(10,10,200,25);
        jt1.setBounds(220, 10, 200, 25);
        jb1.setBounds(220,50,100,25);
        setSize(470,140);
        jb1.addActionListener(this);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand().equals("OK")){
                try{
        dbconn=new DatabaseConnection();
        conn=dbconn.setConnection();
        stmt=conn.createStatement();
        sql="delete from librarian where id='"+jt1.getText()+"'";
        int i=stmt.executeUpdate(sql);
        if(i>0){
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Deleted Successfully");
            System.exit(0);
        
        }
        else{
             JOptionPane.showMessageDialog(this, "Please enter a valid ID");
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         
         
         
         }
    
    
    
    }

}
