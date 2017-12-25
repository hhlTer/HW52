package players52.players;

import javafx.scene.layout.Pane;

import java.util.Collections;

public class Player5 extends ExtraPlayer {
    public Player5(int price){
        super(price);
    }
    public void playSong() {
        setSong(playList.get(0));
        playSongs();
    }

    @Override
    public void playAllSongs(){
        Collections.reverse(playList);
        playSongs(playList);
    }
}