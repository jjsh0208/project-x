package step2_2.RuleOfBodome02;

import java.util.ArrayList;
import java.util.List;

class Library implements MemberControl{
    private List<Book> books = new ArrayList<>(); //도서관의 책 목록

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn,title,author);
        books.add(book);
        return book;
    }
    public void addBook(Book book) { //도서관에 책 추가;
        books.add(book);
    }

    public void removeBook(Book book) { //도서관 에 책 삭제
         books.remove(book);
    }

    public void borrowBook(Book book) { //책 대여 여부
        if(!book.isBorrowed()) {
            book.setBorrowed(true);
        }
        else{
            book.setBorrowed(false);
        }
    }

}