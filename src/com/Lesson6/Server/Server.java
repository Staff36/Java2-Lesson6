package com.Lesson6.Server;

import com.Lesson6.IOThreads.InputThread;
import com.Lesson6.IOThreads.OutputThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket= null;
    Scanner scanner= new Scanner(System.in);
    Socket client;
    DataInputStream in;
    DataOutputStream out;

    public void init(int port)  {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server was started");
            client= serverSocket.accept();
            System.out.println(client+"was connected");
            in= new DataInputStream(client.getInputStream());
            out= new DataOutputStream(client.getOutputStream());
            Thread outThread= new Thread(new OutputThread(out,scanner,"Server sent: "));
            Thread inThread = new Thread(new InputThread(in));
            outThread.start();
            inThread.start();
            outThread.join();
            inThread.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server was shutdown");

    }


}

