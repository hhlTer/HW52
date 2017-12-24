package players52.players;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;

public abstract class Player {
    Pane root;

    /**
     * Constructor set private final field -price-
     * also exist getter for -price-
     */
    private final int price;
    Player(int price) {
        this.price = price;
    }
    public int getPrice(){return price;};

    /**
     * one song
     * have setter, and auto initialization field -song1-
     */
    String song1 = "One song";
    public void setSong(String song){
        song1 = song;
    }

    /**
     * Play List have initialization
     * but not have setter, so have parameter final
     */
    final List<String> playList = Arrays.asList(
            "First song",
            "Second song",
            "Third song",
            "Fourth song",
            "Fifth song"
    );

    private Text textSong;
    void playSongs(String song){
        textSong = new Text("Playing: " + song);
        textSong.setLayoutX(100);
        textSong.setLayoutY(150);
        root.getChildren().setAll(textSong);
    }
    void stopSongs(){
        root.getChildren().removeAll(textSong);
    }

    /**
     * Base players have play button
     */
    Button[] playButton(){
        Button[] buttons = {
            new Button("Play"),
            new Button("Stop"),
            new Button("Set song")
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setLayoutY(20);
            buttons[i].setLayoutX(i*70 + 20);
        }
        return buttons;
    }

    public abstract void playSong();
    public abstract void show(Pane root);
}
