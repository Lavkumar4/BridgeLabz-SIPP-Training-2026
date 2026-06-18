// Custom Exception
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient Balance! Available: ₹" + balance +
              ", Requested: ₹" + amount +
              ", Shortfall: ₹" + (amount - balance));
    }
}

// ATM Account Class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.println("Withdrawal Successful!");
        System.out.println("Remaining Balance: ₹" + balance);
    }
}

// Main Class
public class ATMWithdrawalSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        try {
            account.withdraw(8000);
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Transaction Completed.");
    }
}