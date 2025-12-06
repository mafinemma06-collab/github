package Mafin.Publisher;

import mainpackage.newspaperprintonline.User;

import java.io.Serializable;

public class Publisher extends User implements Serializable {
    public Publisher(String id, String name, String phone, String email, String password) {
        super(id, name, phone, email, password);
    }
}
