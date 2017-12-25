package players52.players;

import javafx.scene.layout.Pane;

public class Player4 extends ExtraPlayer {

    public Player4(int price) {
        super(price);
    }

    @Override
    public void playAllSongs() {
        playSongs(playList);
    }

    public void playSong() {
        setSong(playList.get(playList.size() - 1));
        playSongs();
    }

}