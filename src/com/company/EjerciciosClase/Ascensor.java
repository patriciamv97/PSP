package com.company.EjerciciosClase;

public class Ascensor {


    private static boolean parado = true;

    public static void main(String[] args) {

        Llamada llamada = new Llamada("1");
        Llamada llamada2 = new Llamada("5");
        Llamada llamada3 = new Llamada("20");
        Llamada llamada4 = new Llamada("18");
        Llamada llamada5 = new Llamada("2");
        Llamada llamada6 = new Llamada("0");
        Llamada llamada7 = new Llamada("15");
        Llamada llamada8 = new Llamada("3");

        llamada.start();
        llamada2.start();
        llamada3.start();
        llamada4.start();
        llamada5.start();
        llamada6.start();
        llamada7.start();
        llamada8.start();



    }


public static class Llamada extends Thread {
    public Llamada(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        try {
            while (!parado) {
                System.out.println("entro en la cola ");
                wait();
                System.out.println("salgo de la cola ");

            }

            parado = false;
            System.out.println(getName());
          //  sleep(3000);
            parado = true;
            notify();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}

}
