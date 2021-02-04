package week14.d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    @Test
    void testCreateModify() {

        //Given
        ContractCreator cc = new ContractCreator("aa",
                Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));

        //When
        Contract c1 = cc.create("aa1");
        c1.setMonthlyPrice(11,14);
        Integer c1Price12 = c1.getMonthlyPrice(11);

        Contract c2 = cc.create("aa2");
        Integer c2Price12 = c2.getMonthlyPrice(11);

        //Then
        assertEquals(14,c1Price12);
        assertEquals(12,c2Price12);
    }
}