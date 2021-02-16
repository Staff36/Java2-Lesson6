package com.Lesson6.IOThreads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class OutputThread implements Runnable {
DataOutputStream out;
Scanner scanner;
String prefixMsg;

    public OutputThread(DataOutputStream out, Scanner scanner, String prefixMsg) {
        this.out = out;
        this.scanner = scanner;
        this.prefixMsg = prefixMsg;
    }

    @Override
    public void run() {
        try {
            while (true){
                try{
                    out.writeUTF(prefixMsg+scanner.nextLine());
                }catch (SocketException e){
                    System.out.println("Connection closed");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
