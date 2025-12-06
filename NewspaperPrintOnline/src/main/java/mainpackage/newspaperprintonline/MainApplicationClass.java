package mainpackage.newspaperprintonline;

import Mafin.Reader.DummyObjects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicationClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("LogInView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("newspaper!");
        stage.setScene(scene);
        stage.show();
        DummyObjects d = new DummyObjects();
        d.createDummyObjects();
    }
}
