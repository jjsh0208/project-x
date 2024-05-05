package step2_1.BiodomeFamily07;

public class Song {
    private  String name;
    private  String PlayingTime;
    private  String Musician;

    public Song(String name, String playingTime, String musician) {
        this.name = name;
        PlayingTime = playingTime;
        Musician = musician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayingTime() {
        return PlayingTime;
    }

    public void setPlayingTime(String playingTime) {
        PlayingTime = playingTime;
    }

    public String getMusician() {
        return Musician;
    }

    public void setMusician(String musician) {
        Musician = musician;
    }


}
