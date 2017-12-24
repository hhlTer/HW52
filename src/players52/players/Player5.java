package players52.players;

import java.util.Collections;

public class Player5 extends ExtraPlayer {
    public Player5(int price){
        super(price);
    }
    public void playSong() {
        playSongs(playList.get(0));
    }
    @Override
    public void playAllSongs(){
        Collections.reverse(playList);
        playSongs(playList);
    }
}