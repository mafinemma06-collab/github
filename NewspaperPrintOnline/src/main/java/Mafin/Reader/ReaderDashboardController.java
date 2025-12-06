package Mafin.Reader;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReaderDashboardController {
    @javafx.fxml.FXML
    private AnchorPane readerAnchorpane;  @javafx.fxml.FXML
    private AnchorPane partialAnchorPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void readLastestArticleButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Reader/allLatestArticlesView.fxml"));
            Node node = loader.load();
            partialAnchorPane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void searchArticleCatagoryButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Reader/searchArticlesByCatagoryView.fxml"));
            Node node = loader.load();
            partialAnchorPane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void subscriptionPlanButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Reader/subscribtionplanView.fxml"));
            Node node = loader.load();
            partialAnchorPane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void bookmarkButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mafin/Reader/bookmarkView.fxml"));
            Node node = loader.load();
            partialAnchorPane.getChildren().setAll(node);
        } catch (Exception e) {
            //
        }
    }
}