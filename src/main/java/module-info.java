module controller.unhasher {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens controller.unhasher to javafx.fxml;
    exports controller.unhasher;
}