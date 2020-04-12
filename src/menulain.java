import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class menulain extends JFrame implements ActionListener{
    String Saldo;
    JLabel judul = new JLabel("Menu Tambahan");
    
    JCheckBox pulsa = new JCheckBox("Pulsa");
    JCheckBox listrik = new JCheckBox("Listrik");
    
    JRadioButton axis = new JRadioButton("Axis");
    JRadioButton indosat = new JRadioButton("Indosat / IM3");
    JRadioButton three = new JRadioButton("Three");
    JRadioButton tsel = new JRadioButton("Telkomsel");
    JRadioButton xl = new JRadioButton("XL");
    
    JButton beli = new JButton("Beli");
    JButton info = new JButton("Info Nasabah");
    JButton back = new JButton("Kembali");
    
            JLabel meter = new JLabel("Nomor Meter");
            JLabel nml = new JLabel("Nominal");
            JLabel ket = new JLabel("*Masukan nomor 11 digit");
            JTextField mtr = new JTextField();
            JTextField nomi = new JTextField();
            
            JLabel nomor = new JLabel("Nomor");
            JLabel nominal = new JLabel("Nominal");
            JTextField nmr = new JTextField();
            JTextField nmnl = new JTextField();
    
    
    public void komponen(){
        setTitle("Bank PAW");
        setSize(350, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);
        
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.blue);
        judul.setBounds(90, 15, 200, 50);
        
        pulsa.setBounds(35, 60, 120, 25);
        axis.setEnabled(false);
        axis.setBounds(50, 85, 100, 25);
        indosat.setEnabled(false);
        indosat.setBounds(50, 105, 100, 25);
        three.setEnabled(false);
        three.setBounds(50, 125, 100, 25);
        tsel.setEnabled(false);
        tsel.setBounds(50, 145, 100, 25);
        xl.setEnabled(false);
        xl.setBounds(50, 165, 100, 25);
        listrik.setBounds(35, 195, 120, 25);        
        
         
            nomor.setBounds(20, 240, 100, 25);
            nominal.setBounds(20, 270, 100, 25);
            nmr.setBounds(130, 240, 180, 25);
            nmnl.setBounds(130, 270, 180, 25);
            add(nomor);
            add(nominal);
            add(nmr);
            add(nmnl);
            nomor.setVisible(false);
            nominal.setVisible(false);
            nmr.setVisible(false);
            nmnl.setVisible(false);
        
        info.setForeground(Color.red);
        info.setBounds(200, 105, 110, 25);
        
        beli.setForeground(Color.red);
        beli.setBounds(200, 135, 110, 25);
        
        back.setForeground(Color.red);
        back.setBounds(200, 165, 110, 25);
        
        
       
        axis.addActionListener(this);
        
        indosat.addActionListener(this);
        
        three.addActionListener(this);
       
        tsel.addActionListener(this);
        
        xl.addActionListener(this);
        add(listrik);
        listrik.addActionListener(this);
        
        add(judul);
        add(pulsa);
        pulsa.addActionListener(this);
        add(axis);
        add(indosat);
        add(three);
        add(tsel);
        add(xl);
        
        add(beli);
        beli.addActionListener(this);
        add(info);
        info.addActionListener(this);
        add(back);
        back.addActionListener(this);
        
        
        
            
    
    }
    int id;
    String user,Nama;
    //construktor MENU LAIN YANG DIKIRIM DARI FORM
    public menulain(int id, String user, String nama){
        this.id = id;
        this.user = user;
        this.Nama = nama;
    }

    
    public static void main (String[] args){
         menulain e = new menulain(0,null,null);
         e.komponen();
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(listrik.isSelected() ){
             
             
            meter.setBounds(20, 240, 100, 25);
            nml.setBounds(20, 295, 100, 25);
            mtr.setBounds(130, 240, 100, 25);
            ket.setBounds(130, 265, 150, 20);
            nomi.setBounds(130, 295, 100, 25);
            add(meter);
            add(nml);
            add(mtr);
            add(ket);
            add(nomi);
            meter.setVisible(true);         
            nml.setVisible(true);
            mtr.setVisible(true);
            ket.setVisible(true);
            nomi.setVisible(true);
            
            
        }else if(listrik.isSelected()== false){
            //MENGHILANGKAN KOLOM INPUT LISTRIK
            meter.setVisible(false);         
            nml.setVisible(false);
            mtr.setVisible(false);
            ket.setVisible(false);
            nomi.setVisible(false);
        }
        if(pulsa.isSelected() && listrik.isSelected()){
            
            axis.setEnabled(true);
            indosat.setEnabled(true);
            three.setEnabled(true);
            tsel.setEnabled(true);
            xl.setEnabled(true);
            //MEMUNCULKAN KOLOM INPUT PULSA
            nomor.setVisible(true);
            nominal.setVisible(true);
            nmr.setVisible(true);
            nmnl.setVisible(true);
              
            
            meter.setBounds(20, 300, 100, 25);
            nml.setBounds(20, 355, 100, 25);
            mtr.setBounds(130, 300, 100, 25);
            ket.setBounds(130, 325, 150, 20);
            nomi.setBounds(130, 355, 100, 25);
            add(meter);
            add(nml);
            add(mtr);
            add(ket);
            add(nomi);
            
            
            if(axis==ae.getSource()){
                nmr.setText("+6283");
                
                indosat.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(indosat==ae.getSource()){
                nmr.setText("+6285");      
                
                axis.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(three==ae.getSource()){
                nmr.setText("+6289");
                
                indosat.setSelected(false);
                axis.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(tsel==ae.getSource()){
                nmr.setText("+6281");
                
                indosat.setSelected(false);
                three.setSelected(false);
                axis.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(xl==ae.getSource()){
                nmr.setText("+6287"); 
                
                indosat.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                axis.setSelected(false);
            }

        }
        if(pulsa.isSelected() && listrik.isSelected()==false) {
            
            
            axis.setEnabled(true);
            indosat.setEnabled(true);
            three.setEnabled(true);
            tsel.setEnabled(true);
            xl.setEnabled(true);
            
            
            nomor.setVisible(true);
            nominal.setVisible(true);
            nmr.setVisible(true);
            nmnl.setVisible(true);
           
            
            if(axis==ae.getSource()){
                nmr.setText("+6283");
                
                indosat.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(indosat==ae.getSource()){
                nmr.setText("+6285");      
               
                axis.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(three==ae.getSource()){
                nmr.setText("+6289");
                
                indosat.setSelected(false);
                axis.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(tsel==ae.getSource()){
                nmr.setText("+6281");
                
                indosat.setSelected(false);
                three.setSelected(false);
                axis.setSelected(false);
                xl.setSelected(false);
            }
            
            else if(xl==ae.getSource()){
                nmr.setText("+6287"); 
                
                indosat.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                axis.setSelected(false);
            }
            
            
        }else if (pulsa.isSelected() == false){
           
            axis.setEnabled(false);
            indosat.setEnabled(false);
            three.setEnabled(false);
            tsel.setEnabled(false);
            xl.setEnabled(false);
            
            
                axis.setSelected(false);
                indosat.setSelected(false);
                three.setSelected(false);
                tsel.setSelected(false);
                xl.setSelected(false);
         
            
            nomor.setVisible(false);
            nominal.setVisible(false);
            nmr.setVisible(false);
            nmnl.setVisible(false);
            
        }
        
        if(info==ae.getSource()){
            dispose();
            info_nasabah k = new info_nasabah(id,user,Nama);
            k.setSize(450, 400);
            k.setLayout(null);
            k.setLocationRelativeTo(null);
            k.komponen();
            
            k.setVisible(true);
            
        
        }else if (back==ae.getSource()){
             dispose();
            
                form x = new form(id,user, Nama);
                 x.setVisible(true);
                 x.komponen();
                
         
        }else if(beli==ae.getSource()){
            
            saldo();
            
            if(listrik.isSelected() && pulsa.isSelected() == false){
               
                long bayar = Long.parseLong(Saldo) - Long.parseLong(nomi.getText());
                try{
                    // UPDATE DI DATABASE
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                    PreparedStatement st = cn.prepareStatement("UPDATE tbinfo SET jml_saldo = '"+String.valueOf(bayar)+"' where id_nsb = '"+id+"'");
                    st.executeUpdate();
                    
                    saldo();
                    JOptionPane.showMessageDialog(null,"Anda Membayar Listrik Sebesar Rp." +nomi.getText()+ 
                                                        "\nDengan Nomor Meter "+mtr.getText()+"\nSisa Saldo Anda Rp. "+Saldo);
                    mtr.setText("");
                    nomi.setText("");
                }catch(Exception e){
                    
                }
                
                
            }else if(pulsa.isSelected() && listrik.isSelected()==false){
                
                long bayar = Long.parseLong(Saldo) - Long.parseLong(nmnl.getText());
                try{
                     
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                    PreparedStatement st = cn.prepareStatement("UPDATE tbinfo SET jml_saldo = '"+String.valueOf(bayar)+"' where id_nsb = '"+id+"'");
                    st.executeUpdate();
                    
                    
                    saldo();
                    JOptionPane.showMessageDialog(null,"Anda Membeli Pulsa Sebesar Rp." +nmnl.getText()+ 
                                                        "\nDengan Nomor "+nmr.getText()+"\nSisa Saldo Anda Rp. "+Saldo);
                    
                    nmr.setText("");
                    nmnl.setText("");
                }catch(Exception e){
                    
                }
                
            }else if(pulsa.isSelected() && listrik.isSelected()){
                
                long bayar = Long.parseLong(Saldo) - (Long.parseLong(nmnl.getText()) + Long.parseLong(nomi.getText()));
                try{
                    //SCRIPT UPDATE
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                    PreparedStatement st = cn.prepareStatement("UPDATE tbinfo SET jml_saldo = '"+String.valueOf(bayar)+"' where id_nsb = '"+id+"'");
                    st.executeUpdate();
                    
                    
                    saldo();
                    
                    JOptionPane.showMessageDialog(null,"Anda Membeli Pulsa Sebesar Rp." +nmnl.getText()+ 
                                                        "\nDengan Nomor "+nmr.getText()+"\nDan Membayar Listrik Sebesar Rp." +nomi.getText()+ 
                                                        "\nDengan Meter "+mtr.getText()+"\nSisa Saldo Anda Rp. "+Saldo);
                    nmr.setText("");
                    nmnl.setText("");
                    mtr.setText("");
                    nomi.setText("");
                }catch(Exception e){
                    
                }
            }
        }
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
}
