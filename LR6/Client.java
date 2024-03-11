package LR6;

public class Client {
    private String name;
    private int age;
    private double account_balance;

    public Client(String name, int age, double account_balance) {
        this.name = name;
        this.age = age;
        this.account_balance = account_balance;
    }

    public Client() {
        this("undefined", 0, 0);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public void setAge(int age_in_years) {
        this.age = age_in_years;
    }

    public int getAge() {
        return this.age;
    }

    public void setBalance(double balance) {
        this.account_balance = balance;
    }

    public double getBalance() {
        return this.account_balance;
    }

    public String toString() {
        return this.getName() + "|" + Integer.toString(this.getAge()) + "|" + Double.toString(this.getBalance());
    }
}

