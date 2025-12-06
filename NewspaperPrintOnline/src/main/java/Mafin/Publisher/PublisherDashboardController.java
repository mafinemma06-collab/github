package Mafin.Publisher;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class PublisherDashboardController
{
    @javafx.fxml.FXML
    private AnchorPane publisherAnchorPane;@javafx.fxml.FXML
    private AnchorPane partialAnchorpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void viewSubmittedAricleButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Publisher/submittedArticlesView.fxml"));
            Node node = loader.load();
            partialAnchorpane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }


    @javafx.fxml.FXML
    public void scheduleArticleButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Publisher/scheduleArticlesView.fxml"));
            Node node = loader.load();
            partialAnchorpane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void approveArticleButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Publisher/approveView.fxml"));
            Node node = loader.load();
            partialAnchorpane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void removeButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Publisher/removeArticleView.fxml"));
            Node node = loader.load();
            partialAnchorpane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }
}