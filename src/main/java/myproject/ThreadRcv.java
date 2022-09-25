/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author santoosa
 */
public class ThreadRcv extends Thread {

    DataInputStream din;

    public ThreadRcv(DataInputStream din, JTextArea DecCipherText) {
        this.din = din;
        this.DecCipherText = DecCipherText;
    }
    JTextArea DecCipherText;

    public void run() {
        int i = 0;
        while (i++ < 10) {
            StringBuilder msg;
            try {
                msg = new StringBuilder(din.readUTF());
                DecCipherText.setText(msg.toString());
            } catch (IOException ex) {
                Logger.getLogger(ThreadRcv.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }
}
