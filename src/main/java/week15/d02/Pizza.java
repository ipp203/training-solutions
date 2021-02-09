package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;


public class Pizza {

    private List<Courier> pizzas = new ArrayList<>();
    private Courier courier;
    private Map<LocalDate, Integer> days = new HashMap<>();

    public int getNumberOfOrders(){
        return pizzas.size();
    }

    public void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }
    }

    private void processOneLine(String oneLine) {
        if (oneLine.contains(".")) {//date

            courier = Courier.createByDateString(oneLine);
            days.put(courier.getDate(), 0);

        } else if (oneLine.contains(" ")) {//address and time

            String[] parts = oneLine.split(" ");
            courier.setAddress(parts);
            courier.setTime(parts[parts.length - 1]);
            addCourierToPizzas(courier);

            courier = Courier.createWithDate(courier.getDate());
            days.put(courier.getDate(), days.get(courier.getDate()) + 1);

        } else {//id
            courier.setId(oneLine);
        }
    }

    private void addCourierToPizzas(Courier courier) {
        if (courier != null) {
            pizzas.add(courier);
        }
    }

    public LocalDate getMinOrderDay() {
        int min = Integer.MAX_VALUE;
        LocalDate result = null;
        for (Map.Entry<LocalDate, Integer> entry : days.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public Optional<Courier> getOrderByTime(LocalDateTime time) {
        for (Courier c : pizzas) {
            if (LocalDateTime.of(c.getDate(), c.getTime()).equals(time)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    public Map<String, Integer> getCourierStatistics() {
        return getMost(Courier::getId);
    }

    public Address getAddressWithMostPizzas() {
        Map<Address, Integer> stat = getMost(Courier::getAddress);

        Optional<Map.Entry<Address,Integer>> result
                = stat.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue));

        if (result.isPresent()){
            return result.get().getKey();
        }
        return null;
    }

    private <T> Map<T, Integer> getMost(Function<Courier, T> f) {
        Map<T, Integer> result = new HashMap<>();
        for (Courier c : pizzas) {
            T key = f.apply(c);
            if (!result.containsKey(key)) {
                result.put(key, 0);
            }
            result.put(key, result.get(key) + 1);
        }
        return result;

    }

    public static void main(String[] args) {
        Pizza p = new Pizza();
        p.readFile(Path.of("src/test/resources/week15/d02/orders.txt"));
        System.out.println(p.pizzas.size());
        System.out.println(p.getMinOrderDay());
        Optional<Courier> oc = p.getOrderByTime(LocalDateTime.of(2020, 12, 01, 16, 33));
        oc.ifPresent(System.out::println);
        System.out.println(p.getCourierStatistics());

        System.out.println(p.getAddressWithMostPizzas());
    }
}
