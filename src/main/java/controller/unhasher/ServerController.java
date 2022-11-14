package controller.unhasher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ServerController {

    @FXML
    private Label HashedLabel;

    @FXML
    private TextField TextFieldWord;

    @FXML
    void Confirmation(ActionEvent event) {
        String word = TextFieldWord.getText();
        String hashed = MD5.createPassword(word);
        HashedLabel.setText(hashed);
        Node root = new Node();
        root.trieInsert(root, hashed, 0, word);
    }

}
