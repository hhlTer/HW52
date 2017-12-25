package players52.players;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import players52.launch.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    private String song1 = "Default song";
    void setSong(String song){
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
    private final Button PLAY = new Button("PLAY");
    private final Button STOP = new Button("STOP");
    final Button CHANGE = new Button("CHANGE SONG");
    private final Button EXIT = new Button("EXIT");
    void initButton(){
        addButtonTolist(PLAY, 10, 20);
        addButtonTolist(STOP, 70, 20);
        addButtonTolist(CHANGE, 130, 20);
        addButtonTolist(EXIT, 255, 20);
    }
    private void addButtonTolist(Button button, double x, double y){
        button.setLayoutX(x);
        button.setLayoutY(y);
        buttons.add(button);
    }

    /**
     * Щоб працювати з suRoot і не передавати кожного разу по всіх методах -
     * зберігаю його, як поле в супер класі -Player-
     */
    Pane suRoot;

    private List<Button> buttons = new ArrayList<>();
    public void show(Pane root) {
        this.suRoot = root;
        root.getChildren().clear();
        initButton();
        root.getChildren().addAll(buttons);
        eventButton();
    }
    private void eventButton() {
//--------------------------------------------------
//----------------- PLAY button --------------------
//--------------------------------------------------

        PLAY.setOnMouseClicked(event -> {
            playSong();
        });
//--------------------------------------------------
//----------------- STOP button --------------------
//--------------------------------------------------
        STOP.setOnMouseClicked(event -> {
            stopSongs();
        });
//--------------------------------------------------
//-------------- CHANGE SONG button ----------------
//--------------------------------------------------
        CHANGE.setOnMouseClicked(event -> {
            showSetSongEvent();
        });
//--------------------------------------------------
//----------------- EXIT button --------------------
//--------------------------------------------------
        EXIT.setOnMouseClicked(event -> {
            suRoot.getChildren().removeAll();
            System.exit(0);
        });
    }

    /**
     * PLAY
     * викликається абстрактним методом playSong() з класів - нащадків
     */
    private Text textSong;
    void playSongs(){
        if (song1 == null) song1 = "ERROR";
        try {
            if (textSong != null) {
                if (textSong.getText().equals(song1))
                    return;
                else suRoot.getChildren().remove(textSong);
            }
            textSong = new Text("Playing: " + song1);
            textSong.setLayoutX(100);
            textSong.setLayoutY(150);
            suRoot.getChildren().add(textSong);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        for (Button b:
             buttons) {
            b.setDisable(true);
        }

        setSongButton.setOnMouseClicked(event -> {
            setSong(textField.getText());
            suRoot.getChildren().removeAll(textField,setSongButton);
            for (Button b:
                    buttons) {
                b.setDisable(false);
            }        });

        suRoot.getChildren().addAll(textField,setSongButton);
    }


    public abstract void playSong();

}
