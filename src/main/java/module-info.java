module com.example.zoominfo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoominfo to javafx.fxml;
    exports com.example.zoominfo;
}