package com.company.EjerciciosClase;

public class SupermercadoCovid {

    private static final int tope = 40;
    private static int aforo = 36;
    private static boolean pasan;

    public static void main(String[] args) {

        Incremento p1 = new Incremento();
        Incremento p2 = new Incremento();
        Incremento p3 = new Incremento();
        Incremento p4 = new Incremento();
        Decremento p5  = new Decremento();
        Decremento p6  = new Decremento();
        Decremento p7  = new Decremento();
        Decremento p8  = new Decremento();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();

    }


    public static class Incremento extends Thread {

        @Override
        public synchronized void run() {
            try {
                Incremento.sleep((int) Math.random() * ((800 - 100 + 1) + 100));

                while (aforo < tope && pasan == true) {
                    System.out.println("Me voy a la cola");
                    wait();
                    System.out.println("Termina el wait ");
                }
                aforo++;
                pasan = true;
                System.out.println(aforo);


            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static class Decremento extends Thread {

        @Override
        public synchronized void run() {
            try {
                Decremento.sleep((int) (Math.random() * ((800 - 100 + 1) + 100)));
                aforo--;
                System.out.println(aforo);
                System.out.println("Salgo pero tengo que avisar ");
                pasan = true;
                notify();
                System.out.println("Sali y ya notifique");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}