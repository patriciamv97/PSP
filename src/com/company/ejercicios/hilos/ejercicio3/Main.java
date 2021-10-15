package com.company.ejercicios.hilos.ejercicio3;

public class Main {

    public static void main(String[] args) {
        new Hilo1("Pepe").start();
    }

    public static class Hilo1 extends Thread{
        public Hilo1(String name) {
            super(name);
        }

        public void run() {

        }
    }
}
