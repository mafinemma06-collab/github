package Mafin.Reader;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class allLatestArticlesCOntroller {
    @javafx.fxml.FXML
    private TableView<article> latestArticleTableView;
    @javafx.fxml.FXML
    private TableColumn<article, String> articleTitleTableColumn;
    @javafx.fxml.FXML
    private TableColumn<article, String> articleIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<article, String> descriptionTableCOlumn;

    @javafx.fxml.FXML
    public void initialize() {
        articleIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));
        articleTitleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionTableCOlumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        ObservableList<article> articleList = GenericFileManager.readAll(article.class, "article.bin");
        System.out.println(articleList.size());
        latestArticleTableView.setItems(articleList);

    }

}
