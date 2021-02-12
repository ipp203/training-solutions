package week15.d05;

public class Country implements Comparable<Country> {
    private String name;
    private int casesSum;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getCasesSum() {
        return casesSum;
    }

    public int getPopulation() {
        return population;
    }

    public int incCasesSum(int caseNumb) {
        return casesSum += caseNumb;
    }

    public double getRate() {
        return (double) casesSum / population;
    }

    @Override
    public int compareTo(Country o) {
        return Double.compare(this.getRate(), o.getRate());
    }

    @Override
    public String toString() {
        return name + ' ' + (double) casesSum / population;
    }
}
