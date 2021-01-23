package lambdaintro;

import java.text.Collator;
import java.util.*;

public class BankAccounts {
    private List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> bankAccountList) {
        accounts = new ArrayList<>(bankAccountList);
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> result = new ArrayList<>(accounts);
        result.sort(Comparator.naturalOrder());
        return result;
    }


    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> result = new ArrayList<>(accounts);
        result.sort((a1, a2) -> Double.compare(Math.abs(a1.getBalance()), Math.abs(a2.getBalance())));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> result = new ArrayList<>(accounts);

        result.sort((a1,a2) -> {
            if(a1.getBalance()==a2.getBalance()){
                return 0;
            }
            if(a1.getBalance()>a2.getBalance()){
                return -1;
            }
            return 1;
        });

        return result;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber(){
        List<BankAccount> result = new ArrayList<>(accounts);
        result.sort(BankAccounts :: complexCompare);
        return result;
    }

    private static int complexCompare(BankAccount a1, BankAccount a2){
        if (a1.getNameOfOwner() == null){
            return -1;
        }
        if (a2.getNameOfOwner() == null){
            return 1;
        }
        if (a1.getNameOfOwner().equals(a2.getNameOfOwner())){
           return a1.getAccountNumber().compareTo(a2.getAccountNumber());
        }
        Collator collator = Collator.getInstance(new Locale("hu","hu"));

        return collator.compare(a1.getNameOfOwner(),a2.getNameOfOwner());

    }
}
