import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class transfer extends JFrame{ 
    JLabel judul = new JLabel("Transfer");
    JLabel nomor = new JLabel("No. Rekening Tujuan");
    JLabel jumlah = new JLabel("Jumlah Kiriman (Rp)");
    
    JTextField nmr = new JTextField();
    JTextField jml = new JTextField();
    
    JButton tf = new JButton("Transfer");
    
    
     public void komponen(){
        setTitle("Bank RHR");
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
        tf.setBounds(150, 150, 100, 25);
        add(tf);
        
        
        tf.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){           
            if(nmr.getText().equals("")||jml.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong");
                }
            
           else {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Anda akan mentransfer ke rekening " + nmr.getText() + " sebesar Rp " + jml.getText());
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
         transfer b = new transfer();
         b.komponen();
     }
}