package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scn = new Scanner(System.in);

        System.out.println("What is your favourite song?");
        System.out.println("Band?");
        song.band = scn.nextLine();
        System.out.println("Title?");
        song.title = scn.nextLine();
        System.out.println("Length of song (min)?");
        song.length = scn.nextInt();

        System.out.println("Your favourite song is:");
        System.out.println(song.band + ", " + song.title + " (" + song.length +" min)" );

    }
}
