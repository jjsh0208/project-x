package step2_1.BiodomeFamily07;

import java.util.ArrayList;

public class Player {
    private int volume;
    private int playIndex;

    private  boolean isPlay;
    Player(){
        this.volume =  1;
        this.playIndex = -1;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic(ArrayList<Song> song){
        if (playIndex == song.size() - 1){
            System.out.println("플레이리스트의 노래가 없습니다.");
            return;
        }

        Song s = song.get(++playIndex);
        if (s instanceof AnimalSong){
            if (volume > 5 ) setVolume(1);
            System.out.println("\"" + s.getName() + ", " + s.getPlayingTime() + ", " + s.getMusician() + ", " +
                    ((AnimalSong) s).getAnimal() + "\"" + "재생합니다.") ;
        }
        if (s instanceof ManagerSong){
            System.out.println("\"" + s.getName() + ", " + s.getPlayingTime() + ", " + s.getMusician() + ", " +
                    ((ManagerSong) s).getGenre() + "\"" + "재생합니다.") ;
        }
        isPlay = true;

    }

    public void volumeControl(int volume,ArrayList<Song> song){
        if(!isPlay){
            System.out.println("음악이 재생중이지않습니다.");
            return;
        }
        Song s = song.get(playIndex);
        if (s instanceof AnimalSong && volume > 0 && volume <= 5){
            setVolume(volume);
            System.out.println("볼륨을 "+ volume +"으로 설정합니다.");
            return;
        }
        if (s instanceof ManagerSong && volume > 0 && volume <= 30){
            setVolume(volume);
            System.out.println("볼륨을 "+ volume +"으로 설정합니다.");
            return;
        }
        System.out.println("(동물을 위한 노래는 0 ~ 5) (사람을 위한 노래는 0 ~ 30)");
        System.out.println("범위를 다시 입력해주세요");
    }
}
