package com.company.sockets.ejercicio1.apartado2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //Se crea el lector

        // Creando socket servidor
        // Esta clase implementa los sockets de los servidores.
        // Un socket de servidor espera a que las peticiones lleguen a través de la red.
        // Realiza alguna operación basada en esa solicitud,y luego posiblemente devuelve un resultado al solicitante.
        ServerSocket serverSocket = new ServerSocket();

        //Esta clase implementa una dirección de socorro IP (dirección IP+número de puerto)También puede ser un par (nombre de host+número de puerto),
        // en cuyo caso se intentará resolver el nombre de host
        InetSocketAddress addr = new InetSocketAddress("localhost", 2000);
        serverSocket.bind(addr);

        //Aceptamos las conexiones
        Socket newSocket = serverSocket.accept();

        InputStream entrada = newSocket.getInputStream();
        OutputStream salida = newSocket.getOutputStream();


        byte[] mensaje;
        String ms = "";
        while (!ms.equalsIgnoreCase("fin")) {
            mensaje = new byte[140];
            entrada.read(mensaje);
            System.out.println("Cliente: " + new String(mensaje).trim());
            if (new String(mensaje).trim().equalsIgnoreCase("fin")){
                break;
            }
            ms = sc.nextLine();
            salida.write(ms.getBytes());
            System.out.println("Mensaje enviado");
        }



        System.out.println("Cerrando el nuevo socket");

        newSocket.close();

        System.out.println("Cerrando el socket servidor");

        serverSocket.close();

        System.out.println("Terminado");


}
}
