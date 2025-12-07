package Erin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private List<User> users;


    public void initialize() {

        users = FileManager.loadUsers();
        if (users.isEmpty()) {
            messageLabel.setText("System initialized. No users found.");
        } else {
            messageLabel.setText("System ready. Log in or Sign Up.");
        }
    }


    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User loggedInUser = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (loggedInUser != null) {
            messageLabel.setText("Login successful! Loading dashboard...");

            try {
                String fxmlFile = "";
                String title = "";

                if (loggedInUser.getUserType().equals("Advertiser")) {
                    fxmlFile = "advertiser-dashboard-view.fxml";
                    title = "Advertiser Dashboard";
                    loadDashboard(event, fxmlFile, title, loggedInUser);
                } else if (loggedInUser.getUserType().equals("SMM")) {
                    fxmlFile = "smm-dashboard-view.fxml";
                    title = "Social Media Manager Dashboard";
                    loadDashboard(event, fxmlFile, title, loggedInUser);
                }
            } catch (IOException e) {
                messageLabel.setText("Error loading dashboard: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Invalid Username or Password.");
        }
    }


    @FXML
    protected void onSignUpLinkClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
            Scene scene = new Scene(loader.load(), 500, 450); // Adjust size for registration

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("User Registration");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            messageLabel.setText("Error loading sign-up screen.");
            e.printStackTrace();
        }
    }


    private void loadDashboard(ActionEvent event, String fxmlFile, String title, User user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());


        if (user instanceof Advertiser) {

            ((AdvertiserDashboardController) loader.getController()).initData((Advertiser) user);
        } else if (user instanceof SocialMediaManager) {

            ((SMMDashboardController) loader.getController()).initData((SocialMediaManager) user);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}