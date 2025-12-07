package Samiha.Journalist;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class writearticleController
{
    @javafx.fxml.FXML
    private TextField articleIdTF;
    @javafx.fxml.FXML
    private TextField articletitleTF;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitOnaction(ActionEvent actionEvent) {
        if (articleIdTF.getText().isEmpty() ||
                articletitleTF .getText().isEmpty() ||
                descriptionTA.getText().isEmpty()){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setContentText("All fields must be filled.");
            alert.showAndWait();
            return;
        }
        Article article = new Article(articleIdTF.getText(),articletitleTF .getText(),descriptionTA.getText() );
        GenericFileManager.append(article, "Article.bin");
        outputLabel.setText("Article successfully submitted");
    }
    
}