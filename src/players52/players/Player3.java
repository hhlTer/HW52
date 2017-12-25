package players52.players;

public class Player3 extends ExtraPlayer {
    public Player3(int price){
        super(price);
    }
    public void playSong() {
        setSong(playList.get(0));
        playSongs();
    }
    public void playAllSongs(){
        playSongs(playList);
    }


}
