import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class daftar extends JFrame{
    int a;
    
     JLabel judul = new JLabel("Daftar Nasabah");
     JLabel id = new JLabel("Id Nasabah");
     JLabel ket = new JLabel("*Masukan 4 digit nomor");
     JLabel nama = new JLabel("Nama");
     JLabel user = new JLabel("Username");
     JLabel pass = new JLabel("Password");
    
     JTextField idn = new JTextField();
     JTextField nm = new JTextField();
     JTextField usr = new JTextField();
     JPasswordField pwd = new JPasswordField();
    
     JButton simpan = new JButton("Simpan");
     JButton batal = new JButton("Batal");
    
     
    
     public void komponen(){
        setTitle("Bank RHR");
        setSize(330, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.blue);
        judul.setBounds(80, 10, 200, 50);
        
        id.setBounds(30, 60, 150, 25);
        nama.setBounds(30, 115, 100, 25);
        user.setBounds(30, 145, 100, 25);
        pass.setBounds(30, 175, 100, 25);
        
        idn.setBounds(120, 60, 150, 25);
        ket.setBounds(120, 80, 150, 25);
        nm.setBounds(120, 115, 150, 25);
        usr.setBounds(120, 145, 150, 25);
        pwd.setBounds(120, 175, 150, 25);
        
        simpan.setBounds(70, 210, 80, 25);     
        batal.setBounds(160, 210, 80, 25);
        
        
        add(judul);
        add(id);
        add(ket);
        add(nama);
        add(user);
        add(pass);
        add(idn);
        add(nm);
        add(usr);
        add(pwd);
        add(simpan);
        add(batal);
        
        
        simpan.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event){
             if(idn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Id tidak boleh kosong");
                a=1;
             }else if(nm.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
                a=1;
             }else if(usr.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
                a=1;
             }else if(pwd.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
                 a=1;
            }
             
    if(a!=1){
        JOptionPane.showMessageDialog(null, "Selamat anda telah menjadi nasabah di Bank PAW\n" + "                           Silahkan Login");
        dispose();
    
    try{
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
        PreparedStatement stat = cn.prepareStatement("insert into tbnasabah values ('" + idn.getText() + "', '" + nm.getText() + "', '" + usr.getText() + "', '" + pwd.getText() + "')");
        stat.executeUpdate();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null ," Id Sudah Ada");
    }}
    else{
    JOptionPane.showMessageDialog(null,"Isi Data Dengan Benar");
    }
    idn.setText("");
    nm.setText("");
    usr.setText("");
    pwd.setText("");
    } 
    });
        
        batal.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event){
            dispose();  
        }
    });
    }
     
          public static void main (String[] args){
          daftar s = new daftar();
          s.komponen();
     }
}