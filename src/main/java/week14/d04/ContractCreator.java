package week14.d04;

import java.util.List;

public class ContractCreator {
    private Contract contract;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        contract = new Contract(client, monthlyPrices);
    }

    public Contract create(String name){
        return contract.copyContract(name);
    }
}
