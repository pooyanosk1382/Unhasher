package controller.unhasher;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
////        Node root = new Node();
////        root.trieInsert(root, "kiomars", 0);
////        root.trieSearch(root, "kiomars", 0);
////        root.trieSearch(root, "kir", 0);
////        root.trieDelete(root, "kiomars", 0);
////        root.trieSearch(root, "kiomars", 0);

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PageController.open("Server");
    }

}
