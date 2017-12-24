package players52.players;

import javafx.scene.control.Button;
import java.util.List;

public abstract class ExtraPlayer extends Player{

    ExtraPlayer(int price) {
        super(price);
    }
    /**
     * play all from playList
     * Using playSongs(String[] songs);
     */
    /**
     * play playList
     * using playSongs(String song);
     */
    void playSongs(List<String> playList){
        for (String pl:
                playList) {
            playSongs(pl);
        }
    }
    public void playAllSongs(){
        playSongs(playList);
    }

    Button playAllButton(){
        Button button = new Button("Play all songs");
        button.setScaleX(10);
        button.setScaleY(40);
        return button;
    }

}
