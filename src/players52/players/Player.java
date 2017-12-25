package players52.players;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.List;

public abstract class Player {

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
     *
     * song1 - пісня, яка програється
     * setSong(String song) - сеттер, використовується в методі showSetSongEvent
     *
     */

    String song1 = "One song";
    private void setSong(String song){
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



    /**
     * Base players have PLAY button
     *                   STOP button
     *                   CHANGE song button
     *                   EXIT
     */
    private Button[] playButton(){
        Button[] buttons = {
            new Button("PLAY"),
            new Button("STOP"),
            new Button("Change song"),
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

    /**
     * Щоб працювати з suRoot і не передавати кожного разу по всіх методах -
     * зберігаю його, як поле в супер класі -Player-
     */
    Pane suRoot;
    Button[] buttons;
    public void show(Pane root) {
        this.suRoot = root;
        root.getChildren().clear();
        buttons = playButton();
        root.getChildren().addAll(buttons);
//--------------------------------------------------
//----------------- PLAY button --------------------
//--------------------------------------------------

        buttons[0].setOnMouseClicked(event -> {
            playSong();
        });
//--------------------------------------------------
//----------------- STOP button --------------------
//--------------------------------------------------
        buttons[1].setOnMouseClicked(event -> {
            stopSongs();
        });
//--------------------------------------------------
//-------------- CHANGE SONG button ----------------
//--------------------------------------------------
        buttons[2].setOnMouseClicked(event -> {
            showSetSongEvent();
        });
//--------------------------------------------------
//----------------- EXIT button --------------------
//--------------------------------------------------
        buttons[3].setOnMouseClicked(event -> {
            root.getChildren().removeAll();
            System.exit(0);
        });
    }

    /**
     * PLAY
     * викликається абстрактним методом playSong() з класів - нащадків
     */
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

    /**
     * СТОП - викликається кнопкою STOP, method void show(Pane pane);
     */
    private void stopSongs(){
        suRoot.getChildren().removeAll(textSong);
        textSong = null;
    }
    /**
     * Change
     */
    private void showSetSongEvent(){
        Button setSongButton = new Button("Set song");
        setSongButton.setLayoutX(20);
        setSongButton.setLayoutY(50);
        TextField textField = new TextField();
        textField.setLayoutX(110);
        textField.setLayoutY(50);
        for (int i = 0; i < 3; i++) {
            buttons[i].setDisable(true);
        }

        setSongButton.setOnMouseClicked(event -> {
            setSong(textField.getText());
            suRoot.getChildren().removeAll(textField,setSongButton);
            for (int i = 0; i < 3; i++) {
                buttons[i].setDisable(false);
            }
        });

        suRoot.getChildren().addAll(textField,setSongButton);
    }


    public abstract void playSong();

}
