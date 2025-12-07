
package Samiha.Editor;

import mainpackage.newspaperprintonline.User;

public class Editor extends User {
    private String designation;

    public Editor(String id, String name, String phone, String email, String password, String designation) {
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