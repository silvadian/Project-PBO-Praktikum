import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class tambahsaldo extends JFrame{
    JLabel judul = new JLabel("Tambah Saldo");
    JLabel saldo = new JLabel("Saldo Saat Ini (Rp)");
    JLabel tambah = new JLabel("Tambah Saldo (Rp)");
    
    JTextField sld = new JTextField();
    JTextField tmb = new JTextField();
    
    JButton ts = new JButton("Tambahkan");
    
    
     public void komponen(){
        setTitle("Bank RHR");
        setSize(400, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.blue);
        judul.setBounds(125, 20, 200, 50);
        
        saldo.setBounds(20, 80, 150, 25);
        tambah.setBounds(20, 110, 150, 25);
        
        add(judul);
        add(saldo);
        add(tambah);
        
        
        sld.setText(null);
        sld.setBounds(190, 80, 150, 25);
        tmb.setBounds(190, 110, 150, 25);
        
        
        add(sld);
        add(tmb);
        
        
        ts.setForeground(Color.red);
        ts.setBounds(140, 150, 110, 25);
        add(ts);
        
        
        ts.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){ 
            
            if(tmb.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Silahkan isi jumlah saldo yang ingin ditambahkan");
                }
            
           else {
                JOptionPane.showMessageDialog(null,"    Saldo berhasil ditambah\n" + "Saldo anda sebesar Rp " + saldo);
                dispose();
        }}
    });
     }
     public void saldo(){
         try{
             int id=1;
               
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from tbnasabah where id_nsb = '" + id+"'");
     }catch(Exception ae){
         
     }
     }
     public static void main (String[] args){
         tambahsaldo c = new tambahsaldo();
         c.komponen();
     }
}