package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {
    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int minAmount) {
        int counter = 0;
        for (BankAccount item : bankAccounts) {
            if (item.getBalance() > minAmount) {
                counter++;
            }
        }
        return counter;
    }
}
