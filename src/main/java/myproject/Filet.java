/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author santoosa
 */
public class Filet {
    public static void main(String[] args) {
        try{
       
        
        FileWriter r=new FileWriter("/home/santoosa/Documents/hello.txt");
        String s="hello";
        r.write(s);
        r.close();
        
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
 
}
