package Erin;

import java.io.Serializable;
import java.time.LocalDate;


public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adId;
    private String advertiserUsername;
    private String adTitle;
    private String targetSection;
    private int durationDays;
    private double cost;
    private String status;
    private LocalDate bookingDate;


    private int impressions;
    private int clicks;

    public Advertisement(String adTitle, String advertiserUsername, String targetSection, int durationDays, double cost, String status) {
        this.adId = String.valueOf(System.currentTimeMillis());
        this.advertiserUsername = advertiserUsername;
        this.adTitle = adTitle;
        this.targetSection = targetSection;
        this.durationDays = durationDays;
        this.cost = cost;
        this.status = status;
        this.bookingDate = LocalDate.now();
        this.impressions = (int) (Math.random() * 5000);
        this.clicks = (int) (this.impressions * (Math.random() * 0.05));
    }


    public String getAdTitle() { return adTitle; }
    public String getTargetSection() { return targetSection; }
    public int getDurationDays() { return durationDays; }
    public double getCost() { return cost; }
    public String getStatus() { return status; }
    public LocalDate getBookingDate() { return bookingDate; }
    public String getAdvertiserUsername() { return advertiserUsername; }
    public String getAdId() { return adId; }
    public int getImpressions() { return impressions; }
    public int getClicks() { return clicks; }

    public void setAdTitle(String adTitle) { this.adTitle = adTitle; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }

}