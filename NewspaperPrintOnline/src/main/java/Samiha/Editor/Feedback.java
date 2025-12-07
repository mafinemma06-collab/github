package Samiha.Editor;

import mainpackage.newspaperprintonline.User;

public class Feedback extends User {
    private String designation;

    public Feedback(String id, String name, String phone, String email, String password, String designation) {
        super(id, name, phone, email, password);   // call User constructor
        this.designation = designation;
    }
    private String status;
    private String id;
    private String title;

    public String getStatus() { return status; }
    public String getId() { return id; }
    public String getTitle() { return title; }

    public String getDesignation() {
        return designation;
    }
}