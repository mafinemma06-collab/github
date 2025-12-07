package Samiha.Journalist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class journalistDashboardController
{
    @javafx.fxml.FXML
    private AnchorPane journalistPane;
    @javafx.fxml.FXML
    private AnchorPane partialPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendArticleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void editArticleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void myarticleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void editorFeedbackOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void writearticleButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Samiha/Journalist/writeArticle.fxml"));
            Node node = loader.load();
            partialPane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}