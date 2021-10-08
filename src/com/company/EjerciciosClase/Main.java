package com.company.EjerciciosClase;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Main {
    public static int contador;
    public static int acumulador;
    public static class Hilo extends Thread {

        public void run() {
            for (int i=0;i<4;i++) {
                contador++;
            }
            System.out.println(contador);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Hilo hilo1 = new Hilo();
        Hilo hilo2 = new Hilo();
        Hilo hilo3 = new Hilo();
        Hilo hilo4 = new Hilo();

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        sleep(1000);
        System.out.println(contador);
    }




}
