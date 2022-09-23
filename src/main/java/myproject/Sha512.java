/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author santoosa
 */
public class Sha512 {
    
      // The constant item used in the algorithm
    static long[] IV = new long[]{
        0x6A09E667F3BCC908L,
        0xBB67AE8584CAA73BL,
        0x3C6EF372FE94F82BL,
        0xA54FF53A5F1D36F1L,
        0x510E527FADE682D1L,
        0x9B05688C2B3E6C1FL,
        0x1F83D9ABFB41BD6BL,
        0x5BE0CD19137E2179L
    };
	
	 
    static long[] K = new long[]{
        0x428A2F98D728AE22L, 0x7137449123EF65CDL, 0xB5C0FBCFEC4D3B2FL, 0xE9B5DBA58189DBBCL, 0x3956C25BF348B538L,
        0x59F111F1B605D019L, 0x923F82A4AF194F9BL, 0xAB1C5ED5DA6D8118L, 0xD807AA98A3030242L, 0x12835B0145706FBEL,
        0x243185BE4EE4B28CL, 0x550C7DC3D5FFB4E2L, 0x72BE5D74F27B896FL, 0x80DEB1FE3B1696B1L, 0x9BDC06A725C71235L,
        0xC19BF174CF692694L, 0xE49B69C19EF14AD2L, 0xEFBE4786384F25E3L, 0x0FC19DC68B8CD5B5L, 0x240CA1CC77AC9C65L,
        0x2DE92C6F592B0275L, 0x4A7484AA6EA6E483L, 0x5CB0A9DCBD41FBD4L, 0x76F988DA831153B5L, 0x983E5152EE66DFABL,
        0xA831C66D2DB43210L, 0xB00327C898FB213FL, 0xBF597FC7BEEF0EE4L, 0xC6E00BF33DA88FC2L, 0xD5A79147930AA725L,
        0x06CA6351E003826FL, 0x142929670A0E6E70L, 0x27B70A8546D22FFCL, 0x2E1B21385C26C926L, 0x4D2C6DFC5AC42AEDL,
        0x53380D139D95B3DFL, 0x650A73548BAF63DEL, 0x766A0ABB3C77B2A8L, 0x81C2C92E47EDAEE6L, 0x92722C851482353BL,
        0xA2BFE8A14CF10364L, 0xA81A664BBC423001L, 0xC24B8B70D0F89791L, 0xC76C51A30654BE30L, 0xD192E819D6EF5218L,
        0xD69906245565A910L, 0xF40E35855771202AL, 0x106AA07032BBD1B8L, 0x19A4C116B8D2D0C8L, 0x1E376C085141AB53L,
        0x2748774CDF8EEB99L, 0x34B0BCB5E19B48A8L, 0x391C0CB3C5C95A63L, 0x4ED8AA4AE3418ACBL, 0x5B9CCA4F7763E373L,
        0x682E6FF3D6B2B8A3L, 0x748F82EE5DEFB2FCL, 0x78A5636F43172F60L, 0x84C87814A1F0AB72L, 0x8CC702081A6439ECL,
        0x90BEFFFA23631E28L, 0xA4506CEBDE82BDE9L, 0xBEF9A3F7B2C67915L, 0xC67178F2E372532BL, 0xCA273ECEEA26619CL,
        0xD186B8C721C0C207L, 0xEADA7DD6CDE0EB1EL, 0xF57D4F7FEE6ED178L, 0x06F067AA72176FBAL, 0x0A637DC5A2C898A6L,
        0x113F9804BEF90DAEL, 0x1B710B35131C471BL, 0x28DB77F523047D84L, 0x32CAAB7B40C72493L, 0x3C9EBE0A15C9BEBCL,
        0x431D67C49C100D4CL, 0x4CC5D4BECB3E42B6L, 0x597F299CFC657E2AL, 0x5FCB6FAB3AD6FAECL, 0x6C44198C4A475817L
    };
    
