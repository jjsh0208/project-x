package step2_1.BiodomeFamily08;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BiodomeFamily08 {
    static Club  club = new Club();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true){
            System.out.println("========================");
            System.out.println("1. 회원가입");
            System.out.println("2. 세션참가");
            System.out.println("3. 세션개설");
            System.out.println("4. 세션취소");
            System.out.println("5. 세션연기");
            System.out.println("6. 세션조회");
            System.out.println("7. 세션참가 목록(타지역)");
            System.out.println("8. 세션참가 승인(타지역)");
            System.out.println("9. 시스템종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    register();
                    break;
                case 2:
                    sessionAttend();
                    break;
                case 3:
                    createSession();
                    break;
                case 4:
                    removeSession();
                    break;
                case 5:
                    editSession();
                    break;
                case 6:
                    club.readSession();
                    break;
                case 7:
                    club.readApproval();
                    break;
                case 8:
                    approval();
                    break;
                case 9:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("메뉴에서 선택해 입력해주세요.");
            }
        }
    }



    private static void register() {
        System.out.println("몇 명 가입하실건가요? 1. 1명 2. 2명");
        int check = Integer.parseInt(sc.nextLine());
        List<Member> newMembers = new ArrayList<>();

        for (int i = 0; i < check; i++) {
            System.out.println((i + 1) + "번째 이름: ");
            String name = sc.nextLine();

            System.out.println("기술 점수를 입력하시겠습니까? (1. 예 2. 아니오)");
            int skillCheck = Integer.parseInt(sc.nextLine());
            int skill = 0;
            if (skillCheck == 1) {
                System.out.println("기술 점수를 입력해주세요.");
                skill = Integer.parseInt(sc.nextLine());
            }

            System.out.println("직위를 입력 해주세요 (1. 운영진 2. 일반 멤버 3. 신규 멤버)");
            int position = Integer.parseInt(sc.nextLine());


            System.out.println("타 지역 사람입니까? (1. 예 2. 아니오)");
            int locationCheck = Integer.parseInt(sc.nextLine());
            String location = null;
            if (locationCheck == 1) {
                System.out.println("지역을 입력해주세요.");
                location = sc.nextLine();
            }

            Member member = createMember(name, skill, skillCheck == 1, position ,location ,locationCheck == 1);

            if (member != null) {
                newMembers.add(member);
            }
        }
        if (newMembers.size() == 2){
            club.addMember(newMembers.get(0),newMembers.get(1));
        }
        else club.addMember(newMembers.get(0));
    }

    private static Member createMember(String name, int skill, boolean skillProvided, int position, String location , boolean locationCheck) {
        LocalDateTime now = LocalDateTime.now();
        switch (position) {
            case 1:
                return skillProvided ? locationCheck ?  new Admin(name, now, skill,location) : new Admin(name,now,skill) :
                        locationCheck ?   new Admin(name, now,location) : new Admin(name,now);
            case 2:
                return skillProvided ? locationCheck ?  new RegularMember(name, now, skill,location) : new RegularMember(name,now,skill) :
                        locationCheck ?   new RegularMember(name, now,location) : new RegularMember(name,now);
            case 3:
                return skillProvided ? locationCheck ?  new NewMember(name, now, skill,location) : new NewMember(name,now,skill) :
                        locationCheck ?   new RegularMember(name, now,location) : new RegularMember(name,now);
            default:
                System.out.println("잘못된 입력입니다.");
                return null;
        }
    }

    private static void sessionAttend() {

        System.out.println("세션에 몇 분 참가하실건가요? 1. 1명 2. 2명");
        int check = Integer.parseInt(sc.nextLine());
        String[] names = new String[check];

        for (int i = 0; i < check; i++) {
            System.out.println((i + 1) + "번째 이름: ");
            names[i] = sc.nextLine();
        }
        System.out.println("참가할 세션의 장소를 입력 : ");
        String location = sc.nextLine();
        System.out.println("참가할 연습 세션의 날짜를 입력하시오 (예) 2024 05 05 )");
        String date = sc.nextLine();
        String[] dateParts = date.split(" ");

        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        LocalDateTime localDateTime = LocalDateTime.of(year,month,day,0,0,0);

        if (names.length == 2){
            club.sessionAttend(names[0],names[1],location,localDateTime );
        }
        else club.sessionAttend(names[0],location,localDateTime);
    }


    private static void createSession(){
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
                System.out.println("취소할 연습 세션의 장소를 입력하세요 : ");
                String location = sc.nextLine();

                System.out.println("취소할 연습 세션의 날짜를 입력하시오 (예) 2024 05 05 )");
                String date = sc.nextLine();
                String[] dateParts = date.split(" ");

                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
                LocalDateTime localDateTime = LocalDateTime.of(year,month,day,0,0,0);

                club.cancelSession(location,localDateTime);
                sessionRemove = true;
                break;
            }
        }
        if(!sessionRemove) System.out.println("운영진이 아니거나 존재하지않습니다.");
    }


    private static void editSession() {
        System.out.println("관리자 : ");
        String name = sc.nextLine();

        boolean sessionEdit = false;
        Iterator<Member> iterator = club.getMembers().iterator();
        while(iterator.hasNext()){
            Member m = iterator.next();
            if(m.getName().equals(name) && m instanceof Admin){
                System.out.println("연기할 연습 세션의 장소를 입력하세요 : ");
                String location = sc.nextLine();

                System.out.println("연기할 연습 세션의 날짜를 입력하시오 (예) 2024 05 05 )");
                String date = sc.nextLine();
                String[] dateParts = date.split(" ");

                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
                LocalDateTime localDateTime = LocalDateTime.of(year,month,day,0,0,0);

                club.postponeSession(name,location,localDateTime);
                sessionEdit = true;
                break;
            }
        }
        if(!sessionEdit) System.out.println("운영진이 아니거나 존재하지않습니다.");
    }


    private static void approval() {
        System.out.println("관리자 : ");
        String admin = sc.nextLine();

        boolean approval = false;
        Iterator<Member> iterator = club.getMembers().iterator();
        while(iterator.hasNext()){
            Member m = iterator.next();
            if(m.getName().equals(admin) && m instanceof Admin){
                System.out.println("승인할 멤버의 이름 : ");
                String name = sc.nextLine();
                System.out.println("승인할 세션 : ");
                String location = sc.nextLine();
                System.out.println("승인할 세션의 날짜 : ");
                String date = sc.nextLine();
                String[] dateParts = date.split(" ");

                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
                LocalDateTime localDateTime = LocalDateTime.of(year,month,day,0,0,0);

                club.approval(name,location,localDateTime);
                approval = true;
                break;
            }

        }
        if(!approval) System.out.println("운영진이 아니거나 존재하지않습니다.");
    }

}
