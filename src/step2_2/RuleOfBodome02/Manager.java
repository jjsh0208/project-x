package step2_2.RuleOfBodome02;

class Manager extends User implements BookManager { //매니저가 가져야할 기능만 가지고있음
    public Manager(String userId, String name) {
        super(userId, name);
    }

    public void addBook(String isbn,String  title,String author, String managerName ,int choice,Library library) {
        library.addBook(isbn,title,author ,choice ,managerName);
    }

    public void removeBook(String isbn,String  title,String author, String managerName , Library library) {
        library.removeBook(isbn,title,author,managerName);
    }
}