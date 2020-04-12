import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class login extends JFrame{
     JLabel judul = new JLabel("Login Here");
     JLabel user = new JLabel("Username");
     JLabel pass = new JLabel("Password");
     JLabel daftar = new JLabel("Belum Punya Akun?");
    
     JTextField usr = new JTextField();
     JPasswordField pwd = new JPasswordField();
    
     JButton login = new JButton("Login");
     JButton cancel = new JButton("Cancel");
     JButton dftr = new JButton("Daftar");
    
     
    
     public void komponen(){
        setTitle("BANK PAW");
        setSize(350, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 20));
        judul.setForeground(Color.blue);
        judul.setBounds(113, 10, 200, 50);
        
        user.setBounds(30, 60, 100, 25);
        pass.setBounds(30, 90, 100, 25);
        
        daftar.setForeground(Color.red);
        daftar.setBounds(50, 200, 120, 20);
        
        usr.setBounds(120, 60, 180, 25);
        pwd.setBounds(120, 90, 180, 25);
        login.setBounds(80, 150, 80, 25);
        cancel.setBounds(180, 150, 80, 25);
        
        dftr.setForeground(Color.red);
        dftr.setBounds(180, 200, 80, 20);
        
        
        add(judul);
        add(user);
        add(pass);
        add(daftar);
        add(usr);
        add(pwd);
        add(login);
        add(cancel);
        add(dftr);
        
        
        login.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from tbnasabah where username = '" + usr.getText() + "' and password = '" + pwd.getText() + "'");
                
                if(usr.getText().equals("") || pwd.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Isi data dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
                    usr.setText("");
                    usr.requestFocus();
                }
                else if(rs.next()){
                    if(rs.getString("password").equals(pwd.getText())){
                        int id = rs.getInt(1);
                        String user = usr.getText();
                        String nama = rs.getString(2);
                        //kirim data pada construktor form
                        form r = new form(id , user, nama);
                        r.setSize(450, 400);
                        r.setLayout(null);
                        r.setLocationRelativeTo(null);
                        r.komponen();
                        r.setVisible(true); 
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                        pwd.setText("");
                        pwd.requestFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username salah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Login gagal!!");
            }
    }
        
    });
        
        
        dftr.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event){
            daftar reny = new daftar();
            reny.setSize(350, 300);
            reny.setLayout(null);
            reny.setLocationRelativeTo(null);
            reny.komponen();
            reny.setVisible(true);
        }
        });
        
        
        cancel.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event){
            System.exit(0);
     }
    });
                }
     
     
     public static void main (String[] args){
         login r = new login();
         r.komponen();
     }
}