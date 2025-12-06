package Mafin.Publisher;

import Mafin.Reader.GenericFileManager;
import Mafin.Reader.article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class scheduleArticlesController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn<article, String> titleTableColumn;
    @javafx.fxml.FXML
    private TableColumn<article,String> idTAbleCOlumn;
    @javafx.fxml.FXML
    private TableView<article> tableView;
    @javafx.fxml.FXML
    private DatePicker dateDatepicker;
    @javafx.fxml.FXML
    private Label messagelabel;

    @javafx.fxml.FXML
    public void initialize() {
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        idTAbleCOlumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));

        ObservableList<article> scheduleArticleList = FXCollections.observableArrayList();
        try {
            scheduleArticleList = GenericFileManager.readAll(article.class, "article.bin");
            for(article c : scheduleArticleList){
                if(c.getStatus().equals("Approve")){
                    scheduleArticleList.add(c);
                }
            }
            tableView.setItems(scheduleArticleList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String articleId = idTextField.getText();
        LocalDate selectedDate = dateDatepicker.getValue();

        if(articleId == null || articleId.isEmpty()){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setContentText("id must be filled.");
            alert.showAndWait();
            return;
        }
        if(selectedDate == null){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setContentText("date field must be filled.");
            alert.showAndWait();
            return;
        }
        article selectedArticle  = null;
        for(article c : scheduleArticleList){
            if(c.getArticleId().equals( articleId )){
                selectedArticle = c;
                break;
            }
        }
        if(selectedArticle == null){
            messagelabel.setText("article id not found!:(");
            return;
        }
        selectedArticle.setPublicationdate(selectedDate.toString());
        try{
            GenericFileManager.writeAll(scheduleArticleList, "article.bin");
            messagelabel.setText("Article scheduled successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            messagelabel.setText("Error saving schedule!");
        }


    }

}