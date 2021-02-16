package com.Lesson6.Client;

import com.Lesson6.IOThreads.InputThread;
import com.Lesson6.IOThreads.OutputThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket= null;
    DataInputStream in;
    DataOutputStream out;
    public void connectingToServer(int port){

        Scanner scanner= new Scanner(System.in);
        try {
            socket = new Socket("127.0.0.1", port);
            System.out.println("Connecting success");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread inThread =new Thread(new InputThread(in));
            Thread outThread= new Thread(new OutputThread(out,scanner,""));
            inThread.start();
            outThread.start();
            inThread.join();
            outThread.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
