package controller.unhasher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;

public class ClientController {

    @FXML
    private TextField TextFieldHashed;

    @FXML
    private Label WordLabel;

    @FXML
    void Confirmation(ActionEvent event) {
        String hashed = TextFieldHashed.getText();
        Node root = new Node();
        root.trieSearch(root, hashed, 0);
    }

}
