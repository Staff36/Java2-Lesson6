package com.Lesson6.IOThreads;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketException;

public class InputThread implements Runnable{
   DataInputStream in;

    public InputThread(DataInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(in.readUTF());
            } catch (SocketException e){
                System.out.println("Connection closed");
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

