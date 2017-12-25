package players52.launch;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import players52.players.*;

public class Main extends Application{
    private final int MAIN_HEIGHT = 800;
    private final int MAIN_WIDTH = 600;
    private final int HEIGHT = 200;
    private final int WIDTH = 300;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

        windowProperty(primaryStage);
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
/*
 *  launch secondary window ---- Player ------
 */
        button.setOnAction(event -> {
            Pane secondPane = new Pane();
            if (group.getSelectedToggle() != null) {
                RadioButton butt = (RadioButton) group.getSelectedToggle();
                switch (Integer.parseInt(butt.getText().substring(butt.getText().length() - 1))){
                    case 1:
                        new Player1(150).show(secondPane);
                        break;
                    case 2:
                        new Player2(50).show(secondPane);
                        break;
                    case 3:
                        new Player3(350).show(secondPane);
                        break;
                    case 4:
                        new Player4(750).show(secondPane);
                        break;
                    case 5:
                        new Player5(800).show(secondPane);
                        break;
                    case 6:
                        new Player6(1000).show(secondPane);
                        break;
                }
            }

            Scene secondScene = new Scene(secondPane, MAIN_WIDTH,MAIN_HEIGHT);
            Stage newWindow = new Stage();
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.setScene(secondScene);
            newWindow.setX(primaryStage.getX() + 200);
            newWindow.show();
        });

        Pane root = new Pane();
        root.getChildren().addAll(radioButtons);
        root.getChildren().addAll(button, text);

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

    private void choosePlayer(Pane root){
    }
}
