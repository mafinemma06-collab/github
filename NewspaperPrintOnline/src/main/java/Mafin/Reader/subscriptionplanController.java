package Mafin.Reader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Subscription;

public class subscriptionplanController
{
    @javafx.fxml.FXML
    private ComboBox <String>subscriptionplanComboBox;
    @javafx.fxml.FXML
    private TableColumn<subscription, String> termsTableColumn;
    @javafx.fxml.FXML
    private TableColumn<subscription,String> durationTableColumn;
    @javafx.fxml.FXML
    private TableView<subscription> subscriptionTableView;
    @javafx.fxml.FXML
    private TableColumn<subscription,Integer> costTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        subscriptionplanComboBox.getItems().addAll("online", "offline", "Both");
        termsTableColumn.setCellValueFactory(new PropertyValueFactory<>("terms"));
        durationTableColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        costTableColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));


    }

    @javafx.fxml.FXML
    public void viewplanButtonOnAction(ActionEvent actionEvent) {
        String plan = subscriptionplanComboBox.getValue();
        if(plan == null){
            return;
        }

        ObservableList<subscription> subscriptionsplanList = GenericFileManager.readAll(subscription.class, "subscription.bin");
        if(subscriptionsplanList == null){
            subscriptionsplanList = FXCollections.observableArrayList();
        }

        if(plan.equals("online")){
            subscriptionsplanList.add(new subscription(2000,"online","monthly"));
        }else if (plan.equals("Offline")) {
            subscriptionsplanList.add(new subscription(5000,"offline","yearly"));
        } else if (plan.equals("Both")) {
            subscriptionsplanList.add(new subscription(
                    10000,
                    "OnlineOffline Combo",
                    "30 Days"
            ));
        }
        subscriptionTableView.setItems(subscriptionsplanList);
    }
}