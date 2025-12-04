package mainpackage.newspaperprintonline;

import Mafin.Reader.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LogInViewController
{
    @javafx.fxml.FXML
    private PasswordField logInPasswordField;
    @javafx.fxml.FXML
    private Label logInMessageLabel;
    @javafx.fxml.FXML
    private TextField logInIDTextField;
    @javafx.fxml.FXML
    private AnchorPane logInAnchorpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logInButtonOnAction(ActionEvent actionEvent) {
        if (logInIDTextField.getText().length() == 3) {
            Reader logReader = null;
            boolean login = false;
            try {
                FileInputStream fis = new FileInputStream("Reader.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                while (true) {
                    Reader r = (Reader) ois.readObject();
                    if ((logInIDTextField.getText().equals(r.getId())) && (logInPasswordField.getText().equals(r.getPassword()))) {
                        login = true;
                        logReader = r;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                //logInMessageLabel.setText("User ID and PassWord doesn't match");
            }
            if (login) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Reader/ReaderDashboard.fxml"));
                    Node node = loader.load();
                    logInAnchorpane.getChildren().setAll(node);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
}}