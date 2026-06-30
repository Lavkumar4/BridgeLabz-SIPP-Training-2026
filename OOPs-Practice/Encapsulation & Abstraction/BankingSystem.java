// Abstract Class
abstract class BankAccount {

    // Private Fields (Encapsulation)
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);
    }

    // Abstract Method
    public abstract double calculateInterest();
}

// SavingsAccount Class
class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber,
                          String holderName,
                          double balance,
                          double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

// CurrentAccount Class
class CurrentAccount extends BankAccount {

    private double monthlyBonusRate;

    public CurrentAccount(String accountNumber,
                          String holderName,
                          double balance,
                          double monthlyBonusRate) {
        super(accountNumber, holderName, balance);
        this.monthlyBonusRate = monthlyBonusRate;
    }

    public double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

// Main Class
public class BankingSystem {

    public static void main(String[] args) {

        // Savings Account
        SavingsAccount sa =
                new SavingsAccount("SA101", "Lav Kumar", 50000, 5);

        sa.deposit(10000);
        sa.withdraw(5000);

        System.out.println("\n===== Savings Account =====");
        sa.displayAccountDetails();
        System.out.println("Interest : ₹" + sa.calculateInterest());

        // Current Account
        CurrentAccount ca =
                new CurrentAccount("CA201", "Rahul Sharma", 80000, 2);

        ca.deposit(5000);
        ca.withdraw(10000);

        System.out.println("\n===== Current Account =====");
        ca.displayAccountDetails();
        System.out.println("Interest : ₹" + ca.calculateInterest());
    }
}