/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author santoosa
 */
public class RSA_CORE {

    private final static SecureRandom random = new SecureRandom();
    private final static BigInteger one = new BigInteger("1");

    private BigInteger modulus;

    private BigInteger publicKey;
    private BigInteger privateKey;
    

    public String generate(int bitLength) {
        BigInteger p = BigInteger.probablePrime(bitLength / 2, new Random());
        BigInteger q = BigInteger.probablePrime(bitLength / 2, new Random());
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        BigInteger Gcd;

        this.modulus = p.multiply(q);
        int e=2;
         phi = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
         while (true) {
            Gcd = phi.gcd(new BigInteger("" + e));
            if (Gcd.equals(BigInteger.ONE)) {
                break;
            }
            e++;
        }
        this.publicKey = new BigInteger(""+e);
        this.privateKey = publicKey.modInverse(phi);
        return publicKey.toString() + "_" + privateKey.toString() + "_" + modulus.toString();

    }


   

    public String Encryption(String bt, BigInteger c, BigInteger nn) {

        StringBuilder st = new StringBuilder();
        String core_msg = "";
        bt=padding(bt);

        for (int i = 0; i < bt.length(); i++) {
            char cipher = bt.charAt(i); // c='a'
            int ascii = (int) cipher;
            BigInteger val = new BigInteger(""+ascii);
            BigInteger cipherval = val.modPow(c, nn);
            core_msg+=""+(char)cipherval.intValue();
          
        }
//        System.out.println("Sender Assci Value:" + core_msg);
//        BigInteger val = new BigInteger(core_msg);
//        BigInteger cipherval = val.modPow(c, nn);
        st.append(core_msg);

        return st.toString();
    }

    public String Decryption(String bt, BigInteger d, BigInteger nn) {
        StringBuilder st = new StringBuilder();
        String output="";
        for (int i = 0; i < bt.length(); i++) {
            int ascii =(int) bt.charAt(i);
            BigInteger val = new BigInteger("" + ascii);
            BigInteger plain = val.modPow(d, nn);
            int i_plain = plain.intValue();
            char vOut = (char) i_plain;
           
            char pad = (char) 20;
            if (vOut == pad) {
                break;
            }
             output+=""+vOut;
//
//            st.append(vOut);
        }
        return output;
    }

//    }
      static String padding(String s) {
        while (s.length() % 3 != 0) {
            s = s + (char) 20;
        }

        return s;
    }
}
