package com.company.ejercicios.hilos.ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static class Hilo extends Thread {
        public Hilo(String name) {
            super(name);
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " " + getName());
                try {
                    int numero = (int) (Math.random()*((800-100+1)+100));
                    Thread.sleep(numero);
                } catch (InterruptedException ex) {
                    Logger.getLogger(com.company.ejercicios.hilos.ejercicio1.Main.Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            System.out.println("Termina "+getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Hilo hilo1 =new Hilo("Hilo1");
        Hilo hilo2 = new Hilo("Hilo2");
        Hilo hilo3 = new Hilo("Hilo3");
        Hilo hilo4 = new Hilo("Hilo4");

        hilo1.start();
        hilo1.join();
        hilo2.start();
        //hilo2.join();
        hilo3.start();
        hilo3.join();
        hilo4.start();
        hilo4.join();
    }
}
