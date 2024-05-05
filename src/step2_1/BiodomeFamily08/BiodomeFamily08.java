package step2_1.BiodomeFamily08;

import step2_1.BiodomeFamily07.AnimalSong;
import step2_1.BiodomeFamily07.ManagerSong;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class BiodomeFamily08 {
    static Club  club = new Club();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true){
            System.out.println("========================");
            System.out.println("1. 회원가입");
            System.out.println("2. 세션개설");
            System.out.println("3. 세션삭제");
            System.out.println("4. 세션수정");
            System.out.println("5. 세션조회");
            System.out.println("6. 시스템종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    register();
                    break;
                case 2:
                    CreateSession();
                    break;
                case 3:
                    removeSession();
                    break;
            }

        }
    }



    private static void register(){
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("기술 점수를 입력하시겠습니끼? (1. 예  2. 아니오)");
        int check = Integer.parseInt(sc.nextLine());
        if(check == 1){
            System.out.println("기술 점수를 입력해주세요.");
            int skill = Integer.parseInt(sc.nextLine());
            System.out.println("직위를 입력 해주세요 (1. 운영진  2. 일반 멤ㅂ 3. 신규 멤버)");
            switch (Integer.parseInt(sc.nextLine())){
                case 1:
                    club.addMember(new Admin(name, LocalDateTime.now(),skill));
                    break;
                case 2:
                    club.addMember(new RegularMember(name,LocalDateTime.now(),skill));
                    break;
                case 3:
                    club.addMember(new NewMember(name,LocalDateTime.now(),skill));
                    break;
                default:
                    break;
            }
        }
        else{
        System.out.println("직위를 입력 해주세요 (1. 운영진  2. 일반 멤버 3. 신규 멤버)");
        switch (Integer.parseInt(sc.nextLine())){
            case 1:
                club.addMember(new Admin(name, LocalDateTime.now()));
                break;
            case 2:
                club.addMember(new RegularMember(name,LocalDateTime.now()));
                break;
            case 3:
                club.addMember(new NewMember(name,LocalDateTime.now()));
                break;
            default:
                break;
        }}
    }


    private static void CreateSession(){
        System.out.println("개설자 : ");
        String name = sc.nextLine();

        boolean sessionCreate = false;
        Iterator<Member> iterator = club.getMembers().iterator();
        while(iterator.hasNext()){
            Member m = iterator.next();
            if(m.getName().equals(name) && (m instanceof Admin || m instanceof RegularMember)){
                System.out.println("장소 : ");
                String location = sc.nextLine();
                club.openSession(new Session(m,location,LocalDateTime.now()));
                sessionCreate = true;
                break;
            }
        }
        if(!sessionCreate) System.out.println("신규 멤버는 연습을 개설할 수 없습니다.");
    }

    private static void removeSession() {
        System.out.println("관리자 : ");
        String name = sc.nextLine();

        boolean sessionRemove = false;
        Iterator<Member> iterator = club.getMembers().iterator();
        while(iterator.hasNext()){
            Member m = iterator.next();
            if(m.getName().equals(name) && m instanceof Admin){
                sessionRemove = true;
                break;
            }
        }
        if(!sessionRemove) System.out.println("운영진이 아니거나 존재하지않습니다.");
    }
}
