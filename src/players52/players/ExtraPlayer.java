package players52.players;

public abstract class ExtraPlayer extends Player{

    ExtraPlayer(int price) {
        super(price);
    }
    public void playAllSongs(){
        playSongs(playList);
    }
}
