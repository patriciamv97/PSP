package com.company.sockets.ejercicio2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Creando socket servidor
        // Esta clase implementa los sockets de los servidores.
        // Un socket de servidor espera a que las peticiones lleguen a través de la red.
        // Realiza alguna operación basada en esa solicitud,y luego posiblemente devuelve un resultado al solicitante.
        ServerSocket serverSocket = new ServerSocket();

        //Esta clase implementa una dirección de socorro IP (dirección IP+número de puerto)También puede ser un par (nombre de host+número de puerto),
        // en cuyo caso se intentará resolver el nombre de host
        InetSocketAddress addr = new InetSocketAddress("localhost",2000);
        serverSocket.bind(addr);

        //Aceptamos las conexiones
         Socket newSocket=serverSocket.accept();

        InputStream entrada=newSocket.getInputStream();
        OutputStream salida=newSocket.getOutputStream();


        int numero = 0;
        for (int i=0; i< 5;i++){
            numero= numero+entrada.read();

        }
        System.out.println(numero);
        System.out.println("Cerrando el nuevo socket");

        newSocket.close();

        System.out.println("Cerrando el socket servidor");

        serverSocket.close();

        System.out.println("Terminado");


    }
}
