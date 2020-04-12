/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
class koneksidb {
    public void panggildriver(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Sukses Memanggil Driver");
        
    }catch(ClassNotFoundException e){
        System.out.println("Gagal Memanggil Driver");
    }finally{
            System.out.println("Proses Pemanggilan Driver Selesai");
        }
    }
    public Connection cn = null;
    public Connection koneksi(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
            System.out.println("Berhasil Terkoneksi");
        }catch(SQLException e){
            System.out.println("Gagal Terkoneksi");
        }finally{
             System.out.println("Proses Pemanggilan Koneksi Selesai");
        }
       return cn;
    }
    
    
   public static void main(String[] args){
       koneksidb bank = new koneksidb();
       bank.panggildriver();
        
    }
}
