package com.company.sockets.ejercicio1.apartado2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        // Creando socket cliente

        Socket cliente = new Socket();

        InetSocketAddress addr = new InetSocketAddress("localhost", 2000);

        cliente.connect(addr);

        InputStream entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();

        System.out.println("Enviando mensaje");

        System.out.println("Incio de la conversación");

        byte[] ms;
        String mensaje="";

        while (!mensaje.equalsIgnoreCase("fin")) {
            mensaje = sc.nextLine();
            System.out.println("Mensaje enviado ");
            salida.write(mensaje.getBytes());
            ms = new byte[140];
            entrada.read(ms);
            if (new String(ms).trim().equalsIgnoreCase("fin")){
                break;
            }
            System.out.println("Servidor: " + new String(ms).trim());


        }

        System.out.println("Cerrando el socket cliente");
        cliente.close();
        System.out.println("Terminado");


    }

}
