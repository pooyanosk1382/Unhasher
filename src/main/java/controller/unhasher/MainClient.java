package controller.unhasher;

import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONException;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient extends Application {
    public static void main(String[] args) {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PageController.open("Client");
    }
}
