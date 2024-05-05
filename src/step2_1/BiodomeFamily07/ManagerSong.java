package step2_1.BiodomeFamily07;

public class ManagerSong extends Song{
    private String genre;

    public ManagerSong(String name, String playingTime, String musician,String genre) {
        super(name, playingTime, musician);
        this.genre =genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return getName()+", "+getPlayingTime()+", "+getMusician()+", "+ getGenre();
    }
}
