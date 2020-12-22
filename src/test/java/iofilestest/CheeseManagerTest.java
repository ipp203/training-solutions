package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseManagerTest {

    @TempDir
    public Path folder;

    @Test
    void testCheeseManager() {
        //Given
        CheeseManager cm = new CheeseManager();
        List<Cheese> cheeseList = new ArrayList<>();
        cheeseList.add(new Cheese("Pannonia", 0.0));
        cheeseList.add(new Cheese("Trappista", 1.5));
        cheeseList.add(new Cheese("Gouda", 0.8));
        cheeseList.add(new Cheese("Ementali", 2.2));

        System.out.println(folder.resolve("cheese.dat"));

        //When
        cm.saveToFile(folder.resolve("cheese.dat"), cheeseList);
        Cheese gouda = cm.findCheese(folder.resolve("cheese.dat"), "Gouda");

        //Then
        assertEquals("Gouda", gouda.getName());
        assertEquals(0.8, gouda.getLactose(), 0.000001);
    }

}