package Samiha.Journalist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class subMittedArticleController
{
    @javafx.fxml.FXML
    private TableView<Article> TaBleView;
    @javafx.fxml.FXML
    private TableColumn<Article, String > articleIdtaBLeC;
    @javafx.fxml.FXML
    private TableColumn<Article, String> articleTitletaBLec;

    @javafx.fxml.FXML
    public void initialize() {
        articleIdtaBLeC.setCellValueFactory(new PropertyValueFactory<>( "Id") ) ;
        articleTitletaBLec.setCellValueFactory(new PropertyValueFactory<>( " Title") ) ;
        ObservableList<Article> subMittedArticleList = FXCollections.observableArrayList();
        try{
            subMittedArticleList = GenericFileManager .readAll(Article.class,  "Article.bin");
            for (Article b : subMittedArticleList){
                if (b.getArticleStatus().equals("Pending"));{
                    TaBleView.getItems().add(b);

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}