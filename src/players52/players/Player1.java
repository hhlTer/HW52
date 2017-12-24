package players52.players;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Player1 extends Player {
    public Player1(int price){
        super(price);
    }
    public void playSong() {
        playSongs(song1);
    }

    @Override
    public void show(Pane root) {
        super.root = root;
        root.getChildren().clear();
        Button[] buttons = playButton();
        root.getChildren().addAll(buttons);

        buttons[0].setOnMouseClicked(event -> {
            playSong();
        });
        buttons[1].setOnMouseClicked(event -> {
            stopSongs();
        });
        buttons[2].setOnMouseClicked(event -> {
            showSetSongDialog(root);
        });
    }

    private void showSetSongDialog(Pane root){
        Button setSongButton = new Button("Set song");
        setSongButton.setLayoutX(20);
        setSongButton.setLayoutY(50);
        TextField textField = new TextField();
        textField.setLayoutX(90);
        textField.setLayoutY(50);
        setSongButton.setOnMouseClicked(event -> {
            setSong(textField.getText());
            root.getChildren().removeAll(textField,setSongButton);
        });
        root.getChildren().addAll(textField,setSongButton);
    }

}
