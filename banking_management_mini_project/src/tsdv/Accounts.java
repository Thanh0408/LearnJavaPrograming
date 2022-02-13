package tsdv;

public class Accounts{
    private String user_name;
    private String password;
    private double balance;
    private double deposit;

    public Accounts(){};

    public Accounts(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
        this.balance = 0;
        this. deposit = 0;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
