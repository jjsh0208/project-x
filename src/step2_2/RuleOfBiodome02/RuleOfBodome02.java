package step2_2.RuleOfBiodome02;

import java.util.Scanner;

public class RuleOfBodome02 {
    static Library library;
    static Scanner sc;
    public static void main(String[] args) {
        library = new Library();
        sc = new Scanner(System.in);;


        while(true){
            System.out.println("========================");
            System.out.println("1. 회원추가");
            System.out.println("2. 도서대여");
            System.out.println("3. 도서반납");
            System.out.println("4. 저자검색");
            System.out.println("5. 도서등록 (Manager)");
            System.out.println("6. 도서삭제 (Manager)");
            System.out.println("7. 종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addMember();
                    break;
                case 2:
                    bookRental();
                    break;
                case 3:
                    bookReturn();
                    break;
                case 4:
                    authorSearch();
                    break;
                case 5:
                    addBook();
                    break;
                case 6:
                    removeBook();
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }
    

    //회원 추가
    private static void addMember() {
        System.out.print("사용자 ID  : ");
        String id = sc.nextLine();
        System.out.print("사용자 명 : ");
        String name = sc.nextLine();
        System.out.print("1. 일반회원  /  2. 매니저  /  3. 학생");
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                library.addMember(new Member(id,name));
                break;
            case 2:
                library.addMember(new Manager(id,name));
                break;
            case 3:
                library.addMember(new Student(id,name));
            default:
                break;
        }
    }

    //도서 대출
    private static void bookRental() {
        System.out.print("id : ");
        String id = sc.nextLine();
        System.out.print("대여자 명 : ");
        String name = sc.nextLine();
        if(!library.memberCheck(id,name)){
            System.out.println("존재하지않는 회원입니다.");
            return;
        };
        System.out.println("==== 도서 대여 ====");
        System.out.print("책 이름 : ");
        String title = sc.nextLine();
        library.bookRental(title,name);
    }

    //도서 반납
    private static void bookReturn() {
        System.out.print("id : ");
        String id = sc.nextLine();
        System.out.print("대여자 명 : ");
        String name = sc.nextLine();
        if(!library.memberCheck(id,name)){
            System.out.println("존재하지않는 회원입니다.");
            return;
        };
        System.out.println("==== 도서 반납 ====");
        System.out.print("반납할 책 이름 : ");
        String title = sc.nextLine();
        library.bookReturn(title,name);
    }

    private static void authorSearch() {
        System.out.print("검색할 저자 명 :");
        String author = sc.nextLine();
        library.authorSearch(author);
    }



    //도서 추가
    private static void addBook() {
        System.out.print("매니저 id : ");
        String managerId = sc.nextLine();
        System.out.print("매니저 명 : ");
        String managerName = sc.nextLine();

        Manager manager = library.managerCheck(managerId,managerName);
        if (manager == null){
            System.out.println("매니저만 도서를 등록할 수 있습니다.");
            return;
        }
        System.out.println("==== 도서 등록 ====");
        System.out.print("도서 번호 : ");
        String isbn = sc.nextLine();
        System.out.print("책 이름 : ");
        String title = sc.nextLine();
        System.out.print("글쓴이 : ");
        String author = sc.nextLine();
        System.out.print("책의 종류는? (1. 일반 책 / 2. 잡지 / 3. 교과서 )");
        int choice = Integer.parseInt(sc.nextLine());
        manager.addBook(isbn,title,author, manager.getName() ,choice, library);

    }

    //도서 삭제
    private static void removeBook() {
        System.out.print("매니저 id : ");
        String managerId = sc.nextLine();
        System.out.print("매니저 명 : ");
        String managerName = sc.nextLine();

        Manager manager = library.managerCheck(managerId,managerName);
        if (manager == null){
            System.out.println("매니저만 도서를 등록할 수 있습니다.");
            return;
        }
        System.out.println("==== 도서 삭제 ====");
        System.out.print("도서 번호 : ");
        String isbn = sc.nextLine();
        System.out.print("책 이름 : ");
        String title = sc.nextLine();
        System.out.print("글쓴이 : ");
        String author = sc.nextLine();
        manager.removeBook(isbn,title,author,manager.getName() ,library);

    }

}

