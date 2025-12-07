package Samiha.Journalist;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class subMittedArticle
{
    @javafx.fxml.FXML
    private TableView<Article> TaBleView;
    @javafx.fxml.FXML
    private TableColumn<Article,String> articleIdtaBLeC;
    @javafx.fxml.FXML
    private TableColumn<Article , String > articleTitletaBLec;

    @javafx.fxml.FXML
    public void initialize() {
        articleIdtaBLeC.setCellValueFactory(new PropertyValueFactory<>( "Id") );
        articleTitletaBLec.setCellValueFactory(new PropertyValueFactory<>( " Title") ) ;


    }}