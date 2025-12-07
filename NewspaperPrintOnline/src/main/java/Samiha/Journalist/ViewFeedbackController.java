package Samiha.Journalist;

import Samiha.Editor.Feedback;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewFeedbackController {

    @FXML
    private TableColumn<Feedback, String> statusTableC;

    @FXML
    private TableColumn<Feedback, String> articleIdTableC;

    @FXML
    private TableColumn<Feedback, String> articleTitleTableC;

    @FXML
    private TableView<Feedback> tableVIEW;

    @FXML
    public void initialize() {
        statusTableC.setCellValueFactory(new PropertyValueFactory<>("status"));
        articleIdTableC.setCellValueFactory(new PropertyValueFactory<>("id"));
        articleTitleTableC.setCellValueFactory(new PropertyValueFactory<>("title"));

        ObservableList<Feedback> feedbackList = GenericFileManager.readAll(Feedback.class, "Feedback.bin");
        tableVIEW.setItems(feedbackList);
    }

    @FXML
    public void feedbackDetailsOnAction(ActionEvent actionEvent) {
        Feedback selectedFeedback = tableVIEW.getSelectionModel().getSelectedItem();
        if (selectedFeedback != null) {
            System.out.println("Feedback Details:");
            System.out.println("ID: " + selectedFeedback.getId());
            System.out.println("Title: " + selectedFeedback.getTitle());
            System.out.println("Status: " + selectedFeedback.getStatus());
        }
    }
}