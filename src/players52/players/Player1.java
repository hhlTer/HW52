package players52.players;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Player1 extends Player {
    /**
     * Button[] buttons
     * масив базових кнопок (PLAY, STOP, CHANGE SONG, EXIT)
     *
     * ---- перенесу в суперклас
     *
     */
    private Button[] buttons;

    public Player1(int price){
        super(price);
    }

    /**
     * Щоб працювати з suRoot і не передавати кожного разу по всіх методах -
     * зберігаю його, як поле в супер класі -Player-
     */
    @Override
    public void show(Pane root) {
        super.suRoot = root;
        root.getChildren().clear();
        buttons = playButton();
        root.getChildren().addAll(buttons);
//--------------------------------------------------
//----------------- PLAY button --------------------
//--------------------------------------------------

        buttons[0].setOnMouseClicked(event -> {
            playSongEvent();
        });
//--------------------------------------------------
//----------------- STOP button --------------------
//--------------------------------------------------
        buttons[1].setOnMouseClicked(event -> {
            stopSongs();
        });
//--------------------------------------------------
//----------------- SET SONG button ----------------
//--------------------------------------------------
        buttons[2].setOnMouseClicked(event -> {
            showSetSongEvent();
        });
//--------------------------------------------------
//----------------- STOP button --------------------
//--------------------------------------------------
        buttons[3].setOnMouseClicked(event -> {
            root.getChildren().removeAll();
            System.exit(0);
        });
    }

    /**
     * playSongEvent - проміжний метод між PLAY кнопкою,
     * та викликом методу програвання пісні -playSongs-
     * який може викликатись іншими методами
     */
    private void playSongEvent(){
        playSong();
    }
    public void playSong() {
        super.playSongs(song1);
    }

    /**
     * Зміна пісні
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

}
