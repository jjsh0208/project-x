package step2_2.RuleOfBodome02;

public interface BookManager { //매니저가 가져야할 기능만 가지고있음

    void addBook(String isbn,String  title,String author, String managerName ,int choice , Library library);
    void removeBook(String isbn,String  title,String author, String managerName , Library library);
}
