package players52.players;

import java.util.Collections;

public class Player6 extends ExtraPlayer {

        public Player6(int price){
            super(price);
        }
        public void playSong() {
            playSongs(playList.get(0));
        }
        public void shuffle(){
            Collections.shuffle(playList);
            }
}


