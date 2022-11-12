package controller.unhasher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class PageController {

    private static Stage stage;
    public static void open(String name) throws IOException{

        stage = new Stage();
        Parent root = FXMLLoader.load(PageController.class.getResource(name + ".fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Silk Road");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });

    }

    public static void close(){

        stage.close();

    }

    public static void exit(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CLOSING PROGRAM");
        alert.setContentText("Are you sure that you want to close the program?");

        if (alert.showAndWait().get() == ButtonType.OK){
            PageController.close();
            System.exit(0);
        }
    }

}

