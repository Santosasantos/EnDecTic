/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author santoosa
 */
public class sender {
   
    
    public static void main(String[] agrs)throws Exception{
        
//     RSA_code r=new RSA_code();      
    ServerSocket ss= new ServerSocket(7799);
     Socket s=ss.accept();
     BufferedReader serverinput=new BufferedReader(new InputStreamReader(System.in));
     OutputStream out=s.getOutputStream();
     DataOutputStream dout=new DataOutputStream(out);
    
    
     
    String sc=serverinput.readLine();
//    int e,n; 
//    Boolean f=false;   
//    
//    Scanner input = new Scanner(System.in);
//    
//    e = input.nextInt();
//    System.out.println(e);
//    n=serverinput.read();
    dout.writeUTF(sc);
//    dout.write(n);
    dout.flush();
    s.close();
    ss.close();
    
    
}
   
    
    
}



