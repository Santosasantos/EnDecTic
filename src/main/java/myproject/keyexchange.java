/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author santoosa
 */
public class keyexchange {
    
  
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        int q=11;
        int alpha=findingprimitiveroot(q);
        double a=(double)alpha;
        double xa=8.00,xb=4.00;
        Double alphapowxa=Math.pow(a,xa);
        Double alphapowxb=Math.pow(a, xb);
         int ya=alphapowxa.intValue()%q;
         int yb=alphapowxb.intValue()%q;
        
       
           int ks=senderkey(xa,yb,q); 
           int kr=receiverkey(xb,ya,q);
            System.out.println(ks+" "+kr);
            
         for (int i=0; i<s1.length(); i++) {
             System.out.print((int)s1.charAt(i) + "  ");
         } 
         System.out.println("");
         
            byte[] bt1=s1.getBytes();
            String ciphertext=symetricencryption(bt1,ks);
            
            for (int i=0; i<ciphertext.length(); i++) {
             System.out.print((int)ciphertext.charAt(i) + "  ");
         } 
         System.out.println("");
         
            symetricdecryption(ciphertext,ks);
            
        
    }
    
    static int senderkey(double xa,double yb,int q){
        
        Double ybpowxa =Math.pow(yb,xa);
        
        return ybpowxa.intValue()%q;
    }
    
    static int receiverkey(double xb,double ya,int q){
        
        Double yapowxb=Math.pow(ya, xb);
        
        return yapowxb.intValue()%q;
    }
    
  static int findingprimitiveroot(int q){
      
     Set<Integer> s = new HashSet<Integer>();
     List<Integer>t=new LinkedList<Integer>();
      for(int i=1;i<=q-1;i++){
          for(int j=1;j<=q-1;j++){
              Double p=Math.pow((double)i, (double)j);
             s.add(p.intValue()%q);
          }
         
          if(s.size()==q-1){
             t.add(i);
             
          }

          s.clear();
          
          
      }
      if(t.isEmpty()){
          return 0;
      }
      else{
          return t.get(0);
          
      }
}
  
static String symetricencryption(byte[] bt,int key){
    StringBuilder st1 = new StringBuilder();
    
    for(int i=0; i<bt.length; i++){
        int ascii=bt[i];
        System.out.print(ascii + "  ");
        int cipher=(ascii*key)%251;
        char c=(char)cipher;
        st1.append(Character.toString(c));
    }
    System.out.println("");
    return st1.toString();
}  

static void symetricdecryption(String s,int key){
    StringBuilder st2=new StringBuilder();
    int dec=0;
    for(int i=1;i<250;i++){
        dec=(i*key)%251;
        if(dec==1){
            dec=i;
            break;
        }
    }
    
    System.out.println("Key " + dec);

    for(int i=0;i<s.length();i++){
        int ascii=s.charAt(i);
        int decipher=(ascii*dec)%251;
        System.out.print(decipher + "  ");
        char d=(char)decipher;
        st2.append(Character.toString(d));
    }
    System.out.println("");
    System.out.println(st2);
}
  
  
}
