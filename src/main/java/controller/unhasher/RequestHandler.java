package controller.unhasher;

import java.io.*;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestHandler {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public RequestHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void start() {
        String text;
        while (socket.isConnected()) {
            try {
                text = bufferedReader.readLine();
                JSONObject jsonRequest = new JSONObject(text);
                handler(jsonRequest);
            } catch (IOException | JSONException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void handler(JSONObject data) throws JSONException {
        String request = data.getString("Request");
        data.remove("Request");
        switch (request) {
            case "sayHello" : {
                try {
                    bufferedWriter.write("Hello World!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
