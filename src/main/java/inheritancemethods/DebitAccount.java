package inheritancemethods;

public class DebitAccount {
    private String accountNumber;
    private long balance;
    private static final double COST = 3.0;
    private static final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount) {
        return (long) Math.max(amount * (COST / 100.0), MIN_COST);
    }

    public boolean transaction(long amount) {
        long sumOfCost = amount + costOfTransaction(amount);
        if (sumOfCost < balance) {
            balance -= sumOfCost;
            return true;
        }
        return false;
    }

    public void balanceToZero() { // az egyenleget nullázza le, túlköltés esetén
        balance = 0;
    }
}
