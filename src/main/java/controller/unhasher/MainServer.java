package controller.unhasher;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    private ServerSocket serverSocket;

    public MainServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted");
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7078);
            MainServer server = new MainServer(serverSocket);
            System.out.println("yes");
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
