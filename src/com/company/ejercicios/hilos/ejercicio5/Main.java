package com.company.ejercicios.hilos.ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Hilo hilo1 = new Hilo("fio1");

        Hilo hilo2 = new Hilo("fio2");


          // Con join
           hilo2.start();
           hilo2.join();
           hilo1.start();


        /*
        Con prioridades (No funcionan)
        hilo1.setPriority(Thread.MIN_PRIORITY);
        hilo2.setPriority(Thread.MAX_PRIORITY);
        hilo1.start();
        hilo2.start();
         */

    }

    public static class Hilo extends Thread {
        public Hilo(String name) {
            super(name);
        }

        public void run() {
            System.out.println("Ola son o fío " + getName());
        }
    }
}
