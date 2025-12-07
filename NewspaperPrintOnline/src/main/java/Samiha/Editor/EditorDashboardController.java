package Samiha.Editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class EditorDashboardController
{
    @FXML
    private AnchorPane partialPane;
    @FXML
    public void initialize() {
    }

    @FXML
    public void approveorrejectreadercommentsOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sendFeedbackOnaction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Samiha/Editor/sendFeedback.fxml"));
            Node node = loader.load();
            partialPane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void removeOnaction(ActionEvent actionEvent) {

    }

    @FXML
    public void archiveOnAction (ActionEvent actionEvent){
        }

    @FXML
    public void searchOnaction (ActionEvent actionEvent){
        }

    @FXML
    public void reviewOnaction (ActionEvent actionEvent){
        }




}