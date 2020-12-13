package week05.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeLetterTest {
    @Test
    void changeVowelsTest() {
        ChangeLetter cl = new ChangeLetter();
        assertEquals("**********", cl.changeVowels("aeiouAEIOU"));
        assertEquals("   L*bd*, k*r*sd M*G!  ", cl.changeVowels("   LabdA, keresd MEG!  "));
    }

}