package players52.players;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.List;

public abstract class Player {

    Pane suRoot;

    /**
     * Constructor set private final field -price-
     * also exist getter for -price-
     */
    private final int price;
    Player(int price) {
        this.price = price;
    }
    public int getPrice(){return price;}

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
        if (textSong != null) {
            if (textSong.getText().equals(song))
            return;
            else suRoot.getChildren().remove(textSong);
        }
        textSong = new Text("Playing: " + song);
        textSong.setLayoutX(100);
        textSong.setLayoutY(150);
        suRoot.getChildren().add(textSong);
    }
    void stopSongs(){
        suRoot.getChildren().removeAll(textSong);
        textSong = null;
    }

    /**
     * Base players have play button
     *                   stop button
     *                   set song button
     */
    Button[] playButton(){
        Button[] buttons = {
            new Button("Play"),
            new Button("Stop"),
            new Button("Set song"),
            new Button("Exit")
        };

        for (int i = 0; i < buttons.length; i++) {
            double a = 10;
            buttons[i].setLayoutY(20);
            if (i > 0) a = buttons[i-1].getLayoutX() + buttons[i-1].getText().length()*14;
            buttons[i].setLayoutX(a);
        }
        return buttons;
    }

    public abstract void playSong();
    public abstract void show(Pane root);
}
