package com.company.ejercicios.hilos.ejercicio4;

public class Main {

    public static void main(String[] args) {

        new Hilo1().start();
        new Hilo2().start();
        new Hilo3().start();

    }

    public static class Hilo1 extends Thread {
        int suma =0;
        public void run() {
            for (int i = 0; i < 1000; i++) {
                if (i%2==0){
                    suma +=i;
                }
            }
            System.out.println("\nTotal = "+suma);
        }
    }
    public static class Hilo2 extends Thread {
        int suma =0;
        public void run() {
            for (int i = 0; i < 1000; i++) {
                if ((i % 2) != 0){
                    suma +=i;

                }
            }
            System.out.println("\nTotal = "+suma);
        }
    }
    public static class Hilo3 extends Thread {
        int suma =0;
        public void run() {
            for (int i = 0; i < 1000; i++) {
                if (i % 10 ==2 | i % 10 ==3) {
                    suma += i;
                }

            }
            System.out.println("\nTotal = "+suma);

        }
    }

}