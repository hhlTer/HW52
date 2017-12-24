package players52.players;

public class Player4 extends ExtraPlayer {

    public Player4(int price) {
        super(price);
    }
    public void playSong() {
        playSongs(playList.get(playList.size() - 1));
    }
}