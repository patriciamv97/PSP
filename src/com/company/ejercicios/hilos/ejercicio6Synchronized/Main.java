package com.company.ejercicios.hilos.ejercicio6Synchronized;

public class Main {

    static int caja = 100000;
    static boolean semaforo = true;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Ingreso("1000").start();
            new Extraccion("1000").start();

        }

       /*

          for (int i = 0; i < 5; i++) {
            new Extraccion("1000").start();
        }

        */


    }

    public static class Ingreso extends Thread {
        public Ingreso(String name) {
            super(name);
        }

        public synchronized void run() {

            if (!semaforo) {
                try {
                    this.wait();
                } catch (IllegalMonitorStateException e) {
                    System.out.println("error wait monitor exception1");
                } catch (InterruptedException e) {
                    System.out.println("error wait interrupted exception1");
                }

            }
            semaforo = false;
            caja += Integer.parseInt(getName());
            System.out.println("Ingreso realizado con éxito, total en caja : " + caja);
            semaforo = true;
            try {
                this.notify();
            }catch (IllegalMonitorStateException e){
                System.out.println("error notify1");
            }
        }
    }


    public static class Extraccion extends Thread {
        public Extraccion(String name) {
            super(name);
        }

        public synchronized void run() {

            if (!semaforo) {
                try {
                   this.wait();
                } catch (IllegalMonitorStateException e) {
                    System.out.println("error wait monitor exception2");
                } catch (InterruptedException e) {
                    System.out.println("error wait interrupted exception2");

                }
            }
            semaforo = false;
            caja -= Integer.parseInt(getName());
            System.out.println("Extracción  realizada con éxito, total en caja : " + caja);
            semaforo =true;
            try {
                this.notify();
            }catch (IllegalMonitorStateException e){
                System.out.println("error notify2");
            }
        }
    }
}

