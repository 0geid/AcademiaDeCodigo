package org.academiadecodigo.rhashtafaris.chattcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(4444);
            Socket clientSocket = serverSocket.accept();

            System.out.println("Server connection ready!");

            ThreadFactory factory = Executors.defaultThreadFactory();
            ExecutorService executor = Executors.newFixedThreadPool(2, factory);

            factory.newThread();

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            PrintWriter out = new PrintWriter(outputStream, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                String recvMsg = in.readLine();

                System.out.println("Client: " + recvMsg);

                out.println(inputReader.readLine());

                /*if (inputReader.readLine().equals("q")) {
                    System.out.println("Disconnected Server");
                    clientSocket.close();
                }*/
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


        /*public void close () throws IOException {
            this.clientSocket.close();
            out.close();
            in.close();
        }*/


