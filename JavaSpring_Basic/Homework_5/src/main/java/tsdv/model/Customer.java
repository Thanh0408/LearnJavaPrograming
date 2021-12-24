package tsdv.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Customer {
    private String fullName;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dob;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;

    public Customer() {}

    public Customer(String fullName, Date dob, String email, String address, String phoneNumber, String gender) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return  getFullName() + " || " +getDob() + " || " + getEmail() + " || " + getAddress() + " || " + getPhoneNumber() + " ||" + getGender();
    }
}
