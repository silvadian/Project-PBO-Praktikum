import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menulain extends JFrame{
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
    
    
    public void komponen(){
        setTitle("Bank RHR");
        setSize(350, 400);
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
        
        
        info.setForeground(Color.red);
        info.setBounds(200, 105, 110, 25);
        
        beli.setForeground(Color.red);
        beli.setBounds(200, 135, 110, 25);
        
        ButtonGroup group = new ButtonGroup();
        group.add(axis);
        group.add(indosat);
        group.add(three);
        group.add(tsel);
        group.add(xl);
        
        
        
        add(judul);
        add(pulsa);
        add(axis);
        add(indosat);
        add(three);
        add(tsel);
        add(xl);
        add(listrik);
        add(beli);
        add(info);
        
        
        pulsa.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){ 
        if(pulsa.isSelected()) {
            axis.setEnabled(true);
            indosat.setEnabled(true);
            three.setEnabled(true);
            tsel.setEnabled(true);
            xl.setEnabled(true);
            
            JLabel nomor = new JLabel("Nomor");
            JLabel nominal = new JLabel("Nominal");
            JTextField nmr = new JTextField();
            JTextField nmnl = new JTextField();
            
            nomor.setBounds(20, 240, 100, 25);
            nominal.setBounds(20, 270, 100, 25);
            nmr.setBounds(130, 240, 180, 25);
            nmnl.setBounds(130, 270, 180, 25);
            add(nomor);
            add(nominal);
            add(nmr);
            add(nmnl);
            
            if(axis.isSelected()){
                nmr.setText("+6283");
            }
            else if(indosat.isSelected()){
                nmr.setText("+6285");                
            }
            else if(three.isSelected()){
                nmr.setText("+6289");
            }
            else if(tsel.isSelected()){
                nmr.setText("+6281"); 
            }
            else if(xl.isSelected()){
                nmr.setText("+6287"); 
            }
        }
        
        
        else if(listrik.isSelected()){
            JLabel meter = new JLabel("Nomor Meter");
            JLabel nml = new JLabel("Nominal");
            JLabel ket = new JLabel("*Masukan nomor 11 digit");
            JTextField mtr = new JTextField();
            JTextField nomi = new JTextField();
            
            meter.setBounds(20, 240, 100, 25);
            nml.setBounds(20, 270, 100, 25);
            mtr.setBounds(130, 240, 100, 25);
            ket.setBounds(130, 245, 100, 20);
            nomi.setBounds(130, 275, 100, 25);
            add(meter);
            add(nml);
            add(mtr);
            add(ket);
            add(nomi);
        }
        
        else if(pulsa.isSelected() && listrik.isSelected()){
            axis.setEnabled(true);
            indosat.setEnabled(true);
            three.setEnabled(true);
            tsel.setEnabled(true);
            xl.setEnabled(true);
            
            JLabel nomor = new JLabel("Nomor");
            JLabel nominal = new JLabel("Nominal");
            JTextField nmr = new JTextField();
            JTextField nmnl = new JTextField();
            JLabel meter = new JLabel("Nomor Meter");
            JLabel nml = new JLabel("Nominal");
            JLabel ket = new JLabel("*Masukan nomor 11 digit");
            JTextField mtr = new JTextField();
            JTextField nomi = new JTextField();
            
            nomor.setBounds(20, 240, 100, 25);
            nominal.setBounds(20, 270, 100, 25);
            nmr.setBounds(130, 240, 100, 25);
            nmnl.setBounds(130, 270, 100, 25);
            meter.setBounds(20, 300, 100, 25);
            nml.setBounds(20, 300, 100, 25);
            mtr.setBounds(130, 330, 100, 25);
            ket.setBounds(130, 335, 100, 20);
            nomi.setBounds(130, 375, 100, 25);
            add(nomor);
            add(nominal);
            add(nmr);
            add(nmnl);
            add(meter);
            add(nml);
            add(mtr);
            add(ket);
            add(nomi);      
        }}
        
        });
        
        
        info.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e){
            info_nasabah k = new info_nasabah();
            k.setSize(450, 400);
            k.setLayout(null);
            k.setLocationRelativeTo(null);
            k.komponen();
            k.dispose();
            k.setVisible(true);
            
        }
    });
   
    }
    
    public static void main (String[] args){
         menulain e = new menulain();
         e.komponen();
     }

    
}
