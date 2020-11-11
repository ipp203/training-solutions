package controlselection.accents;

public class WithoutAccents {
    public char charWithoutAccents(char c) {
        char returnChar;
        switch (c) {
            case 'á':
                returnChar = 'a';
                break;
            case 'Á':
                returnChar = 'A';
                break;
            case 'é':
                returnChar = 'e';
                break;
            case 'É':
                returnChar = 'E';
                break;
            case 'í':
                returnChar = 'i';
                break;
            case 'Í':
                returnChar = 'I';
                break;
            case 'ó', 'ö', 'ő':
                returnChar = 'o';
                break;
            case 'Ó', 'Ö', 'Ő':
                returnChar = 'O';
                break;
            case 'ú', 'ü', 'ű':
                returnChar = 'u';
                break;
            case 'Ú', 'Ü', 'Ű':
                returnChar = 'U';
                break;
            default:
                returnChar = c;
        }
        return returnChar;
    }
}
