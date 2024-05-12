package step2_2.RuleOfBiodome02;

class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
    
    //대여 가능한지 체크하는 함수 구현해야함
    
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void bookInfo(){
        System.out.println("책 번호 : " + getIsbn() + " 책 제목 : " + getTitle() + " 저자 : " + getAuthor() + " 대출여부 : " + isBorrowed);
    }
}