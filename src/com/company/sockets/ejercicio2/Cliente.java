package com.company.sockets.ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        // Creando socket cliente

        Socket cliente = new Socket();

        InetSocketAddress addr = new InetSocketAddress("localhost", 2000);

        cliente.connect(addr);

        InputStream entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();

        System.out.println("Enviando mensaje");

        int[] suma = {1, 2, 3, 4, 5};
        for (int i = 0; i < suma.length; i++) {
            salida.write(suma[i]);
        }
        System.out.println("Mensaje enviado");

        System.out.println("Cerrando el socket cliente");

        cliente.close();

        System.out.println("Terminado");


    }

}
