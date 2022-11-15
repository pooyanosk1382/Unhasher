package controller.unhasher;

import java.io.*;
import java.net.Socket;

public class CreateSocket {
    private String username;
    public static Socket socket;
    public static BufferedWriter output;
    public static BufferedReader input;

    static {
        try {
            socket = new Socket("localhost", 7080);
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) {
        CreateSocket.socket = socket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BufferedWriter getOutput() {
        return output;
    }

    public BufferedReader getInput() {
        return input;
    }
}