    static long Ch(long x,long y,long z){
        long a=x&y;
        long b=~x & z;
        return a^b;
        
    }
    static long Maj(long a,long b,long c){
        return (a&b)^(a&c)^(b&c);
    }
    
    static long ROTR(long s,long l){
        return (s>>>l)|(s<<Long.SIZE-1);
    }
    static long SHR(long x,long l){
        return x>>>l;
    }
    
    static long Sigma0(long e){
        return ROTR(e,28)^ROTR(e,34)^ROTR(e,39);
    }
    static long Sigma1(long e){
        return ROTR(e,14)^ROTR(e,18)^ROTR(e,41);
    }
    static long sigma0(long x){
        return ROTR(x,1)^ROTR(x,8)^SHR(x,7);
    }
    
    static long sigma1(long x){
       return ROTR(x,19)^ROTR(x,61)^SHR(x,6); 
    }
    
    static byte[] padding(byte[] msg){
        //Padding is always added, even the message is already at desired size.
        //Here the appended message size should be at least 17 bits
        //16 bits for orginal message and 1 bit for '1' bit
        //then pad the msg with '0' s until 128 bit length
        int size = msg.length+17;
        while(size%128!=0){
            size+=1;
        }
        
        byte [] outmsg= new byte[size];
        for(int i=0;i<msg.length;i++){
            outmsg[i]=msg[i];
        }
        
        
        outmsg[msg.length]=(byte)0x80;
        
        byte[] leninbytes=BigInteger.valueOf(msg.length*8).toByteArray();
        
        for(int i=leninbytes.length;i>0;i--){
            outmsg[size-i]=leninbytes[leninbytes.length-i];
        }
        
        return outmsg;
    }
    
    static long bytearraytolong(byte[] b,int j){
        long l=0;
        for(int i=0;i<8;i++){
            l=(l<<8)+(b[i+j]& 0xff);
        }
        return l;
    }
    
    static long[][] bytetoBlock(byte[] b){
        long block[][]=new long [b.length/128][16];
        
        for(int i=0;i<b.length/128;i++){
            
            for(int j=0;j<16;j++){
                block[i][j]=bytearraytolong(b,i*128+j*8);
            }
        }
        return block;
    }
    
    static long[][] expandedmessage(long[][] m){
        long[][] w= new long[m.length][80];
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<16;j++){
                w[i][j]=m[i][j];
            }
            for(int j=16;j<80;j++){
            w[i][j]=sigma1(w[i][j-2]+w[i][j-7]+sigma0(w[i][j-15]))+w[i][j-16];
        }
        }
        
        return w;
    }
    
    static String hashedmessage(byte[]bt){
        bt=padding(bt);
        long[][] messageblock=bytetoBlock(bt);
        long [][] expandedmessageblock=expandedmessage(messageblock);
        
        long[] buffer=IV;
        
        for(int i=0;i<messageblock.length;i++){
            long a=buffer[0];
            long b=buffer[1];
            long c=buffer[2];
            long d=buffer[3];
            long e=buffer[4];
            long f=buffer[5];
            long g=buffer[6];
            long h=buffer[7];
            
            for(int j=0;j<80;j++){
                long t1=h+Sigma1(e)+Ch(e,f,g)+K[j];
                long t2=Sigma0(a)+Maj(a,b,c);
                h=g;
                g=f;
                f=e;
                e=d+t1;
                d=c;
                c=b;
                b=a;
                a=t1+t2;
            }
            buffer[0]=a+buffer[0];
            buffer[1]=b+buffer[1];
            buffer[2]=c+buffer[2];
            buffer[3]=d+buffer[3];
            buffer[4]=e+buffer[4];
            buffer[5]=f+buffer[5];
            buffer[6]=g+buffer[6];
            buffer[7]=h+buffer[7];
        }
        
        String hashedmsg="";
        for(int i=0;i<8;i++){
            hashedmsg+=String.format("%016x", buffer[i]);
        }
        
        return hashedmsg;
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String st=sc.nextLine();
       String verifiedmsg=hashedmessage(st.getBytes());
        System.out.println(verifiedmsg);
    }
}
