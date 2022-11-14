package controller.unhasher;

import org.json.JSONException;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 7078);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (socket.isConnected()) {
                String data = scanner.nextLine();
                if (data.equals("sayHello")) {
                    bufferedWriter.write(JsonHandler.sayHello());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    System.out.println(bufferedReader.readLine());
                } else {
                    System.out.println("Not accepted text!");
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
