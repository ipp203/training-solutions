package algorithmssum.transactions;

public class Transaction {
    private String accountNumber;
    private int amount;
    private TransactionOperation transactionOperation;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionOperation = transactionOperation;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCredit() {
        return transactionOperation == TransactionOperation.CREDIT;
    }

    public boolean isDebit() {
        return transactionOperation == TransactionOperation.DEBIT;
    }
}
