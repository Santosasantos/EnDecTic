/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santoosa
 */
public class reciever {

      
          

    public static void main(String[] args)throws IOException {
       
      InetAddress address=InetAddress.getLocalHost();
      Socket rs=new Socket(address,7799);
     
      InputStream in=rs.getInputStream();
      DataInputStream din=new DataInputStream(in);
      String msg=din.readUTF();
//      int msg1=din.readInt();
        System.out.println(msg);
    }
        
       

  
    
    
}
