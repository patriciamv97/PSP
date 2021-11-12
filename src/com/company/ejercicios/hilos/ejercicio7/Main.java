package com.company.ejercicios.hilos.ejercicio7;

public class Main {

    private static String mensaje= null;
    private static boolean operar = true;


    public static void main(String[] args) throws InterruptedException {

        LeerCorreo ler = new LeerCorreo("Correo que se va a leer1");
        LeerCorreo ler2 = new LeerCorreo("Correo que se va a leer2");
        EnviarCorreo enviar = new EnviarCorreo("Correo que se va a enviar1");
        EnviarCorreo enviar2 = new EnviarCorreo("Correo que se va a enviar2");

       // ler.join();
        enviar.start();
        ler.start();

        enviar.join();
        enviar2.start();
       enviar2.join();
       ler2.start();

    }

    public static class LeerCorreo extends Thread {
        public LeerCorreo(String name) {
            super(name);
        }

        @Override
        public synchronized void run() {
           try {
               while (!operar || mensaje==null) {
                   System.out.println("entro en la cola de lectura");
                   wait();
                   System.out.println("salgo de la cola lectura");

               }

               operar = false;
               System.out.println("Lendo correo : " + getName());
               mensaje=null;
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
                    while (!operar || mensaje!=null) {
                        System.out.println("entro en la cola de enviado");
                        wait();
                        System.out.println("salgo de la cola de enviado");
                    }
                    operar = false;
                    System.out.println("Enviando  correo : " + getName());
                    mensaje=getName();
                    operar = true;
                    notify();

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());

                }
            }
        }
    }
