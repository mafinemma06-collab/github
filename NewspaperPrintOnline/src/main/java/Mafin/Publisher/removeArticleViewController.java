package Mafin.Publisher;

import Mafin.Reader.GenericFileManager;
import Mafin.Reader.article;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class removeArticleViewController
{
    @javafx.fxml.FXML
    private TableColumn<article, String> titleTableColumn;
    @javafx.fxml.FXML
    private TableColumn<article,String> articleidtableColumn;
    @javafx.fxml.FXML
    private TextField idTextfield;
    @javafx.fxml.FXML
    private TableView<article> tableviewremove;

    @javafx.fxml.FXML
    public void initialize() {
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        articleidtableColumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));

        ObservableList<article> removearticlelist = GenericFileManager.readAll(article.class, "article.bin");
        tableviewremove.setItems(removearticlelist);
    }

    @javafx.fxml.FXML
    public void removeArticleButtonOnAction(ActionEvent actionEvent) {
        if (idTextfield.getText().isEmpty() ){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error");
            alert1.setContentText("enter id to remove Article!");
            alert1.showAndWait();
            return;
        }
        tableviewremove.getItems().clear();
        ObservableList<article> removearticlelist = GenericFileManager.readAll(article.class, "article.bin");
        String selectedId = idTextfield.getText();
        try {
            for (article a : removearticlelist){
                if (selectedId.equals(a.getArticleId())){
                    removearticlelist.remove(a);
                    tableviewremove.getItems().remove(a);
                    tableviewremove.getItems().clear();
                    tableviewremove.getItems().addAll(removearticlelist);
                    GenericFileManager.writeAll(removearticlelist, "Article.bin");
                }
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }


    }
}