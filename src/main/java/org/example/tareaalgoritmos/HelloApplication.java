
package org.example.tareaalgoritmos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        HelloController control = new HelloController();

        Scene scene = new Scene(control.crearGraficas(), 700, 600);

        stage.setTitle("Grafica de sumatorias");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
