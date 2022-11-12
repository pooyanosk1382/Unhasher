package controller.unhasher;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;

public class ServerController {

    @FXML
    private Label HashedLabel;

    @FXML
    private TextField TextFieldWord;

    @FXML
    void Confirmation(DragEvent event) {
        System.out.println(String.valueOf(TextFieldWord.getText()));
    }

}
