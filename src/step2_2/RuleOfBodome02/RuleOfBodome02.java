package step2_2.RuleOfBodome02;

import java.util.Scanner;

public class RuleOfBodome02 {
    static Library library;
    static Scanner sc;
    public static void main(String[] args) {
        Manager manager = new Manager("jjssh0208","전승현");
        library = new Library();
        sc = new Scanner(System.in);;


        while(true){
            System.out.println("========================");
            System.out.println("1. 회원추가");
            System.out.println("2. 도서대여");
            System.out.println("3. 도서반납");
            System.out.println("4. 도서목록");
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
//                    BookRental();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    addBook();
                    break;
                case 6:

                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addMember() {
        System.out.print("사용자 ID  : ");
        String id = sc.nextLine();
        System.out.print("사용자 명 : ");
        String name = sc.nextLine();
        System.out.print("1. 일반회원 / 2. 매니저");
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                library.addMember(new Member(id,name));
                break;
            case 2:
                library.addManager(new Manager(id,name));
                break;
            default:
                break;
        }
    }

    private static void BookRental() {
        System.out.print("id : ");
        String Id = sc.nextLine();
        System.out.print("대여자 명 : ");
        String Name = sc.nextLine();
        if(!library.memberCheck(Id,Name)){
            System.out.println("존재하지않는 회원입니다.");
            return;
        };
        System.out.println("==== 도서 대여 ====");
        System.out.print("책 이름 : ");
        String bookName = sc.nextLine();
        library.
    }



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
        String bookName = sc.nextLine();
        System.out.print("글쓴이 : ");
        String author = sc.nextLine();
        manager.addBook(new Book(isbn,bookName,author),library);
        System.out.println("관리자 \'"+manager.getName()+"\' 가 책을 추가합니다: \'"+bookName+"\', \'"+author+"\'");
    }

}

