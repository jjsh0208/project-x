package step2_2.RuleOfBiodome02;


import java.util.ArrayList;

class User {
    private ArrayList<Book> books; //대여한 책 목록
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this. books = new ArrayList<>();
    }

    public void bookBorrow(Book book){
        books.add(book);
    }

    public void bookReturn(Book book){
        books.remove(book);
    }




    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}