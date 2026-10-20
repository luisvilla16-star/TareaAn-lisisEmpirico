module org.example.tareaalgoritmos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tareaalgoritmos to javafx.fxml;
    exports org.example.tareaalgoritmos;
}