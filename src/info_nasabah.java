import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class info_nasabah extends JFrame{
    int id;
    String user, Nama;
    
     JLabel judul = new JLabel("Info Nasabah");
     private JTable table= new JTable();
     private DefaultTableModel model = new DefaultTableModel();
     JScrollPane scroll=new JScrollPane(table);
    
     
     JButton kembali = new JButton("Kembali");
     
     
    
     public void komponen(){
        setTitle("Bank RHR");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);
        
        
        judul.setFont(new Font("Segoe Script",Font.BOLD, 18));
        judul.setForeground(Color.blue);
        judul.setBounds(130, 10, 200, 50);
           
        kembali.setBounds(220, 320, 80, 25);
        
        
        add(judul);
        
        add(kembali);
        
        
        getContentPane().setLayout(null);
        getContentPane().add(scroll,BorderLayout.CENTER);    
        scroll.setBounds(20, 65, 350, 250);
        
        table.setModel(model);
        model.addColumn("Id");
        model.addColumn("Nama Nasabah");
        model.addColumn("Saldo");
        //melakukan penghapusan defaul model dari jtable
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            //membuat koneksi kedatabase
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from tbinfo");
            
            
           while(rs.next()){
                Object[] obj = new Object[3];
                obj[0]=rs.getString(1);
                obj[1]=rs.getString(2);
                obj[2]=rs.getString(3);
                model.addRow(obj);   
            }
           rs.close();
           st.close();
           con.close();
        }catch(Exception e){
            
        }

              
        
        
       
        
        
        kembali.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event){
            dispose();
        //kirim data kmbali construktor form
        form x = new form(id,user,Nama);
        x.setSize(450, 400);
        x.setLayout(null);
        x.setLocationRelativeTo(null);
        x.komponen();
        
        x.setVisible(true);
    
     }
    });
     }
     //construktor info nasabah
     public info_nasabah(int id, String user, String nama){
         this.id = id;
         this.user = user;
         this.Nama = nama;
     }
       
     
     public static void main(String[] args){
         info_nasabah t = new info_nasabah(0,null,null);
         t.komponen();
         
     }
}