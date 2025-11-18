package com.example.midterm_2430928_4;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NewsReport {
    private String reportId, reportType, reporterID;
    private LocalDate reportDate, publishDate;
    private boolean isSurveyed;
    private int costIncurred;

    public NewsReport(String reportId, String reportType, String reporterID, LocalDate reportDate, LocalDate publishDate, boolean isSurveyed, int costIncurred) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.reporterID = reporterID;
        this.reportDate = reportDate;
        this.publishDate = publishDate;
        this.isSurveyed = isSurveyed;
        this.costIncurred = costIncurred;
    }

    public String getReportId() {
        return reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReporterID() {
        return reporterID;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public boolean isSurveyed() {
        return isSurveyed;
    }

    public int getCostIncurred() {
        return costIncurred;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setSurveyed(boolean surveyed) {
        isSurveyed = surveyed;
    }

    public void setCostIncurred(int costIncurred) {
        this.costIncurred = costIncurred;
    }

    @Override
    public String toString() {
        return "NewsReport{" +
                "reportId='" + reportId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reporterID='" + reporterID + '\'' +
                ", reportDate=" + reportDate +
                ", publishDate=" + publishDate +
                ", isSurveyed=" + isSurveyed +
                ", costIncurred=" + costIncurred +
                '}';
    }

    public void showNoOfDaysToPublishInAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Days to Publish");

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = publishDate;
        long days = startDate.until(endDate, ChronoUnit.DAYS);

        if (endDate.isBefore(startDate)){
            alert.setContentText("Report is Already published.");
            alert.showAndWait();
        }
        else{
            alert.setContentText(days + "days remaining to publish the report");
            alert.showAndWait();
        }
    }
}
