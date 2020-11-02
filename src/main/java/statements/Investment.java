package statements;

public class Investment {
    private double cost;
    private int fund;
    private boolean active;
    private int interestRate;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        active = true;
        cost = 0.003;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days){
        return fund * interestRate / 100.0 * days / 365.0;
    }
    public double close(int days){
        var sum = active ? (fund + getYield(days)) * (1-cost) : 0;
        active = false;
        return sum;

    }
}
