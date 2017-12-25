package players52.players;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
/**
 * skill SHUFFLE added
 */
public abstract class ExtraPlusPlayer extends ExtraPlayer{
    ExtraPlusPlayer(int price) {
        super(price);
    }

    private final Button SHUFFLE = new Button("SHUFFLE");
    @Override
    void initButton() {
        super.initButton();
        SHUFFLE.setLayoutX(450);
        SHUFFLE.setLayoutY(20);
        suRoot.getChildren().add(SHUFFLE);
    }
    public void show(Pane root){
        super.show(root);
        SHUFFLE.setOnMouseClicked(event -> {
            shuffle();
        });
    }

    public abstract void shuffle();
}
