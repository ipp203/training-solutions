package introjunit;

//JUnit5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest{
    @Test
    void testCreate(){

        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String s = gentleman.sayHello("John Doe");

        //Then
        assertEquals("Hello John Doe",s);
    }

}

//JUnit4
/*import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {
    @Test
    public void testCreate(){
        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String greeting = gentleman.sayHello("John Doe");
        String greetingNull = gentleman.sayHello(null);

        //Then
        assertThat(greeting, equalTo("Hello John Doe"));
        assertThat(greetingNull, equalTo("Hello Anonymus"));
    }
}*/
