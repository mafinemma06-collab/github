package Mafin.Publisher;

import Mafin.Reader.GenericFileManager;
import Mafin.Reader.article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class submittedArticleViewController
{
    @javafx.fxml.FXML
    private TableColumn<article, String> idTableColumn;
    @javafx.fxml.FXML
    private TableView <article>tableviewSubmittedArticle;
    @javafx.fxml.FXML
    private TableColumn<article, String> titleTabletitle;

    @javafx.fxml.FXML
    public void initialize() {
        titleTabletitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));

        ObservableList<article> submittedArticleList = FXCollections.observableArrayList();
        try {
            submittedArticleList = GenericFileManager.readAll(article.class, "article.bin");

            for (article b : submittedArticleList) {
                if ((b.getStatus()).equals("pending"));{
                    tableviewSubmittedArticle.getItems().add(b);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}}

