package algorithmsdecision;

import java.util.List;

public class BankAccountDecisionMaker {
    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int amount) {
        for (BankAccount account : accounts) {
            if (account.getBalance() > amount) {
                return true;
            }
        }
        return false;
    }
}
