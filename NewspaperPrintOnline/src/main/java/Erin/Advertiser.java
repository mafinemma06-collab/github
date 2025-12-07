package Erin;

public class Advertiser extends User {
    private static final long serialVersionUID = 1L;


    private String companyName;
    private String contactPhone;

    public Advertiser(String username, String password, String companyName, String contactPhone) {
        super(username, password, "Advertiser");
        this.companyName = companyName;
        this.contactPhone = contactPhone;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}