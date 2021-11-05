package com.company.ejercicios.hilos.ejercicio7;

public class Main {

    private static int capacidadBuzon = 1;
    private static boolean operar = true;


    public static void main(String[] args) throws InterruptedException {

        LeerCorreo ler = new LeerCorreo("Correo que se va a leer1");
        LeerCorreo ler2 = new LeerCorreo("Correo que se va a leer2");
        EnviarCorreo enviar = new EnviarCorreo("Correo que se va a enviar1");
        EnviarCorreo enviar2 = new EnviarCorreo("Correo que se va a enviar2");

        ler.start();
        ler.join();
        enviar.start();
        enviar.join();
        enviar2.start();
        ler2.start();

    }

    public static class LeerCorreo extends Thread {
        public LeerCorreo(String name) {
            super(name);
        }

        @Override
        public synchronized void run() {
           try {
               while (!operar || capacidadBuzon<1) {
                   wait();
               }

               operar = false;
               capacidadBuzon--;
               System.out.println(capacidadBuzon);
               System.out.println("Lendo correo : " + getName());
               operar = true;
               notify();

           }catch (InterruptedException e){
               System.out.println(e.getMessage());
           }

        }
    }
        public static class EnviarCorreo extends Thread {
            public EnviarCorreo(String name) {
                super(name);
            }

            @Override
            public synchronized void run() {
                try {
                    while (!operar || capacidadBuzon>=1) {
                        System.out.println("entro en la cola");
                        wait();
                        System.out.println("salgo de la cola");
                    }
                    operar = false;
                    capacidadBuzon++;
                    System.out.println(capacidadBuzon);
                    System.out.println("Enviando  correo : " + getName());
                    operar = true;
                    notify();

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());

                }
            }
        }
    }
