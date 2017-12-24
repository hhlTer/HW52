package players52.launch;

import players52.players.*;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player1(200);
        System.out.println("Player 1");
        player1.playSong();

        Player player2 = new Player2(50);
        System.out.println("Player 2");
        player2.playSong();

        ExtraPlayer player3 = new Player3(500);
        System.out.println("Player 3");
        player3.playSong();
        System.out.println("\n   Play all song:");
        player3.playAllSongs();

        ExtraPlayer player4 = new Player4(700);
        System.out.println("Player 4");
        player4.playSong();
        System.out.println("\n   Play all song:");
        player4.playAllSongs();

        ExtraPlayer player5 = new Player5(1000);
        System.out.println("Player 5");
        player5.playSong();
        System.out.println("\n   Play all song:");
        player5.playAllSongs();

        Player6 player6 = new Player6(1500);
        System.out.println("Player 6");
        player6.playSong();
        System.out.println("\n   Play all song:");
        player6.playAllSongs();
        System.out.println("\n   Play all shuffle song:");
        player6.shuffle();
        player6.playAllSongs();
    }
}
