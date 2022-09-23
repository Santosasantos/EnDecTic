/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

/**
 *
 * @author santoosa
 */
public class Thr extends Thread {
    GUIofEnDecTic g=new GUIofEnDecTic();
    public void run(){
        g.sete("this is working");
    }
}
