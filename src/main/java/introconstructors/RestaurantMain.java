package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Csulok csarda",12);
        System.out.println(restaurant.getName() + " - helyek szama: " + restaurant.getCapacity());
        System.out.println("Etlap:");
        for (String meal: restaurant.getMenu()) {
            System.out.println(meal);
            
        }
    }
}
