package controliteration.pi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiGeneratorTest {
    @Test
    void createTest(){
        //Given
        PiGenerator piGenerator = new PiGenerator();
        //When
        String s = piGenerator.getPoem();
        //Then
        assertEquals("3.141592653589793238462643383279",piGenerator.piFromPoem(s));
    }
}
