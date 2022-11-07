module controller.unhasher {
    requires javafx.controls;
    requires javafx.fxml;


    opens controller.unhasher to javafx.fxml;
    exports controller.unhasher;
}