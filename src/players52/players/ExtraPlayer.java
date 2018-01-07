package players52.players;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

/**
 * skill PLAY ALL added
 */
public abstract class ExtraPlayer extends Player{

    ExtraPlayer(int price) {
        super(price);
    }
    /**
     * play all from playList
     * Using playSongs(String[] songs);
     *
     * play playList
     * using playSongs(String song);
     */
    public abstract void playAllSongs();

    private Button PLAY_ALL = new Button("PLAY ALL SONGS");
    @Override
    void initButton() {
        super.initButton();
        PLAY_ALL.setLayoutX(315);
        PLAY_ALL.setLayoutY(20);
        CHANGE.setDisable(true);
        suRoot.getChildren().add(PLAY_ALL);
    }

    public void show(Pane root){
        super.show(root, new Stage());
        PLAY_ALL.setOnMouseClicked(event -> playAllSongs());
    }

    void playSongs(List<String> playList){
        String s = "";
        for (String song:
                playList) {
            s = s + song + " ";
        }
        setSong(s);
        playSongs();
    }

}
