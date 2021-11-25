package com.company.ejercicios.hilos.ejercicio9;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Parking {

    private static int [] plazas = new int[6];
    private  static int plazasOcupadas=0;
    private static boolean ocupado = true;
    private static  int random;

    public static void main(String[] args) {

        Aparcar coche1 = new Aparcar();
        Aparcar coche2 = new Aparcar();
        coche1.start();
        coche2.start();
    }


    public static class Aparcar extends Thread {


        @Override
        public synchronized void run() {
            try {
                while (ocupado || plazasOcupadas>=5) {
                    System.out.println("Entro en la cola ");
                    wait();
                }
                ocupado= true;
                System.out.println("El coche ha entrado");

                plazasOcupadas++;
                random = (int) Math.random()*5;
                plazas[random] = 1;
                ocupado=false;
                System.out.println("Varaible ocupado = false");


            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static class Salir extends Thread {


        @Override
        public synchronized void run() {
            while (ocupado || plazasOcupadas<=0){
                try {
                    System.out.println("Entro en la cola");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ocupado=true;
            System.out.println("El coche ha salido");

            plazasOcupadas--;
            random = (int) Math.random()*5;
            plazas[random] = 0;
            ocupado=false;
            System.out.println("Varaible ocupado = false");

            notify();

        }
    }
}
