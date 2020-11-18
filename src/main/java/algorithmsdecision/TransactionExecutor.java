package algorithmsdecision;

import java.util.List;

public class TransactionExecutor {

    private BankAccount getBankAccountByAccountNumber(List<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        BankAccount account;
        for (Transaction transaction : transactions) {
            account = getBankAccountByAccountNumber(accounts, transaction.getAccountNumber());
            if (account != null) {
                if (transaction.isDebit()) {
                    if (account.withdraw(transaction.getAmount())) {
                        transaction.setStatus(TransactionStatus.SUCCEEDED);
                    } else {
                        transaction.setStatus(TransactionStatus.PENDING);
                    }
                }
                if (transaction.isCredit()) {
                    if (account.deposit(transaction.getAmount())) {
                        transaction.setStatus(TransactionStatus.SUCCEEDED);
                    } else {
                        transaction.setStatus(TransactionStatus.PENDING);
                    }
                }
            }
        }
    }
}
