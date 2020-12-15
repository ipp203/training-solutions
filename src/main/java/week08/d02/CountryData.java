package week08.d02;

public class CountryData {
    private String name;
    private int population;
    private int flagcolors;
    private int neighbours;

    public CountryData(String name, int population, int flagcolors, int neighbours) {
        this.name = name;
        this.population = population;
        this.flagcolors = flagcolors;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getFlagcolors() {
        return flagcolors;
    }

    public int getNeighbours() {
        return neighbours;
    }
}
