package step2_2.RuleOfBiodome08;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();


    public Library() {
        System.out.println("도서관 시스템이 생성되었습니다.");
    }

    public void add (ArrayList<Book> book){
        if (book == null){
            System.out.println("추가할 요소가 없습니다.");
            return;
        }

        books.addAll(book);

        for (Book b : book){
            System.out.println('\"' + b.getTitle()+"\"  이/가 도서목록에 추가되었습니다." );
        }


        Collections.sort(books); //이름 순으로 정렬

    }

    public void borrowed(String title) {;
        for (Book b : books){
            if (b.getTitle().equals(title) && !b.isBorrowed()){
                //"야채의 비밀" 대출되었습니다. 최근 대출 날짜 업데이트: [현재 날짜]
                System.out.println("대출");
                System.out.println('\"' + title +"\" 대출되었습니다. 최근 대출 날짜 업데이트 : [현재 날짜]");
                b.setBorrowed(true);
                b.setBorrowedDate(LocalDate.now());
                return;
            }
        }
        System.out.println("해당 도서가 존재하지않거나 대출되었습니다.");
    }

    public void bookReturn(String title) {
        for (Book b : books){
            if (b.getTitle().equals(title) && b.isBorrowed()){
                //"야채의 비밀" 대출되었습니다. 최근 대출 날짜 업데이트: [현재 날짜]
                System.out.println("반납");
                System.out.println('\"' + title +"\" 이/가 반납되었습니다.");
                b.setBorrowed(false);
                return;
            }
        }
        System.out.println("해당 도서가 존재하지않거나 대출되었습니다.");
    }

    public void sortList(int choice) {
        //1. 저자 2. 출판일 3. 대출일 4. 제목 길이
        switch (choice){
            case 1:
                System.out.println("(저자명 기반 정렬 조회)");
                books.sort(Book.AuthorComparator);
                break;
            case 2:
                System.out.println("(출판일 기반 정렬 조회)");
                books.sort(Book.PublicationDateComparator);
                break;
            case 3:
                System.out.println("(대출일 기반 정렬 조회)");
                books.sort(Book.BorrowedDateComparator);
                break;
            case 4:
                System.out.println("(도서의 제목길이 기반 정렬 조회)");
                books.sort(Book.BookTitleLengthComparator);
            default:
                break;
        }


        for (Book book : books){
            System.out.println(book.toString());
        }


    }
}
