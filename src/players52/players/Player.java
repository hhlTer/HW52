package players52.players;

import java.util.Arrays;
import java.util.List;

public abstract class Player {
    private final int price;
    Player(int price) {
        this.price = price;
    }
    public int getPrice(){return price;};

    String song1 = "One song";
    public void setSong(String song){
        song1 = song;
    }
    List<String> playList = Arrays.asList(
            "First song",
            "Second song",
            "Third song",
            "Four song",
            "Fiftyes song"
    );

    void playSongs(List<String> playList){
        for (String pl:
             playList) {
            System.out.println("Playing: " + pl);
        }
    }
    void playSongs(String song){
        System.out.println("Playing: " + song);
    }

    public abstract void playSong();
}
