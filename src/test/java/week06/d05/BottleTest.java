package week06.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void of() {
        Bottle petBottle = Bottle.of(BottleType.PET_BOTTLE);
        Bottle glassBottle = Bottle.of(BottleType.GLASS_BOTTLE);

        assertEquals(BottleType.PET_BOTTLE, petBottle.getType());
        assertEquals(BottleType.GLASS_BOTTLE, glassBottle.getType());
    }

    @Test
    void fill() {
        //Given
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        //When
        bottle.fill(250);
        bottle.fill(340);

        //Then
        assertEquals(590, bottle.getFilledUntil());
    }

    @Test
    void fillMoreThanMaximum() {
        //Given
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        //When
        bottle.fill(650);

        //Then
        assertThrows(IllegalStateException.class, () -> {
            bottle.fill(540);
        });
        assertEquals(1000, bottle.getFilledUntil());

    }
}