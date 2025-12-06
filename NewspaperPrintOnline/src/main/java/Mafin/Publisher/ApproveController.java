package Mafin.Publisher;

import Mafin.Reader.GenericFileManager;
import Mafin.Reader.article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ApproveController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn <article,String>idTableColumn;
    @javafx.fxml.FXML
    private TextArea reasontextArea;
    @javafx.fxml.FXML
    private TableView<article> tableview;
    @javafx.fxml.FXML
    private TableColumn <article, String>titleTablecolumn;

    @javafx.fxml.FXML
    public void initialize() {
        titleTablecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));
    }
    ObservableList<article> ArticleList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void approveButtonOnAction(ActionEvent actionEvent) {
        ArticleList = GenericFileManager.readAll(article.class, "article.bin");
        String enterid = idTextField.getText();
        boolean found = false;

        try {
            for (article a : ArticleList) {
                if (a.getArticleId().equals(enterid)) {
                    a.setStatus("Approve");
                    found = true;
                    break;
                }
            }
            if (!found) {
                reasontextArea.setText("Article ID not found!");
            } else {
                GenericFileManager.writeAll(ArticleList, "article.bin");
                reasontextArea.setText("Article Approved Successfully!");
                tableview.setItems(ArticleList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            reasontextArea.setText("Error occurred while approving.");
        }
    }

    @javafx.fxml.FXML
    public void rejectButtonOnAction(ActionEvent actionEvent) {
    }
}


