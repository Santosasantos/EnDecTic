/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myproject;

import java.awt.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import java.io.IOException;
import java.math.BigInteger;
import java.net.*;
import javax.swing.JLabel;
//import myproject.RSA_code;

/**
 * @author santoosa
 */
public class GUIofEnDecTic extends javax.swing.JFrame {

    /**
     * Creates new form GUIofEnDecTic
     */
    CardLayout cr;
    ServerSocket ser;
    Socket soc1, soc2;
    DataInputStream din;
    DataOutputStream dout;


    public BigInteger pubkey;
    public BigInteger privateKey;
    public BigInteger modulas;

    RSA_CORE core = new RSA_CORE();
    Sharaw s;

    public GUIofEnDecTic() {
        initComponents();

        Component[] cm = this.getContentPane().getComponents();
        for (Component cmo : cm) {
            if (cmo instanceof JButton) {
                ((JButton) cmo).setUI(new BasicButtonUI());
                ((JButton) cmo).setFocusPainted(false);
            }
        }
        cr = (CardLayout) Crdpane.getLayout();

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Crdpane = new javax.swing.JPanel();
        Connectwindow = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Senderbutton = new javax.swing.JButton();
        Receiverbutton = new javax.swing.JButton();
        Encryptcard = new javax.swing.JPanel();
        Encryptplainscroll = new javax.swing.JScrollPane();
        EncryptPlainText = new javax.swing.JTextArea();
        Encryptplainbutton = new javax.swing.JLabel();
        EncryptCipherbutton = new javax.swing.JLabel();
        Ciphertextscroll = new javax.swing.JScrollPane();
        Encryptciphertext = new javax.swing.JTextArea();
        Sendencrypt = new javax.swing.JButton();
        waitcon = new javax.swing.JLabel();
        Encryptorbutton = new javax.swing.JButton();
        Decryptcard = new javax.swing.JPanel();
        DecPlain = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        DecCipherText = new javax.swing.JTextArea();
        DecCipher = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        DecPlainText = new javax.swing.JTextArea();
        Decipherbutton = new javax.swing.JButton();
        Verifybutton = new javax.swing.JButton();
        waitcon1 = new javax.swing.JLabel();
        verifydialoge = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EnDecTic");

        Crdpane.setLayout(new java.awt.CardLayout());

        Connectwindow.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Who are you?");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 102), 10, true));

        Senderbutton.setText("Sender");
        Senderbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenderbuttonActionPerformed(evt);
            }
        });

        Receiverbutton.setText("Receiver");
        Receiverbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiverbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConnectwindowLayout = new javax.swing.GroupLayout(Connectwindow);
        Connectwindow.setLayout(ConnectwindowLayout);
        ConnectwindowLayout.setHorizontalGroup(
            ConnectwindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectwindowLayout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(Senderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(Receiverbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367))
            .addGroup(ConnectwindowLayout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConnectwindowLayout.setVerticalGroup(
            ConnectwindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectwindowLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(ConnectwindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Senderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Receiverbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(324, Short.MAX_VALUE))
        );

        Crdpane.add(Connectwindow, "Connectwindow");

        Encryptplainscroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Encryptplainscroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        EncryptPlainText.setBackground(new java.awt.Color(204, 255, 204));
        EncryptPlainText.setColumns(20);
        EncryptPlainText.setFont(new java.awt.Font("Waree", 2, 15)); // NOI18N
        EncryptPlainText.setLineWrap(true);
        EncryptPlainText.setRows(5);
        EncryptPlainText.setWrapStyleWord(true);
        Encryptplainscroll.setViewportView(EncryptPlainText);

        Encryptplainbutton.setFont(new java.awt.Font("Waree", 1, 15)); // NOI18N
        Encryptplainbutton.setText("Plain Text");
        Encryptplainbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 51)));

        EncryptCipherbutton.setFont(new java.awt.Font("Waree", 1, 15)); // NOI18N
        EncryptCipherbutton.setText("Cipher Text");
        EncryptCipherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 51)));

        Encryptciphertext.setBackground(new java.awt.Color(255, 153, 153));
        Encryptciphertext.setColumns(20);
        Encryptciphertext.setFont(new java.awt.Font("Waree", 2, 15)); // NOI18N
        Encryptciphertext.setLineWrap(true);
        Encryptciphertext.setRows(5);
        Ciphertextscroll.setViewportView(Encryptciphertext);

        Sendencrypt.setText("Send");
        Sendencrypt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        Sendencrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendencryptActionPerformed(evt);
            }
        });

        waitcon.setBackground(new java.awt.Color(255, 255, 255));
        waitcon.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        waitcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        waitcon.setText("Waiting for Connection");
        waitcon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 10, true));

        Encryptorbutton.setText("Encrypt");
        Encryptorbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Encryptorbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptorbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EncryptcardLayout = new javax.swing.GroupLayout(Encryptcard);
        Encryptcard.setLayout(EncryptcardLayout);
        EncryptcardLayout.setHorizontalGroup(
            EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncryptcardLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Encryptplainscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Encryptplainbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncryptcardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Sendencrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(EncryptcardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ciphertextscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(EncryptcardLayout.createSequentialGroup()
                        .addGroup(EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EncryptcardLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(EncryptCipherbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EncryptcardLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Encryptorbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(EncryptcardLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(waitcon, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EncryptcardLayout.setVerticalGroup(
            EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncryptcardLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(waitcon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EncryptCipherbutton)
                    .addComponent(Encryptplainbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EncryptcardLayout.createSequentialGroup()
                        .addComponent(Ciphertextscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addGroup(EncryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EncryptcardLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Sendencrypt))
                            .addGroup(EncryptcardLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(Encryptorbutton))))
                    .addComponent(Encryptplainscroll))
                .addGap(23, 23, 23))
        );

        Crdpane.add(Encryptcard, "Encryptcard");

        DecPlain.setFont(new java.awt.Font("Waree", 1, 15)); // NOI18N
        DecPlain.setText("Plain Text");
        DecPlain.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 51)));

        DecCipherText.setColumns(20);
        DecCipherText.setLineWrap(true);
        DecCipherText.setRows(5);
        jScrollPane8.setViewportView(DecCipherText);

        DecCipher.setFont(new java.awt.Font("Waree", 1, 15)); // NOI18N
        DecCipher.setText("Cipher Text");
        DecCipher.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 51)));

        DecPlainText.setColumns(20);
        DecPlainText.setLineWrap(true);
        DecPlainText.setRows(5);
        jScrollPane9.setViewportView(DecPlainText);

        Decipherbutton.setText("Decipher");
        Decipherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Decipherbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecipherbuttonActionPerformed(evt);
            }
        });

        Verifybutton.setText("verify the message");
        Verifybutton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Verifybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifybuttonActionPerformed(evt);
            }
        });

        waitcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        waitcon1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        verifydialoge.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout DecryptcardLayout = new javax.swing.GroupLayout(Decryptcard);
        Decryptcard.setLayout(DecryptcardLayout);
        DecryptcardLayout.setHorizontalGroup(
            DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptcardLayout.createSequentialGroup()
                .addGroup(DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DecryptcardLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(DecryptcardLayout.createSequentialGroup()
                                .addComponent(verifydialoge, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Verifybutton))
                            .addGroup(DecryptcardLayout.createSequentialGroup()
                                .addComponent(DecCipher, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149)
                        .addGroup(DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DecPlain, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Decipherbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DecryptcardLayout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(waitcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        DecryptcardLayout.setVerticalGroup(
            DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptcardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(waitcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DecCipher)
                    .addComponent(DecPlain))
                .addGap(18, 18, 18)
                .addGroup(DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(DecryptcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Decipherbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Verifybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifydialoge, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(230, Short.MAX_VALUE))
        );

        waitcon1.getAccessibleContext().setAccessibleName("waitcon1");
        verifydialoge.getAccessibleContext().setAccessibleName("verifydialoge");

        Crdpane.add(Decryptcard, "Decryptcard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Crdpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Crdpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerifybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifybuttonActionPerformed
        // TODO add your handling code here:
        s=new Sharaw();
        boolean b=s.verify(EncryptPlainText.getText());
        //        System.out.println(b);
        if(b)verifydialoge.setText("verified");
        else verifydialoge.setText("Not verified!! do not open");
    }//GEN-LAST:event_VerifybuttonActionPerformed

    private void DecipherbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecipherbuttonActionPerformed
        // TODO add your handling code here:
        //        DecPlainText.setText(decipher);
        try {
            //            System.out.println("Text:" + DecCipherText.getText());
            DecPlainText.setText(core.Decryption(DecCipherText.getText(), privateKey, modulas));

            //            System.out.println(decmessage);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_DecipherbuttonActionPerformed

    private void EncryptorbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptorbuttonActionPerformed
        // TODO add your handling code here:
        Encryptciphertext.setText(core.Encryption(EncryptPlainText.getText(), pubkey, modulas));
    }//GEN-LAST:event_EncryptorbuttonActionPerformed

    private void SendencryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendencryptActionPerformed
        try {
            String sents = Encryptciphertext.getText();
            dout.writeUTF(sents);
            //dout.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_SendencryptActionPerformed

    private void ReceiverbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiverbuttonActionPerformed
        // TODO add your handling code here:
        //           cr.show(Crdpane, "Decryptcard");
        try {
            InetAddress add = InetAddress.getLocalHost();
            soc2 = new Socket(add, 1234);
            din = new DataInputStream(soc2.getInputStream());
            System.out.println("Reciver Connected");
            String key[] = din.readUTF().split("_");
            privateKey = new BigInteger(key[0]);
            modulas = new BigInteger(key[1]);
            System.out.println("Reciver Get Private key " + privateKey);
            if (soc2.isConnected()) {
                cr.show(Crdpane, "Decryptcard");
                waitcon1.setText("Connected to server");
                //                System.out.println("Server is connected");

            }
            System.out.println("Reciver Get Private key " + privateKey);

            ThreadRcv rcv = new ThreadRcv(din, DecCipherText);
            rcv.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ReceiverbuttonActionPerformed

    private void SenderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenderbuttonActionPerformed

        try {

            ser = new ServerSocket(1234);
            soc1 = ser.accept();

            if (soc1.isConnected()) {
                cr.show(Crdpane, "Encryptcard");
                waitcon.setText("Connected with a client");

            }

            String key[] = core.generate(10).split("_");
            pubkey = new BigInteger(key[0]);
            privateKey = new BigInteger(key[1]);
            modulas = new BigInteger(key[2]);

            System.out.println("Sender Public Key:" + pubkey);
            System.out.println("Sender Private Key:" + privateKey.toString());
            System.out.println("Sender Modulas Key:" + modulas.toString());
            dout = new DataOutputStream(soc1.getOutputStream());
            dout.writeUTF(privateKey.toString() + "_" + modulas.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SenderbuttonActionPerformed



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIofEnDecTic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIofEnDecTic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIofEnDecTic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIofEnDecTic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUIofEnDecTic().setVisible(true);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Ciphertextscroll;
    private javax.swing.JPanel Connectwindow;
    private javax.swing.JPanel Crdpane;
    private javax.swing.JLabel DecCipher;
    private javax.swing.JTextArea DecCipherText;
    private javax.swing.JLabel DecPlain;
    private javax.swing.JTextArea DecPlainText;
    private javax.swing.JButton Decipherbutton;
    private javax.swing.JPanel Decryptcard;
    private javax.swing.JLabel EncryptCipherbutton;
    private javax.swing.JTextArea EncryptPlainText;
    private javax.swing.JPanel Encryptcard;
    private javax.swing.JTextArea Encryptciphertext;
    private javax.swing.JButton Encryptorbutton;
    private javax.swing.JLabel Encryptplainbutton;
    private javax.swing.JScrollPane Encryptplainscroll;
    private javax.swing.JButton Receiverbutton;
    private javax.swing.JButton Sendencrypt;
    private javax.swing.JButton Senderbutton;
    private javax.swing.JButton Verifybutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel verifydialoge;
    private javax.swing.JLabel waitcon;
    private javax.swing.JLabel waitcon1;
    // End of variables declaration//GEN-END:variables
}
