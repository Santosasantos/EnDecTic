/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.math.BigInteger;

/**
 *
 * @author santoosa
 */
public class Sharaw {
    RSA_CORE r;
    Sha512 sh;
      String t = "",mm="";
    
      public Sharaw(){
           r=new RSA_CORE();
         sh=new Sha512();
      }
        
      
      public boolean verify(String s){
       int len=s.length();
       byte[] sb=s.getBytes();
       String hash=sh.hashedmessage(sb);
        System.out.println(hash);
       s+=hash;
       String[] keys=r.generate(10).split("_");
       BigInteger pub=new BigInteger(""+keys[0]);
       BigInteger pri=new BigInteger(""+keys[1]);
       BigInteger mod=new BigInteger(""+keys[2]);
       
       String en=r.Encryption(s, pub, mod);
       String dec=r.Decryption(en, pri, mod);
       for(int i=len;i<s.length();i++){
           t+=s.charAt(i);
       }
       
        System.out.println(t);
        if(hash.equals(t))return true;
        else return false;
       
       
       
       
    }

   
    
    
}
