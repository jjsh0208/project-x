package step2_1.BiodomeFamily07;

import java.util.Scanner;

public class BiodomeFamily07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        MusicLibary musicLibary = new MusicLibary();

        while (true){
            System.out.println("========================");
            System.out.println("1. 노래추가");
            System.out.println("2. 노래삭제");
            System.out.println("3. 재생");
            System.out.println("4. 볼륨조절");
            System.out.println("5. 노래 검색");
            System.out.println("6. 시스템종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("누굴 위한 노래를 추가하실건가요 (1. 동물 2.사람)");
                    int addChoice = Integer.parseInt(sc.nextLine());
                    if(addChoice == 1){
                        System.out.println("노래 제목 : ");
                        String name = sc.nextLine();
                        System.out.println("재생 시간  :");
                        String playTime = sc.nextLine();
                        System.out.println("음악가 : ");
                        String musician =sc.nextLine();
                        System.out.println("동물 (사슴, 당나귀, 코끼리) : ");
                        String animal = sc.nextLine();
                        while (!(animal.equals("사슴") || animal.equals("당나귀") || animal.equals("코끼리"))) {
                            System.out.println("입력하신 동물은 유효하지 않습니다. 사슴, 당나귀, 코끼리 중에서 선택해주세요.");
                            animal = sc.nextLine();
                        }
                        musicLibary.addMusic(new AnimalSong(name,playTime,musician,animal));
                    }
                    if(addChoice == 2){
                        System.out.println("노래 제목 : ");
                        String name = sc.nextLine();
                        System.out.println("재생 시간  :");
                        String playTime = sc.nextLine();
                        System.out.println("음악가 : ");
                        String musician =sc.nextLine();
                        System.out.println("장르 (재즈/팝/클래식/힙합) : ");
                        String genre = sc.nextLine();
                        while (!(genre.equals("재즈") || genre.equals("팝") || genre.equals("클래식") || genre.equals("힙합"))) {
                            System.out.println("입력하신 장르는 유효하지 않습니다. 재즈, 팝, 클래식, 힙합 중에서 선택해주세요.");
                            genre = sc.nextLine();
                        }
                        musicLibary.addMusic(new ManagerSong(name,playTime,musician,genre));
                    }
                    break;
                case 2:
                    System.out.println("삭제할 음악의 제목을 입력해주세요 : ");
                    String name = sc.nextLine();
                    musicLibary.removeMusic(name);
                    break;
                case 3:
                    player.playMusic(musicLibary.getSongs());
                    break;
                case 4:
                    System.out.println("번경할 볼륨을 입력해주세요. (동물을 위한 노래는 0 ~ 5) (사람을 위한 노래는 0 ~ 30) ");
                    int volume = Integer.parseInt(sc.nextLine());
                    player.volumeControl(volume , musicLibary.getSongs());
                    break;
                case 5:
                    musicLibary.Search();
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
