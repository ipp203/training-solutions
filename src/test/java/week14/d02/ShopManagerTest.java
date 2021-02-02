package week14.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopManagerTest {
    ShopManager shopManager;


    @BeforeEach
    void init() {
        shopManager = new ShopManager();
        BufferedReader reader = new BufferedReader(
                new StringReader(
                        "BK123-1211: bread(200),soda(120),carrot(320)\n" +
                                "RA22-112: tomato(300),sugar(100),salt(100),choclate(200)\n" +
                                "BK123-111: beer(300),chips(250),potato(300)\n" +
                                "RA22-1145: peas(300),yoghurt(200),milk(200),chicken(1300),bread(200)\n" +
                                "SM123-11: pork_belly(1200),ketchup(800),corn(250),alufoil(300)\n" +
                                "GT23-011: bread(200),tomato(300),salt(100)\n" +
                                "RA22-01112: salami(300),sour_cream(250)\n" +
                                "SM123-120: dogfood(900),potato(300),tomato(200),chicken(1300),fish(3000),tuna(1200),pasta(200)\n" +
                                "BK123-567: corn(200),jam(800),Nutella(1200),cereal(1200)"
                )
        );
        shopManager.readFile(reader);
    }

    @Test
    void getPriceByIdTest() {
        int result = shopManager.getPriceById("1211");
        assertEquals(640, result);
    }

    @Test
    void getPriceByShopperTest() {
        int result = shopManager.getPriceByShopper("BK123");
        assertEquals(4890, result);
    }

    @Test
    void sortedByTest() {
        List<Product> result = shopManager.sortedBy("BK123", "1211", Comparator.comparing(Product::getName));
        assertEquals("bread", result.get(0).getName());

        result = shopManager.sortedBy("BK123", "1211", Comparator.comparing(Product::getPrice));
        assertEquals(120, result.get(0).getPrice());
    }

    @Test
    void numberProductTest() {
        int result = shopManager.numberProduct("bread");
        assertEquals(3, result);
    }

    @Test
    void statisticsTest() {
        Map<String, Integer> result = shopManager.statistics();
        assertEquals(2, result.get("chicken"));

        System.out.println(result);
    }
}