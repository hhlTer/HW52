package players52.players;

public class Player3 extends ExtraPlayer {
    public Player3(int price){
        super(price);
    }
    public void playSong() {
        playSongs(playList.get(0));
    }
}
