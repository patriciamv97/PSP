package com.company.ejercicios.hilos.ejercicio6;

public class Main {

    static int caja = 100000;

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

        public void run() {
            caja += Integer.parseInt(getName());
            System.out.println("Ingreso realizado con éxito, total en caja : " + caja);
        }
    }

    public static class Extraccion extends Thread {
        public Extraccion(String name) {
            super(name);
        }

        public void run() {
            caja -= Integer.parseInt(getName());
            System.out.println("Extracción  realizada con éxito, total en caja : " + caja);
        }
    }
}
