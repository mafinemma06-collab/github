package Erin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdvertiserDashboardController {

    private Advertiser currentUser;
    private ObservableList<Advertisement> allAds;

    @FXML private Label welcomeLabel;
    @FXML private TableView<Advertisement> adsTable;
    @FXML private TableColumn<Advertisement, LocalDate> dateCol;
    @FXML private TableColumn<Advertisement, String> sizeCol;
    @FXML private TableColumn<Advertisement, Double> costCol;
    @FXML private TableColumn<Advertisement, String> statusCol;
    @FXML private TextField dateFilterField;
    @FXML private TextField titleField;
    @FXML private TextField sectionField;
    @FXML private TextField durationField;
    @FXML private TextField companyNameField;
    @FXML private TextField phoneField;
    @FXML private Label profileMessageLabel;



    public void initData(Advertiser user) {
        this.currentUser = user;
        welcomeLabel.setText("Welcome, " + currentUser.getCompanyName() + " (" + currentUser.getUsername() + ")");
        loadAllAds();
        setupAdTable();

        companyNameField.setText(currentUser.getCompanyName());
        phoneField.setText(currentUser.getContactPhone());
    }

    private void loadAllAds() {

        List<Advertisement> fetchedAds = FileManager.loadAdvertisements().stream()
                .filter(ad -> ad.getAdvertiserUsername().equals(currentUser.getUsername()))
                .collect(Collectors.toList());
        allAds = FXCollections.observableArrayList(fetchedAds);
        adsTable.setItems(allAds);
    }

    private void setupAdTable() {

        dateCol.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("targetSection"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }


    @FXML
    private void onViewActivePrintBookings() {

        adsTable.setItems(allAds.stream()
                .filter(ad -> ad.getStatus().equals("Active"))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));
    }


    @FXML
    private void onFilterByDate() {
        String dateString = dateFilterField.getText();
        if (dateString.isEmpty()) {
            adsTable.setItems(allAds);
            return;
        }
        try {
            LocalDate filterDate = LocalDate.parse(dateString); // Assuming YYYY-MM-DD format
            ObservableList<Advertisement> filteredList = allAds.stream()
                    .filter(ad -> ad.getBookingDate().isEqual(filterDate))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));

            adsTable.setItems(filteredList);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid Date format. Use YYYY-MM-DD.");
        }
    }


    @FXML
    private void onCreateCampaign() {
        String title = titleField.getText();
        String section = sectionField.getText();
        String durationStr = durationField.getText();


        if (title.isEmpty() || section.isEmpty() || durationStr.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill in all fields.");
            return;
        }
        try {
            int duration = Integer.parseInt(durationStr);
            double cost = duration * 100.0;


            Advertisement newAd = new Advertisement(title, currentUser.getUsername(), section, duration, cost, "Active");
            allAds.add(newAd);


            List<Advertisement> updatedList = FileManager.loadAdvertisements();
            updatedList.add(newAd);
            FileManager.saveAdvertisements(updatedList);


            showAlert(Alert.AlertType.INFORMATION, "Success", "Campaign '" + title + "' created successfully. Cost: $" + cost);


            titleField.clear();
            sectionField.clear();
            durationField.clear();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Duration must be a number.");
        }
    }


    @FXML
    private void onDeleteAd() {
        Advertisement selectedAd = adsTable.getSelectionModel().getSelectedItem();
        if (selectedAd == null) {
            showAlert(Alert.AlertType.WARNING, "Error", "Please select an advertisement to delete.");
            return;
        }


        if (confirmAction("Confirm Delete", "Are you sure you want to delete the ad: " + selectedAd.getAdTitle() + "?")) {

            allAds.remove(selectedAd);

            List<Advertisement> allAdsFromFile = FileManager.loadAdvertisements();
            allAdsFromFile.removeIf(ad -> ad.getAdId().equals(selectedAd.getAdId()));
            FileManager.saveAdvertisements(allAdsFromFile);


            showAlert(Alert.AlertType.INFORMATION, "Success", "Ad deleted successfully.");
        }
    }


    @FXML
    private void onUpdateContactInfo() {
        String newCompanyName = companyNameField.getText();
        String newPhone = phoneField.getText();


        if (!newPhone.matches("\\d+")) {
            profileMessageLabel.setText("Validation Failed: Phone number must contain only digits.");
            return;
        }


        currentUser.setCompanyName(newCompanyName);
        currentUser.setContactPhone(newPhone);

        List<User> allUsers = FileManager.loadUsers();

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUsername().equals(currentUser.getUsername())) {
                allUsers.set(i, currentUser);
                break;
            }
        }
        FileManager.saveUsers(allUsers);


        profileMessageLabel.setText("Contact information updated successfully.");
        welcomeLabel.setText("Welcome, " + currentUser.getCompanyName() + " (" + currentUser.getUsername() + ")");
    }




    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean confirmAction(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}