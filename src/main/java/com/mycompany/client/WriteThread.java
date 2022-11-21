package com.mycompany.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
 

public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;
    
    /**
     * Writes a thread.
     */
    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;
 
        try {
            // Initialize the buffer for writing
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("[ERROR ESCRITURA]: " + ex.getMessage());
        }
    }
 
    @Override
    public void run() {
 
        // Reads username
        Scanner scanner = new Scanner(System.in);
        
        // Saves username in client
        client.setUserName(client.getUserName());
 
        String text;
 
        do {
            System.out.print("[" + client.getUserName() + "]: ");
            text = scanner.nextLine();
            writer.println(text);
            if(text.equals("BOT")){
                Bot bot = new Bot();
                String joke = bot.askBoot();
                System.out.println("[BOT]: "+joke);
                writer.println("[BOT]: "+joke);
            } 
 
        } while (!text.equals("SALIR"));
 
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("[ERROR ESCRITURA]: " + ex.getMessage());
        }
    }
}