package exceptionclass.bank;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is null");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubtract = 100000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) {
            throw new InvalidBankOperationException("Invalid max substract", ErrorCode.INVALID_AMOUNT);
        }
        this.maxSubtract = maxSubtract;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        balance += amount;
        return balance;
    }

    public double subtract(double amount) {
        if (amount < 0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        if (balance < amount) {
            throw new InvalidBankOperationException("Low balance", ErrorCode.LOW_BALANCE);
        }
        balance -= amount;
        return balance;
    }
}
