package com.example.midterm_2430928_4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class NewsReportViewController
{
    @javafx.fxml.FXML
    private Label highAndLowCostLabel;
    @javafx.fxml.FXML
    private TextField filterReporterIdTF;
    @javafx.fxml.FXML
    private TableColumn<NewsReport, String> reporterIdColumnTableView;
    @javafx.fxml.FXML
    private TableView<NewsReport> tableView;
    @javafx.fxml.FXML
    private TableColumn<NewsReport, Integer> costIncurredColumnTableView;
    @javafx.fxml.FXML
    private DatePicker publishDateDP;
    @javafx.fxml.FXML
    private TableColumn<NewsReport, String> reportTypeColumnTableView;
    @javafx.fxml.FXML
    private ComboBox<String> surveyCB;
    @javafx.fxml.FXML
    private TableColumn<NewsReport,String> reportIdColumnTableView;
    @javafx.fxml.FXML
    private TextField reporterIdTF;
    @javafx.fxml.FXML
    private TextField costIncurredTF;
    @javafx.fxml.FXML
    private TableColumn<NewsReport, LocalDate> publishDateColumnTableView;
    @javafx.fxml.FXML
    private ComboBox<String> filterTypeCB;
    @javafx.fxml.FXML
    private TextField reportIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeCB;
    @javafx.fxml.FXML
    private DatePicker reportDateDP;

    ArrayList<NewsReport> fineList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        reportTypeCB.getItems().addAll("Finance", "Politics", "Sports", "Entertainment", "Health");
        surveyCB.getItems().addAll("Yes", "No");
        filterTypeCB.getItems().addAll("Finance", "Politics", "Sports", "Entertainment", "Health");

        reportIdColumnTableView.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportTypeColumnTableView.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        reporterIdColumnTableView.setCellValueFactory(new PropertyValueFactory<>("reporterID"));
        costIncurredColumnTableView.setCellValueFactory(new PropertyValueFactory<>("costIncurred"));
        publishDateColumnTableView.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
    }


    @javafx.fxml.FXML
    public void showHighestAndLowestCostButtonOnAction(ActionEvent actionEvent) {
        int highest = 50000;
        int lowest = 0;
        int checkCost = Integer.parseInt(costIncurredTF.getText());
        for (NewsReport news : tableView.getItems()){
            if(news.getCostIncurred()> lowest){
                highest = news.getCostIncurred();
            }
            if(news.getCostIncurred()< highest){
                lowest = news.getCostIncurred();
            }
        }
        highAndLowCostLabel.setText(
                "Highest : " + highest + "\n" +
                "Lowest : " + lowest
        );
    }

    @javafx.fxml.FXML
    public void validateAndAddButtonOnAction(ActionEvent actionEvent) {
        NewsReport report = new NewsReport(
                reportIdTF.getText(),
                reportTypeCB.getValue(),
                reporterIdTF.getText(),
                reportDateDP.getValue(),
                publishDateDP.getValue(),
                Boolean.parseBoolean(surveyCB.getValue()),
                Integer.parseInt(costIncurredTF.getText())
        );
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");

        String checkSurvey = surveyCB.getValue();
        int checkCost = Integer.parseInt(costIncurredTF.getText());
        LocalDate checkPublishDate = publishDateDP.getValue();
        LocalDate checkReportDate = reportDateDP.getValue();

        if ((checkSurvey.equals("No") && checkCost <= 5000) || (checkSurvey.equals("Yes") && checkCost <= 50000) ){
            if (checkPublishDate.isBefore(checkReportDate)){
                fineList.add(report);
            }
        }
        else {
            alert.setContentText("Enter valid Input");
            alert.showAndWait();
        }
        tableView.getItems().clear();
        tableView.getItems().addAll(fineList);
    }

    @javafx.fxml.FXML
    public void filterAndLoadButtononAction(ActionEvent actionEvent) {
        String checkReportType = filterTypeCB.getValue();
        String checkReporterId = filterReporterIdTF.getText();


        ArrayList<NewsReport> filtered = new ArrayList<>();
        for (NewsReport r : fineList){
            if (checkReportType.equals(r.getReportType()) && checkReporterId.equals(r.getReporterID())){
                filtered.add(r);
            }
        }
        tableView.getItems().clear();
        tableView.getItems().addAll(filtered);
    }
}