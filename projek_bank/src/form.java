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
    String Saldo;
        //desain
        JLabel judul = new JLabel("Selamat Datang");
        JLabel judul1 = new JLabel("di Bank RHR");
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
        public form(int id){
            this.id = id;
        }

    form() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    public void komponen(){
        setTitle("Bank RHR");
        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    
        
        
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
        
          
        nm.setEnabled(false);
        nm.setBounds(270, 135, 150, 25);
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
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Saldo anda saat ini sebesar : Rp " + Saldo, "Informasi Saldo", JOptionPane.INFORMATION_MESSAGE);
        }
    });
        
        
        tf.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            transfer a = new transfer();
            a.komponen();
            
        }
    });
        
        
        tambah.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            tambahsaldo b = new tambahsaldo();
            b.komponen();
        }
    });
        
        
        ambil.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            ambilsaldo c = new ambilsaldo();
            c.komponen();
            
        }
    });
        
        
          menu.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            menulain d = new menulain();
            d.komponen();
            
        }
    });
          
          
          exit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Terima kasih sudah menggunakan layanan kami ","Exit",JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }
    });
        
        
        
    }
     public void saldo(){
         try{
         
               
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from tbnasabah where id_nsb = '" + id+"'");
                Saldo = rs.getString(1);
     }catch(Exception ae){
         
     }
     }
      public static void main (String[] args){
        form a = new form(0);
        a.komponen();
    }
}

