package step2_2.RuleOfBodome02;


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