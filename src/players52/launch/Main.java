package players52.launch;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import players52.players.*;

import java.awt.*;
import java.util.List;

public class Main extends Application{
    private final int HEIGHT = 800;
    private final int WIDTH = 600;

    public static void main(String[] args) {
        launch(args);


        Player player1 = new Player1(200);
        System.out.println("Player 1");
        player1.playSong();

        Player player2 = new Player2(50);
        System.out.println("Player 2");
        player2.playSong();

        ExtraPlayer player3 = new Player3(500);
        System.out.println("Player 3");
        player3.playSong();
        System.out.println("\n   Play all song:");
        player3.playAllSongs();

        ExtraPlayer player4 = new Player4(700);
        System.out.println("Player 4");
        player4.playSong();
        System.out.println("\n   Play all song:");
        player4.playAllSongs();

        ExtraPlayer player5 = new Player5(1000);
        System.out.println("Player 5");
        player5.playSong();
        System.out.println("\n   Play all song:");
        player5.playAllSongs();

        Player6 player6 = new Player6(1500);
        System.out.println("Player 6");
        player6.playSong();
        System.out.println("\n   Play all song:");
        player6.playAllSongs();
        System.out.println("\n   Play all shuffle song:");
        player6.shuffle();
        player6.playAllSongs();



    }
    @Override
    public void start(Stage primaryStage) {

        windowProperty(primaryStage);
        Pane root = new Pane();
        Player player = choosePlayer(root);
//        player.show(root);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void windowProperty(Stage primaryStage){
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setMinWidth(WIDTH);
    }

    private Player choosePlayer(Pane root){
        Player player = new Player1(100);

/*-----------------------------------------------------
 * --------------------- Buttons ----------------------
 * ----------------------------------------------------
 */
        Button button = new Button("Ok");
        button.setLayoutX(10);
        button.setLayoutY(10);

/*-----------------------------------------------------
 * ---------------------- Case ------------------------
 * ----------------------------------------------------
 */
        ToggleGroup group = new ToggleGroup();
        RadioButton[] radioButtons = new RadioButton[6];
        for (int i = 0; i < 6; i++) {
            radioButtons[i] = new RadioButton("Player " + (i+1));
            radioButtons[i].setLayoutX(100);
            radioButtons[i].setLayoutY(i*20 + 10);
            radioButtons[i].setToggleGroup(group);
        }
        radioButtons[0].fire();

/*-----------------------------------------------------
 * ---------------------- Text ------------------------
 * ----------------------------------------------------
 */
        Text text = new Text();
        text.setTranslateX(100);
        text.setTranslateY(100);

        button.setOnMouseClicked(event -> {
            if (group.getSelectedToggle() != null) {
                RadioButton butt = (RadioButton) group.getSelectedToggle();
                if (butt.getText().equals("Player 1")) {
                    new Player1(150).show(root);
                }
            }
        });


        root.getChildren().addAll(radioButtons);
        root.getChildren().addAll(button, text);
        return player;
    }
}
