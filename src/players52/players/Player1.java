package players52.players;

import javafx.scene.control.Button;

public class Player1 extends Player {

    private Button[] buttons;

    public Player1(int price){
        super(price);
    }

    public void playSong() {
        super.playSongs(song1);
    }



}
