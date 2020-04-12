import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;


public class transfer extends JFrame implements ActionListener{ 
    String Saldo, user, Nama;
    int id;
    JLabel judul = new JLabel("Transfer");
    JLabel nomor = new JLabel("No. Rekening Tujuan");
    JLabel jumlah = new JLabel("Jumlah Kiriman (Rp)");
    
    JTextField nmr = new JTextField();
    JTextField jml = new JTextField();
    
    JButton tf = new JButton("Transfer");
    JButton bc = new JButton("Kembali");
    
    
     public void komponen(){
        setTitle("Bank PAW");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.blue);
        judul.setBounds(145, 20, 200, 50);
        
        nomor.setBounds(20, 80, 150, 25);
        jumlah.setBounds(20, 110, 150, 25);
        
        add(judul);
        add(nomor);
        add(jumlah);
        
        
        nmr.setBounds(190, 80, 150, 25);
        jml.setBounds(190, 110, 150, 25);
        
        add(nmr);
        add(jml);
        
        
        tf.setForeground(Color.red);
        tf.setBounds(80, 150, 100, 25);
        add(tf);
        tf.addActionListener(this);
        
        bc.setForeground(Color.red);
        bc.setBounds(210, 150, 100, 25);
        add(bc);
        bc.addActionListener(this);
        
        
        
     }
     
     
     public transfer(int id, String user, String nm){
         this.id = id;
         this.user = user;
         this.Nama = nm;
         saldo();
     }
     
     
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
         transfer b = new transfer(0,null,null);
         b.komponen();
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
      if(tf==ae.getSource()){
          if(nmr.getText().equals("")||jml.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong");
                }
            
           else {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Anda akan mentransfer ke rekening " + nmr.getText() + " sebesar Rp " + jml.getText());
            if (selectedOption == JOptionPane.YES_OPTION){
                JTextArea l = new JTextArea();
                l.setBounds(100, 210, 210, 80);
                add(l);
                
                int sisa = Integer.parseInt(Saldo) - Integer.parseInt(jml.getText());
                try{
                    //UPDATE HASIL PENGURANGAN SALDO KEDALAM DATA BASE
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                    PreparedStatement st = cn.prepareStatement("UPDATE tbinfo SET jml_saldo = '"+String.valueOf(sisa)+"' where id_nsb = '"+id+"'");
                    st.executeUpdate();
                }catch(Exception e){
                    
                }
                
                saldo();
                l.setText("   Transaksi berhasil dilakukan\n\n" + "Sisa saldo anda sebesar Rp "+Saldo);   
            }
            else if(selectedOption == JOptionPane.NO_OPTION || selectedOption == JOptionPane.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "Transaksi dibatalkan");
               }
        }
          
          //Kondisi button kembali
      }else if(bc==ae.getSource()){
          dispose();
                form x = new form(id,user, Nama);
                x.dispose();
                 x.setVisible(true);
                 x.komponen();
      }
    }
}