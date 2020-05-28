package org.academiadecodigo.rhashtafaris.chattcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket(InetAddress.getLocalHost(), 4444);

            System.out.println("Client connection Ready!");

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            while (true) {

                PrintWriter out = new PrintWriter(outputStream, true);
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

                out.println(inputReader.readLine());

                System.out.println("Server: " + in.readLine());

                /*if (inputReader.readLine().equals("q")) {
                    System.out.println("Disconnected Client");
                    socket.close();
                }*/
            }


        } catch (UnknownHostException ex) {
            ex.printStackTrace();
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
