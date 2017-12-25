package players52.players;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.List;

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
    void playSongs(List<String> playList){
        for (String pl:
                playList) {
            setSong(pl);
            playSongs();
        }
    }
    public abstract void playAllSongs();

    private Button PLAY_ALL = new Button("PLAY ALL SONGS");
    @Override
    void initButton() {
        super.initButton();
        PLAY_ALL.setLayoutX(315);
        PLAY_ALL.setLayoutY(20);
        suRoot.getChildren().add(PLAY_ALL);
    }

    public void show(Pane root){
        super.show(root);
        PLAY_ALL.setOnMouseClicked(event -> {
            String s = "";
            for (String song:
                 playList) {
                System.out.println(song);
                s += song + " ";
            }
            setSong(s);
            playSongs();

        });
    }

}
