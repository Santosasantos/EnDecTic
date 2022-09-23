/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 * @author santoosa
 */
public class bytearrayinputstream {
    public static void main(String[] args)throws IOException {
            String s="Hello";
    byte[] b=s.getBytes();
    for(byte bt:b){
        System.out.println(bt);
    }
    ByteArrayInputStream in=new ByteArrayInputStream(b);
      int ch;
      ch=in.read();
      while(ch!=-1){
          System.out.println(ch);
          ch=in.read();
      }
              
    }

    
}
