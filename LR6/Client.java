package LR6;

public class Client {
    private String clientName;
    private int age;
    private double accountBalance;

    public Client(String name,
                  int age,
                  double accountBalance) {
        this.clientName = name;
        this.age = age;
        this.accountBalance = accountBalance;
    }

    public void setclientName(String name) {
        this.clientName = name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setBalance(double balance) {
        this.accountBalance = balance;
    }

    public double getBalance() {
        return this.accountBalance;
    }
};