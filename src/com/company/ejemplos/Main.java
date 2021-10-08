package com.company.ejemplos;

public class Main {
    public static class ThreadEjemplo extends Thread{
        public ThreadEjemplo(String name) {
            super(name);
        }
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(i+" "+getName());
                System.out.println("Termina thread "+ getName());
            }
        }
    }

    public static void main(String[] args) {
          new ThreadEjemplo("Pepe").start();
        new ThreadEjemplo("Manuel").start();
        System.out.println("Termina Thread main");

    }
}
