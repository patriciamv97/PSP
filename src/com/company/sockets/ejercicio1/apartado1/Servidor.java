package com.company.sockets.ejercicio1.apartado1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Servidor {
    public static void main(String[] args) throws IOException {
        // Creando socket servidor
        // Esta clase implementa los sockets de los servidores.
        // Un socket de servidor espera a que las peticiones lleguen a través de la red.
        // Realiza alguna operación basada en esa solicitud,y luego posiblemente devuelve un resultado al solicitante.
        ServerSocket serverSocket = new ServerSocket();

        //Esta clase implementa una dirección de socorro IP (dirección IP+número de puerto)También puede ser un par (nombre de host+número de puerto),
        // en cuyo caso se intentará resolver el nombre de host
        InetSocketAddress addr = new InetSocketAddress("localhost",6666);
        serverSocket.bind(addr);

        //Aceptamos las conexiones
         Socket newSocket=serverSocket.accept();

        InputStream entrada = newSocket.getInputStream();
        OutputStream salida = newSocket.getOutputStream();

        byte[] mensaje = new byte[26];
        entrada.read(mensaje);
        System.out.println("Mensaje recibido: " + new String(mensaje));
        String ms = "Mensaxe 1 desde el servidor";
        salida.write(ms.getBytes());
        byte[] mensaje2 = new byte[26];
        entrada.read(mensaje2);
        System.out.println("Mensaje recibido: " + new String(mensaje2));

        String ms2 = "Mensaxe 2 desde el servidor";
        salida.write(ms2.getBytes());

        byte[] mensaje3 = new byte[26];
        entrada.read(mensaje3);

        String ms3 = "Mensaxe 3 desde el servidor";
        salida.write(ms3.getBytes());

        System.out.println("Mensaje recibido: " + new String(mensaje3));

        System.out.println("Cerrando el nuevo socket");

        newSocket.close();

        System.out.println("Cerrando el socket servidor");

        serverSocket.close();

        System.out.println("Terminado");


    }
}
