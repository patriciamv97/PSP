package com.company.sockets.calculadoraSinInterfaz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        // Creando socket cliente

        Scanner sc = new Scanner(System.in); //Se crea el lector


        Socket cliente = new Socket();

        InetSocketAddress addr = new InetSocketAddress("localhost", 2000);

        cliente.connect(addr);

        InputStream entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();

        System.out.println("Enviando mensaje");

        int [] operandos = new int[2];


        System.out.println("Introduce operador :");
        String operador = sc.nextLine();
        salida.write(operador.getBytes());

        System.out.println("Introduce el primero operando :");
        int primerOperando = Integer.parseInt(sc.nextLine());
        operandos[0]=primerOperando;
        System.out.println("Introduce el segundo operando :");
        int segundoOperando = Integer.parseInt(sc.nextLine());
        operandos[1]=segundoOperando;


        for (int i = 0; i < 2; i++) {
            salida.write(operandos[i]);
        }

        System.out.println("¿Desea salir del progrma? \nSi desea salir teclee fin");
        String salir =sc.nextLine();




        System.out.println("Mensaje enviado");

        System.out.println("Cerrando el socket cliente");

        cliente.close();

        System.out.println("Terminado");


    }

}
