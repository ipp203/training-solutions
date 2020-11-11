package controlselection.greetings;

public class Greetings {
    public String greetingsByTime(int hour, int minute) {

        if (hour >= 20 || hour < 5) {
            return "Jó éjt!";
        } else if (hour >= 5 && hour < 9) {
            return "Jó reggelt!";
        } else if (hour >= 9 && hour < 18) {
            return  "Jó napot!";
        } else if (hour == 18 && minute < 30) {
            return "Jó napot!";
        } else {
            return "Jó estét!";
        }
    }
}
