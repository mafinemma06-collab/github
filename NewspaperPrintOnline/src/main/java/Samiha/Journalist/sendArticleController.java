package Samiha.Journalist;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class sendArticleController
{
    @javafx.fxml.FXML
    private TableColumn articleIdTC;
    @javafx.fxml.FXML
    private TextField articleIdTF;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn articleTitleTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendOnAction(ActionEvent actionEvent) {
    }
}