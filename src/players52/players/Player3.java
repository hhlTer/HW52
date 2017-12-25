package players52.players;

import javafx.scene.layout.Pane;

public class Player3 extends ExtraPlayer {
    public Player3(int price){
        super(price);
    }
    public void playSong() {
        playSongs(playList.get(0));
    }

}
