package Samiha.Editor;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class sendFeedbackController {

    @javafx.fxml.FXML
    private TableColumn<Feedback, String> statusTableC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> articleIdTableC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> articleTitleTableC;
    @javafx.fxml.FXML
    private TableView<Feedback> tableVIEW;

    @javafx.fxml.FXML
    public void initialize() {
        statusTableC.setCellValueFactory(new PropertyValueFactory<>("status"));
        articleIdTableC.setCellValueFactory(new PropertyValueFactory<>("articleId"));
        articleTitleTableC.setCellValueFactory(new PropertyValueFactory<>("articleTitle"));

    }

    @javafx.fxml.FXML
    public void feedbackDetailsOnAction(ActionEvent actionEvent) {
    }
}