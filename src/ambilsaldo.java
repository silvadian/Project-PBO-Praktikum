import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;

public class ambilsaldo extends JFrame implements ActionListener{
    String Saldo,user,Nama;
    int id;
    
    JLabel judul = new JLabel("Ambil Saldo");
    JLabel saldo = new JLabel("Saldo Saat Ini (Rp)");
    JLabel ambil = new JLabel("Saldo yang akan di ambil (Rp)");
    
    JTextField sld = new JTextField();
    JTextField amb = new JTextField();
    
    JButton as = new JButton("Tarik");
    JButton bc = new JButton("Kembali");
    
    
     public void komponen(){
        setTitle("Bank RHR");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);
        
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.blue);
        judul.setBounds(125, 20, 200, 50);
        
        saldo.setBounds(20, 80, 150, 25);
        ambil.setBounds(20, 110, 170, 25);
        
        add(judul);
        add(saldo);
        add(ambil);
        
        if(Saldo.equals("")){
                Saldo = "0";
        }else{
                
        }
        sld.setText(Saldo);
        sld.setEnabled(false);
        sld.setBounds(200, 80, 150, 25);
        amb.setBounds(200, 110, 150, 25);
        
        add(sld);
        add(amb);
        
        
        as.setForeground(Color.red);
        as.setBounds(100, 150, 90, 25);
        add(as);
        as.addActionListener(this);
        
        bc.setForeground(Color.red);
        bc.setBounds(210, 150, 90, 25);
        add(bc);
        bc.addActionListener(this);
        
        

        
    
     }
     
     //construktor AMBIL SALDO
     public ambilsaldo(int id, String user, String nm){
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
         ambilsaldo d = new ambilsaldo(0,null,null);
         d.komponen();
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(as==ae.getSource()){
            if(amb.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Silahkan isi saldo yang ingin anda ambil");
                }
            
           else {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Anda yakin ingin mengambil saldo sebesar (Rp) " + amb.getText());
            if (selectedOption == JOptionPane.YES_OPTION){
                JTextArea l = new JTextArea();
                l.setBounds(100, 210, 210, 80);
                int sisa = Integer.parseInt(Saldo) - Integer.parseInt(amb.getText());
                add(l);
                l.setText("   Transaksi berhasil dilakukan\n\n" + "Sisa saldo anda sebesar Rp "+sisa);   
                
                //database di update 
                try{
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                    PreparedStatement st = cn.prepareStatement("UPDATE tbinfo SET jml_saldo = '"+String.valueOf(sisa)+"' where id_nsb = '"+id+"'");
                    st.executeUpdate();
                }catch(Exception e){
                    
                }
                
            }
            else if(selectedOption == JOptionPane.NO_OPTION || selectedOption == JOptionPane.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "Transaksi dibatalkan");
               }
        }
            
        }else if(bc==ae.getSource()){
                dispose();
                form x = new form(id,user, Nama);
                 x.setVisible(true);
                 x.komponen();
        }
    }
}