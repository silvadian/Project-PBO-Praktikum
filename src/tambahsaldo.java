import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class tambahsaldo extends JFrame implements ActionListener{
    String Saldo, user, Nama;
    int id;
    
    JLabel judul = new JLabel("Tambah Saldo");
    JLabel saldo = new JLabel("Saldo Saat Ini (Rp)");
    JLabel tambah = new JLabel("Tambah Saldo (Rp)");
    
    JTextField sld = new JTextField();
    JTextField tmb = new JTextField();
    
    JButton ts = new JButton("Tambahkan");
    JButton bc = new JButton("Batal");
    
    
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
        
        
        sld.setText(Saldo);
        sld.setEnabled(false);
        sld.setBounds(190, 80, 150, 25);
        tmb.setBounds(190, 110, 150, 25);
        
        
        add(sld);
        add(tmb);
        
        
        ts.setForeground(Color.red);
        ts.setBounds(60, 150, 110, 25);
        add(ts);
        ts.addActionListener(this);
        
        bc.setForeground(Color.red);
        bc.setBounds(190, 150, 110, 25);
        add(bc);
        bc.addActionListener(this);
               
     }
     
     
     public tambahsaldo(int id, String user, String nm){
         this.id = id;
         this.user = user;
         this.Nama = nm;
         saldo();
     }
     
     //method cek saldo
     public void saldo(){
         try{
              
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from tbinfo where id_nsb = '" + id+"'");
                while(rs.next()){
                    Saldo = rs.getString(3);
                }
                
     }catch(Exception ae){
         JOptionPane.showMessageDialog(this, ae);
     }
         
     }
     
    
      
     public static void main (String[] args){
         tambahsaldo c = new tambahsaldo(0, null, null);
         c.komponen();
     }

     
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ts==ae.getSource()){
            if(tmb.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Silahkan isi jumlah saldo yang ingin ditambahkan");
                }
            
           else {
         
                if(sld.getText().equals("")){
                    
                   try{
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                PreparedStatement stat = cn.prepareStatement("insert into tbinfo values ('" + id + "', '" + Nama + "', '" + tmb.getText() +"')");
                stat.executeUpdate();
                saldo();
               
                JOptionPane.showMessageDialog(null,"Saldo berhasil ditambah\n" + "Saldo anda sebesar Rp"+Saldo);
                
                 form x = new form(id,user, Nama);
                 x.setVisible(true);
                 x.komponen();
                }catch(SQLException e){
                
                } 
                  
                } else {
                    
                     int saldo = Integer.parseInt(Saldo) + Integer.parseInt(tmb.getText());
                    
                     
                    //UPDATE DATA NASABAH PADA TABEL INFO NASABAH
                    
                    try{
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                    PreparedStatement st = cn.prepareStatement("UPDATE tbinfo SET jml_saldo = '"+String.valueOf(saldo)+"' where id_nsb = '"+id+"'");
                    st.executeUpdate();
                    
                    
                    saldo();
                    JOptionPane.showMessageDialog(null,"Saldo berhasil ditambah\n" + "Saldo anda sebesar Rp"+Saldo);
                    
                    
                    form x = new form(id,user, Nama);
                    x.komponen();
                }catch(Exception e){
                    
                }
                }
                dispose();
        }
        
        }else if(bc==ae.getSource()){
                dispose();
                form x = new form(id,user, Nama);
                 x.setVisible(true);
                 x.komponen();
        }
    }
}