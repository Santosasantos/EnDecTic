/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author santoosa
 */
public class RSA_code {

    static BigInteger p, q, n, phi_n, Gcd, ce, d;
    static String rsa;

   public RSA_code() {
        GUIofEnDecTic g=new GUIofEnDecTic();

//        Scanner sc = new Scanner(System.in);
        String s0 = g.s;//reading the String input
       

        // GUIofEnDecTic g=new GUIofEnDecTic();
        Random r1 = new Random(System.currentTimeMillis());

        

        int e = 2;//Encryption key assuming initially as 2 it will change

        ///Prime p and q assuming 64 bit random value
        p = BigInteger.probablePrime(64, r1);
        q = BigInteger.probablePrime(64, r1);

        n = p.multiply(q);///n=p*q;

        phi_n = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1"))); //phi_n=(p-1)*(q-1)

        //our Encryption key should be corelative prime of phi_n
        while (true) {
            Gcd = phi_n.gcd(new BigInteger("" + e));
            if (Gcd.equals(BigInteger.ONE)) {
                break;
            }
            e++;
        }
        ce = new BigInteger("" + e); //cipher key

        d = ce.modInverse(phi_n);//decipher key=(cipherkey)^-1 mod phi_n

        //String s0="hello,What's up ? what about you?Do you need $dollar";
        //StringBuilder st=new StringBuilder();
        s0 = padding(s0);
        byte[] bytes = s0.getBytes();
         rsa=Encryption(bytes, ce, n);
        Decryption(bytes, ce, d, n);

    }

    public static String Encryption(byte[] bt, BigInteger c, BigInteger nn) {
       
        StringBuilder st = new StringBuilder();

        for (int i=0; i < bt.length; i+=3) {
            int ascii = bt[i];
            ascii = ascii * 256 + bt[i+1];
            ascii = ascii * 256 + bt[i+2];
            
            BigInteger val = new BigInteger("" + ascii);
            BigInteger cipherval = val.modPow(c, nn);
            
            st.append(cipherval.toString());

        }
//        if (st.length() % 15 == 0) {
//            System.out.println(st);
//        } else {
//
//        }

       return st.toString();
    }

    static void Decryption( byte[] bt, BigInteger c, BigInteger d, BigInteger nn) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < bt.length; i++) {
            int ascii = bt[i];
            
            BigInteger val = new BigInteger("" + ascii);
            BigInteger cipherval = val.modPow(c, nn);

            BigInteger plain = cipherval.modPow(d, nn);
            int i_plain = plain.intValue();
            char charac=(char)i_plain;
            char pad=(char)20;
            if(charac==pad){
            break;
        }
            st.append(Character.toString((char) i_plain));

        }

        System.out.println(st);
    }

    static String padding(String s) {
        while (s.length() % 3 != 0) {
            s = s + (char) 20;
        }
        
        return s;
    }

}
