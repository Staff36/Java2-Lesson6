package com.Lesson6.IOThreads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class EchoThread implements Runnable{
    DataInputStream in;
    DataOutputStream out;
    Socket client;

    public EchoThread(DataInputStream in, DataOutputStream out, Socket client) {
        this.in = in;
        this.out = out;
        this.client = client;
    }

    @Override
    public void run() {
        while (true){
            try{
                String msg= in.readUTF();
                out.writeUTF("Client from port "+client.getPort()+" wrote: "+msg);
            }catch(SocketException e){
                System.out.println("Connection closed");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
