package model;

import java.time.LocalDate;

public class Payment {
    private Integer customerNumber;
    private String checkNumber;
    private LocalDate paymentDate;
    private Double amount;

    public Payment() {}

    public Payment(Integer customerNumber, String checkNumber, LocalDate paymentDate, Double amount) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getPaymentDate() {
        return String.valueOf(paymentDate);
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAmount() {
        return String.valueOf(amount);
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
