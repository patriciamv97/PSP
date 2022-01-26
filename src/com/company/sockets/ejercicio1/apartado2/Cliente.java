package com.company.sockets.ejercicio1.apartado2;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        // Creando socket cliente

        Socket cliente = new Socket();

        InetSocketAddress addr = new InetSocketAddress("localhost", 6666);

        cliente.connect(addr);

        InputStream entrada= cliente.getInputStream();
        OutputStream salida= cliente.getOutputStream();

        System.out.println("Enviando mensaje");

        System.out.println("Incio de la conversación");

        byte[] ms;
        do {
            String mensaje = sc.nextLine();
            salida.write(mensaje.getBytes());
            System.out.println("Mensaje enviado");
            ms = new byte[140];
            entrada.read(ms);
            System.out.println("Mensaje recibido: " + new String(ms).trim());
        }while (new String(ms).equalsIgnoreCase("fin"));

        System.out.println("Cerrando el socket cliente");
        cliente.close();
        System.out.println("Terminado");


    }

}
