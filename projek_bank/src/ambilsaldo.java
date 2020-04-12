import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ambilsaldo extends JFrame{
    JLabel judul = new JLabel("Ambil Saldo");
    JLabel saldo = new JLabel("Saldo Saat Ini (Rp)");
    JLabel ambil = new JLabel("Saldo yang akan di ambil (Rp)");
    
    JTextField sld = new JTextField();
    JTextField amb = new JTextField();
    
    JButton as = new JButton("Tarik");
    
    
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
        
        
        sld.setEnabled(false);
        sld.setBounds(200, 80, 150, 25);
        amb.setBounds(200, 110, 150, 25);
        
        add(sld);
        add(amb);
        
        
        as.setForeground(Color.red);
        as.setBounds(150, 150, 90, 25);
        add(as);
        
        
        as.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){           
            if(amb.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Silahkan isi saldo yang ingin anda ambil");
                }
            
           else {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Anda yakin ingin mengambil saldo sebesar (Rp) " + amb.getText());
            if (selectedOption == JOptionPane.YES_OPTION){
                JTextArea l = new JTextArea();
                l.setBounds(100, 210, 200, 80);
                add(l);
                l.setText("   Transaksi berhasil dilakukan\n\n" + "Sisa saldo anda sebesar Rp ");   
            }
            else if(selectedOption == JOptionPane.NO_OPTION || selectedOption == JOptionPane.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "Transaksi dibatalkan");
               }
        }}
    });
     }
     
     public static void main (String[] args){
         ambilsaldo d = new ambilsaldo();
         d.komponen();
     }
}