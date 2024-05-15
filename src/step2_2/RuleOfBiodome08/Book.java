package step2_2.RuleOfBiodome08;

import java.time.LocalDate;
import java.util.Comparator;

public class Book implements Comparable<Book> {
    //제목, 저자, 출판일, 대출 가능 여부, 최근 대출 날짜
    private String title;
    private String author;
    private LocalDate publicationDate;
    private boolean isBorrowed;
    private  LocalDate BorrowedDate;

    public Book(String title, String author, LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isBorrowed = false;
        this.BorrowedDate = null;

        System.out.println(toString());
    }

    @Override
    public String toString() {
        //목: "파이썬 마스터", 저자: "한송희", 출판일: "2020-01-01", 대출 가능 여부: "가능", 최근 대출 날짜: "N/A"
        return "제목 :  \""+this.title + "\", 저자 : \"" + this.getAuthor() + "\", 출판일 : \"" + getPublicationDate() +"\", 대출 가능 여부 : \""+
                (isBorrowed()? "불가" : "가능") +"\", 최근 대출 날짜 : \"" + (this.getBorrowedDate() == null ? "N/A": this.getBorrowedDate()) + '\"';
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }

    public static Comparator<Book> BookTitleLengthComparator  = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            //책의 제목의 길이별로 오름차순
            //제목의 길이가 같을 때는 제목 순
            if (o1.getTitle().length() == o2.getTitle().length()){
                return o1.getTitle().compareTo(o2.getTitle());
            }
            return o1.getTitle().length() - o2.getTitle().length();
        }
    };


    // 저자, 출판일, 최근 대출 날짜 기반 정렬 옵션을 제공한다.
    public static Comparator<Book> AuthorComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    };


    public static Comparator<Book> PublicationDateComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPublicationDate().compareTo(o2.getPublicationDate());
        }
    };

    public static Comparator<Book> BorrowedDateComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getBorrowedDate().compareTo(o2.getBorrowedDate());
        }
    };

    public void setBorrowedDate(LocalDate borrowedDate) {
        BorrowedDate = borrowedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public LocalDate getBorrowedDate() {
        return BorrowedDate;
    }


}
