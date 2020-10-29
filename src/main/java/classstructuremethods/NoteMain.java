package classstructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        Scanner scn = new Scanner(System.in);

        System.out.println("What's your name?");
        note.setName(scn.nextLine());
        System.out.println("What's your topic?");
        note.setTopic(scn.nextLine());
        System.out.println("Write the text here!");
        note.setText(scn.nextLine());

        System.out.println("This is your note:");
        System.out.println(note.getNoteText());
    }
}
