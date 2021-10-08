package com.company.ejercicios.hilos.ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Hilo hilo1 =new Hilo("Hilo1");
        hilo1.setPriority(10);
        Hilo hilo2= new Hilo("Hilo2");
        hilo2.setPriority(1);
        hilo2.start();
        hilo1.start();
        System.out.println("Termina Thread main");
    }


    public static class Hilo extends Thread {
        public Hilo(String name) {
            super(name);
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + getName());
                try {
                    int numero = (int) (Math.random()*((800-100+1)+100));
                    Thread.sleep(numero);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}

