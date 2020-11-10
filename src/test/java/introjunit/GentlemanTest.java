package introjunit;

import org.junit.Test;

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
}
