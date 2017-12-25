package players52.players;

import javafx.scene.layout.Pane;

import java.util.Collections;

public class Player6 extends ExtraPlayer {

        public Player6(int price){
            super(price);
        }

    @Override
    public void playAllSongs() {
        playSongs(playList);
    }

    public void playSong() {
            setSong(playList.get(0));
            playSongs();
        }

    public void shuffle(){
            Collections.shuffle(playList);
            }

}


