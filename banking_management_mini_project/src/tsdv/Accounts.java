package tsdv;

public class Accounts{
    private String user_name;
    private String password;
    private double balance;


    public Accounts(){};

//    public Accounts(String user_name, String password) {
//        this.user_name = user_name;
//        this.password = password;
//        this.balance = 0;
//
//    }


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
