package step2_2.RuleOfBiodome08;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RuleOfBiodome08 {
    static Library lb;
    static Scanner sc;
    static ArrayList<Book> list = new ArrayList<>();
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        while (true) {
            System.out.println("========================");
            System.out.println("1. 도서 객체 생성");
            System.out.println("2. 도서관 시스템 생성 및 등록");
            System.out.println("3. 도서 대출 / 반납");
            System.out.println("4. 도서 목록");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {

                case 1:
                    System.out.println("(도서 객체 생성)");
                    createBook();
                    break;
                case 2:
                    System.out.println("(도서관 시스템 생성 및 등록)");
                    if (lb == null) lb = new Library();
                    lb.add(list);
                    break;
                case 3:
                    borrowedAndReturn();
                    break;
                case 4:
                    BookList();
                    break;
            }
        }


    }

    private static void BookList() {
        System.out.print("정렬 기준을 선택해주세요 : 1. 저자 2. 출판일 3. 최근 대출일 4. 제목 길이 순");
        int choice = Integer.parseInt(sc.nextLine());
        while (choice < 0 || choice > 4){
            System.out.println("1,2,3,4 중에 선택해주세요");
            choice = Integer.parseInt(sc.nextLine());
        }
        lb.sortList(choice);
    }


    private static void borrowedAndReturn() {
        System.out.println("1. 대출 / 2. 반납");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice){
            case 1:
                System.out.print("대출할 책의 이름 : ");
                String title = sc.nextLine();
                lb.borrowed(title);
                break;
            case 2:
                System.out.print("반납할 책의 이름 : ");
                title = sc.nextLine();
                lb.bookReturn(title);
                break;
            default:
                System.out.println("다시 입력해주세요");
                break;
        }
    }

    private static void createBook() {

        while(true){
            System.out.print("도서을 추가하시겠습니까? (1. 예 / 2. 아니오)");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 2){
                break;
            }

            System.out.print("책 이름 : ");
            String title = sc.nextLine();
            System.out.print("저자 : ");
            String author = sc.nextLine();
            System.out.print("출판일 : 예) 2024-05-15 ");
            String publicationDate = sc.nextLine();

            String[] dateParts = publicationDate.split("-");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            LocalDate date = LocalDate.of(year,month,day);

            list.add(new Book(title,author,date));
        }
    }
}
