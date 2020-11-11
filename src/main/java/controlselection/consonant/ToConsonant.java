package controlselection.consonant;

public class ToConsonant {
    public char charToConsonant(char c){
        switch (c){
            case 'a','e','i','o','u','A','E','I','O','U':
                return (char)(((int) c)+1);
            default:
                return c;
        }
    }
}
