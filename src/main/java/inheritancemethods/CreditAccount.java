package inheritancemethods;

public class CreditAccount extends DebitAccount {
    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        if (super.transaction(amount)) {
            return true;
        }

        long sumOfCost = amount + super.costOfTransaction(amount);
        if (sumOfCost < super.getBalance() + overdraftLimit) {
            overdraftLimit -= sumOfCost - super.getBalance();
            super.balanceToZero();
            return true;
        }

        return false;
    }
}
