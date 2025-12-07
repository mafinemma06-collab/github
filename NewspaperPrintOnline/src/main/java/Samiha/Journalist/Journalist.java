package Samiha.Journalist;

import mainpackage.newspaperprintonline.User;

public class Journalist extends User {
    private String designation;

    public Journalist(String id, String name, String phone, String email, String password, String designation) {
        super(id, name, phone, email, password);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
