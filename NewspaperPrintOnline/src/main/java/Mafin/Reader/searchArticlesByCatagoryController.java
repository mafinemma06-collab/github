package Mafin.Reader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class searchArticlesByCatagoryController
{
    @javafx.fxml.FXML
    private TableColumn <article, String>titleTableColumn;
    @javafx.fxml.FXML
    private TableColumn<article, String> idTableColumn;
    @javafx.fxml.FXML
    private TableColumn<article, String> descriptionTableColumn;
    @javafx.fxml.FXML
    private ComboBox< String> catagoryComboBox;
    @javafx.fxml.FXML
    private TableView<article> categoryTableView;

    @javafx.fxml.FXML
    public void initialize() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("articleId"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        catagoryComboBox.getItems().addAll("news", "sports", "entertainment", "weather");

    }
    ObservableList<article> categoryList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void searchCatagoryButtonOnAction(ActionEvent actionEvent) {
            categoryList = GenericFileManager.readAll(article.class, "article.bin");
            String selectedCategory = catagoryComboBox.getValue();
            categoryTableView.getItems().clear();
            try{
                for (article a : categoryList){
                    if (a.getArticleType().equals(selectedCategory)){
                        categoryTableView.getItems().add(a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

