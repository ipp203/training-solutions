package introinheritance;

public class BigBoss extends Boss {
    private double bonus;

    public BigBoss(String name, String address, double salary, int numberOfEmployee, double bonus) {
        super(name, address, salary, numberOfEmployee);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public int getNumberOfEmployees() {
        return super.getNumberOfEmployees();
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }


}
