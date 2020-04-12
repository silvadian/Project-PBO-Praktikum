import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class form extends JFrame{
    int id;
    String Saldo ="", user, Nama;
    
    
        //desain
        JLabel judul = new JLabel("Selamat Datang");
        JLabel judul1 = new JLabel("di Bank PAW");
        JLabel pilih = new JLabel("Silahkan pilih menu dibawah ini :");
        JLabel nama = new JLabel("Nama Nasabah");
        JLabel saldo = new JLabel("Saldo yang dimiliki");
        
        JTextField nm = new JTextField();
        JTextField jsaldo = new JTextField();
        
        JButton cek = new JButton("Cek Saldo");
        JButton tf = new JButton("Transfer");
        JButton tambah = new JButton("Tambah Saldo");
        JButton ambil = new JButton("Tarik Saldo");
        JButton menu = new JButton("Menu Lainnya");
        JButton exit = new JButton("Keluar");
        public form(int id, String user, String nm){
            this.id = id;
            this.user = user;
            this.Nama = nm;
            saldo();
        }
        
    public void komponen(){
        setTitle("Bank RHR");
        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    
        if(Saldo.equals("")){
                Saldo = "0";
        }else{
                
        }
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.red);
        judul.setBounds(145, 20, 200, 50);
        
        judul1.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul1.setForeground(Color.red);
        judul1.setBounds(155, 45, 200, 50);
        
        pilih.setBounds(20, 120, 200, 25);
        nama.setBounds(270, 110, 200, 25);
        saldo.setBounds(270, 175, 200, 25);
        
        add(judul);
        add(judul1);
        add(pilih);
        add(nama);
        add(saldo);
        
        nm.setText(Nama);
        nm.setEnabled(false);
        nm.setBounds(270, 135, 150, 25);
        jsaldo.setText(Saldo);
        jsaldo.setEnabled(false);
        jsaldo.setBounds(270, 200, 150, 25);
        
        add(nm);
        add(jsaldo);
        

        cek.setBounds(20, 145, 120, 20);
        tf.setBounds(20, 175, 120, 20);
        tambah.setBounds(20, 205, 120, 20);
        ambil.setBounds(20, 235, 120, 20);
        menu.setBounds(20, 265, 120, 20);
        exit.setForeground(Color.blue);
        exit.setBounds(20, 295, 120, 20);
        
        add(cek);
        add(tf);
        add(tambah);
        add(ambil);
        add(menu);
        add(exit);
        
        
        
        //proses
        cek.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            //panggil method cek saldo
            saldo();
            //merubah yang tadinya nul menjadi 0 dengan kondisi jika tidak ada saldo maka saldo 0
            if(Saldo.equals("")){
                Saldo = "0";
            }else{
                
            }
            JOptionPane.showMessageDialog(null, "Saldo anda saat ini sebesar : Rp " + Saldo, "Informasi Saldo", JOptionPane.INFORMATION_MESSAGE);
        }
    });
        
        
        tf.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            //kirim data ke construktor transfer
            transfer a = new transfer(id, user, Nama);
            a.komponen();
            dispose();
            
        }
    });
        
        
        tambah.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            //kirim data ke construktor tambahsaldo
            tambahsaldo b = new tambahsaldo(id, user, Nama);
            b.komponen();
            dispose();
        }
    });
        
        
        ambil.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            //kirim data ke construktor ambilsaldo
            ambilsaldo c = new ambilsaldo(id,user,Nama);
            c.komponen();
            dispose();
        }
    });
        
        
          menu.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            //kirim data ke construktor menulain
            menulain d = new menulain(id, user, Nama);
            d.komponen();
            dispose();
        }
    });
          
          
          exit.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Terima kasih sudah menggunakan layanan kami ","Exit",JOptionPane.CLOSED_OPTION);
            System.exit(0);
            dispose();
        }
    });
        
        
        
    }
    //untuk mengecek saldo
     public void saldo(){
         try{
         
               
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from tbinfo where id_nsb = '" + id+"'");
                while(rs.next()){
                    Saldo = rs.getString(3);
                 
                }
              
                
     }
     catch(Exception ae){
         JOptionPane.showMessageDialog(this, ae);
     }
         
     }
      public static void main (String[] args){
        form a = new form(0, null,null);
        a.komponen();
    }
}

