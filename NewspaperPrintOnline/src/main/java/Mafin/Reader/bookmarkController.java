package Mafin.Reader;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class bookmarkController
{
    @javafx.fxml.FXML
    private TableColumn<article, String> titleTableColumn;
    @javafx.fxml.FXML
    private TableView <article> tableviewbookmark;
    @javafx.fxml.FXML
    private TableColumn<article, String> descriptionTableCOlumn;
    @javafx.fxml.FXML
    private TableColumn<article, String> idtableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        idtableColumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));

        ObservableList<article> bookmarkarticleList = GenericFileManager.readAll(article.class, "article.bin");
        System.out.println(bookmarkarticleList.size());
        tableviewbookmark.setItems(bookmarkarticleList);

    }
}