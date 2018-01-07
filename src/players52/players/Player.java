package players52.players;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import players52.launch.Main;
import players52.music.PlayingMP3;

import java.io.File;
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

    private String song1 = "Please load song";
    void setSong(String song) throws NullPointerException{
        if (song == null) throw new NullPointerException();
        setMP3File(new File(song));
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
     * @param suStage - для діалогового вікна відкриття файлу
     */

    Pane suRoot;
    private Stage suStage;
    private List<Button> buttons = new ArrayList<>();

    public void show(Pane root, Stage suStage) {
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

        PLAY.setOnMouseClicked(event -> playSong());
//--------------------------------------------------
//----------------- STOP button --------------------
//--------------------------------------------------
        STOP.setOnMouseClicked(event -> stopSongs());
//--------------------------------------------------
//-------------- CHANGE SONG button ----------------
//--------------------------------------------------
        CHANGE.setOnMouseClicked(event -> showSetSongEvent());
//--------------------------------------------------
//----------------- EXIT button --------------------
//--------------------------------------------------
        EXIT.setOnMouseClicked(event -> {
            suRoot.getChildren().removeAll();
            System.exit(0);
        });
    }

    /**
     * File mp3File
     * using setter setMP3File, which set and
     *  - mp3File
     * and
     *  - song1
     */

    private File mp3File;

    private void setMP3File(File file){
        if (file.exists()){
            this.mp3File = file;
            this.song1 = file.getName();
        }
    }

    /**
     * PLAY
     * викликається абстрактним методом playSong() з класів - нащадків
     */
    private Text textSong;
    private MediaPlayer mediaPlayer;
    private static PlayingMP3 playingMP3 = new PlayingMP3();

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

            //MP3
                if (!mediaPlayer.isMute()) mediaPlayer.stop();
            playingMP3.setFileMP3(mp3File);
            mediaPlayer = playingMP3.playFile();
            mediaPlayer.play();
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
        if (mediaPlayer != null && !mediaPlayer.isMute()) mediaPlayer.stop();
    }
    /**
     * CHANGE
     */
    private TextField textField = new TextField();

    private void showSetSongEvent(){
        Button setSongButton = new Button("Set song"); //-- SET SONG BUTTON
        setSongButton.setLayoutX(20);
        setSongButton.setLayoutY(50);

        Button setBackButton = new Button("Back"); //-- BACK BUTTON
        setBackButton.setLayoutX(20);
        setBackButton.setLayoutY(80);

        Button openButton = new Button("Open"); //-- OPEN BUTTON
        openButton.setLayoutX(20);
        openButton.setLayoutY(110);


//        TextField textField = new TextField();
        textField.setLayoutX(110);
        textField.setLayoutY(50);
        for (Button b:
             buttons) {
            b.setDisable(true);
        }
//---------------------------------------------------------
//------------------- SET SONG BUTTON ---------------------
//---------------------------------------------------------
        setSongButton.setOnMouseClicked(event -> {
            setSong(textField.getText());
            suRoot.getChildren().removeAll(textField, setSongButton, setBackButton, openButton);
            for (Button b:
                    buttons) {
                b.setDisable(false);
            }
            playSong();
        });

//---------------------------------------------------------
//--------------------- BACK BUTTON -----------------------
//---------------------------------------------------------

        setBackButton.setOnMouseClicked(event -> {
            suRoot.getChildren().removeAll(textField, setSongButton, setBackButton);
            for (Button b:
                    buttons) {
                b.setDisable(false);
            }        });


//---------------------------------------------------------
//--------------------- OPEN BUTTON -----------------------
//---------------------------------------------------------
        openButton.setOnMouseClicked(event -> {
            openFile();

//            suRoot.getChildren().removeAll(textField, setSongButton, setBackButton);
//            for (Button b:
//                    buttons) {
//                b.setDisable(false);
//            }
        });

        suRoot.getChildren().addAll(textField, setSongButton, setBackButton, openButton);
    }

    private void openFile(){
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("MP3 files (*.mp3)", "*.mp3");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        textField.setText(fileChooser.showOpenDialog(suStage).toString());//Указываем текущую сцену CodeNote.mainStage
//        setMP3File(fileChooser.showOpenDialog(suStage));//Указываем текущую сцену CodeNote.mainStage
//        File file = fileChooser.showOpenDialog(CodeNote.mainStage);//Указываем текущую сцену CodeNote.mainStage
        if (mp3File != null) {
            //Open
            System.out.println("Процесс открытия файла");
        }
    }


    public abstract void playSong();

}
