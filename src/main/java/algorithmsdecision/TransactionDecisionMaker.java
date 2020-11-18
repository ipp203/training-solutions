package algorithmsdecision;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {
    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime stratTime, LocalDateTime endTime, int amount) {
        for (Transaction transaction : transactions) {
            if (transaction.getDateOfTransaction().isAfter(stratTime) &&
                    transaction.getDateOfTransaction().isBefore(endTime) &&
                    transaction.isDebit() &&
                    transaction.getAmount() > amount) {
                return true;
            }
        }
        return false;
    }
}
