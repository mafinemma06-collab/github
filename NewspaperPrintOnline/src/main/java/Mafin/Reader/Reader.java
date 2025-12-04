package Mafin.Reader;

import mainpackage.newspaperprintonline.User;

public class Reader extends User {
    private String subscriptionType;

    public Reader(String id, String name, String phone, String email, String password, String subscriptionType) {
        super(id, name, phone, email, password);
        this.subscriptionType = subscriptionType;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
