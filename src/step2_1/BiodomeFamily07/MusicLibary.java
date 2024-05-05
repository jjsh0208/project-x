package step2_1.BiodomeFamily07;


import java.util.*;

public class MusicLibary {
    private ArrayList<Song> songs = new ArrayList<Song>();
    Scanner sc = new Scanner(System.in);

    private int playList = 0;

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addMusic(Song song){
        for (Song s : songs){
            if (s.getName().equals(song.getName())){
                System.out.println("동일한 이름의 노래가 존재합니다.");
                return;
            }
        }
        if (song instanceof AnimalSong) {
            System.out.println("새로운 노래 " + "\"" + song.getName() + ", " + song.getPlayingTime() + ", " + song.getMusician() + ", "
                    + ((AnimalSong) song).getAnimal()+ "\"" + " 추가되었습니다.");
        }
        if (song instanceof ManagerSong){
            System.out.println("새로운 노래 " + "\"" + song.getName() + ", " + song.getPlayingTime() + ", " + song.getMusician() + ", "
                    + ((ManagerSong) song).getGenre() + "\"" + " 추가되었습니다.");
        }
        songs.add(song);
        Collections.shuffle(songs); //bonus
    }


    public void removeMusic(String title){
        Iterator<Song> iterator = songs.iterator();
        while(iterator.hasNext()){
            Song s = iterator.next();
            if(s.getName().equals(title)){
                if(s instanceof AnimalSong){
                    System.out.println("노래 \""+ s.toString() + "\" 삭제되었습니다.");
                }
                if(s instanceof ManagerSong){
                    System.out.println("노래 \""+ s.toString()+"\" 삭제되었습니다.");
                }
                iterator.remove();
                return;
            }

        }
        System.out.println("해당 제목의 노래가 존재하지않습니다.");
    }


    public void animalList (){
        System.out.println("==동물의 위한 노래==");
        for (Song s : songs){
            if (s instanceof AnimalSong){
                System.out.println("\""+s.toString()+"\"");
            }
        }
    }

    public void humanLList (){
        System.out.println("==사람의 위한 노래==");
        for (Song s : songs){
            if (s instanceof ManagerSong){
                System.out.println("\""+s.toString()+"\"");
            }
        }
    }



    public void Search(){
        System.out.println("검색 조건 (1. 제목 2. 대상 동물 3. 장르 4.동물의 위한 노래 5. 사람을 위한 노래" );
        int choice = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        switch (choice){
            case 1: //제목으로 검색
                System.out.println("검색할 제목을 입력하시오");
                String title = sc.nextLine();
                for(Song s : songs){
                    if(s.getName().equals(title)){
                        System.out.println("\""+s.toString()+"\"");
                        cnt++;
                    }
                }
                if (cnt == 0){
                    System.out.println("해당 제목의 노래가 존재하지않습니다.");
                }
                break;

            case 2: // 대상 동물로 조회
                System.out.println("검색할 동물을 입력하시오: ");
                String animal = sc.nextLine();
                    for(Song s : songs){
                        if (s instanceof AnimalSong && ((AnimalSong) s).getAnimal().equals(animal)){
                            System.out.println("\""+s.toString()+"\"");
                            cnt++;
                        }
                    }
                if (cnt == 0){
                    System.out.println("해당 제목의 노래가 존재하지않습니다.");
                }
                break;

            case 3:
                System.out.println("검색할 장르을 입력하시오: ");
                String genre = sc.nextLine();
                for(Song s : songs){
                    if (s instanceof ManagerSong && ((ManagerSong) s).getGenre().equals(genre)){
                        System.out.println("\""+s.toString()+"\"");
                        cnt++;
                    }
                }
                if (cnt == 0){
                    System.out.println("해당 제목의 노래가 존재하지않습니다.");
                }
                break;
            case 4:
               animalList();
                break;
            case 5:
                humanLList();
                break;
            default:
                System.out.println("메뉴의 를 다시 선택해주세요");
                break;
        }
    }

}
