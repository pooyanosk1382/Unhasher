package controller.unhasher;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application{
//    public static void main(String[] args) throws Exception {
//        Node root = new Node();
//        String st = MD5.createPassword("pofak");
//        System.out.println(st);
//        root.trieInsert(root, st, 0, "pofak");
//        root.trieSearch(root, st, 0);
//        String pd = MD5.createPassword("pooyan");
//        root.trieInsert(root, pd, 0, "pooyan");
//        root.trieSearch(root, pd, 0);
//        String ad = MD5.createPassword("ali");
//        root.trieSearch(root, ad, 0);
//    }

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PageController.open("Server");
    }

}
