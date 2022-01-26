package com.company.sockets.ejercicio1.apartado1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        // Creando socket cliente

        Socket cliente = new Socket();

        InetSocketAddress addr = new InetSocketAddress("localhost", 6666);

        cliente.connect(addr);

        InputStream entrada= cliente.getInputStream();
        OutputStream salida= cliente.getOutputStream();

        System.out.println("Enviando mensaje");

        String mensaje = "Mensaxe 1 desde el cliente";
        salida.write(mensaje.getBytes());

        byte[] ms = new byte[27];
        entrada.read(ms);
        System.out.println("Mensaje recibido: " + new String(ms));

        String mensaje2 = "Mensaxe 2 desde el cliente";
        salida.write(mensaje2.getBytes());

        byte[] ms2 = new byte[27];
        entrada.read(ms2);
        System.out.println("Mensaje recibido: " + new String(ms2));

        String mensaje3 = "Mensaxe 3 desde el cliente";
        salida.write(mensaje3.getBytes());

        byte[] ms3 = new byte[27];
        entrada.read(ms3);
        System.out.println("Mensaje recibido: " + new String(ms3));


        System.out.println("Mensaje enviado");

        System.out.println("Cerrando el socket cliente");

        cliente.close();

        System.out.println("Terminado");


    }

}
