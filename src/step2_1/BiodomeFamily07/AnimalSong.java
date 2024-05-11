package step2_1.BiodomeFamily07;

public class AnimalSong extends Song{
    private  String animal;

    public AnimalSong(String name, String playingTime, String musician , String animal) {
        super(name, playingTime, musician);
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return getName()+", "+getPlayingTime()+", "+getMusician()+", "+ getAnimal();
    }
}
