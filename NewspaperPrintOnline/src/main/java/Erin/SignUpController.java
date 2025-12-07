package Erin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SignUpController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ComboBox<String> userTypeCombo;
    @FXML private Label messageLabel;


    @FXML private GridPane advertiserFieldsPane;
    @FXML private TextField companyNameField;
    @FXML private TextField phoneField;

    public void initialize() {
        userTypeCombo.getItems().addAll("Advertiser", "Social Media Manager");

        advertiserFieldsPane.setVisible(false);
    }

    @FXML
    protected void onUserTypeChange() {

        boolean isAdvertiser = "Advertiser".equals(userTypeCombo.getValue());
        advertiserFieldsPane.setVisible(isAdvertiser);
    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = userTypeCombo.getValue();


        if (username.isEmpty() || password.isEmpty() || userType == null) {
            messageLabel.setText("Please fill in username, password, and select a user type.");
            return;
        }


        List<User> allUsers = FileManager.loadUsers();
        if (allUsers.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username))) {
            messageLabel.setText("Username already exists. Please choose another.");
            return;
        }

        User newUser = null;
        if ("Advertiser".equals(userType)) {
            String companyName = companyNameField.getText();
            String phone = phoneField.getText();


            if (companyName.isEmpty() || !phone.matches("\\d+")) {
                messageLabel.setText("Advertiser fields invalid: Company Name required & Phone must be digits.");
                return;
            }
            newUser = new Advertiser(username, password, companyName, phone);

        } else if ("Social Media Manager".equals(userType)) {
            newUser = new SocialMediaManager(username, password);
        }


        if (newUser != null) {
            allUsers.add(newUser);
            FileManager.saveUsers(allUsers);
            messageLabel.setText("Registration successful for " + userType + "! Returning to login.");


            try {
                Thread.sleep(1500);
                onBackToLoginClick(event);
            } catch (Exception e) {

            }
        }
    }

    @FXML
    protected void onBackToLoginClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load(), 400, 300);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("System Login");
        stage.setScene(scene);
        stage.show();
    }
}