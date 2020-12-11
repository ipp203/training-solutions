package ioreadstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<BankAccount> accountList = new ArrayList<>();

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
        for (String line : lines) {
            String[] data = line.split(";");
            accountList.add(new BankAccount(data[0], data[1], Integer.parseInt(data[2])));
        }
    }

    public void makeTransactions(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
        for (String line : lines) {
            String[] data = line.split(";");
            findAccountbyNumber(data[0]).setBalance(Integer.parseInt(data[1]));
        }
    }

    private BankAccount findAccountbyNumber(String number) {
        for (BankAccount account : accountList) {
            if (account.getAccountNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }
}
