class BankAccount {
    String accountHolder;
    long accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Amount: ₹" + amount);
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Amount: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Method to display balance
    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class SimulateAnATM {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(
                "Lav Kumar",
                1234567890L,
                10000.0);

        account.displayBalance();

        account.deposit(5000);
        account.displayBalance();

        account.withdraw(3000);
        account.displayBalance();

        account.withdraw(15000);
    }
}