package tsdv;

public class Customers extends Accounts {
    private String full_name;
    private String dob;
    private String identify;
    private String address;
    private String number;

    public Customers() {};

    public Customers(String full_name, String dob, String identify, String address, String number) {
        super();
        this.full_name = full_name;
        this.dob = dob;
        this.identify = identify;
        this.address = address;
        this.number = number;
    };

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
