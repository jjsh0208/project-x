package step2_2.RuleOfBodome02;

class Manager extends User implements BookManager {
    public Manager(String userId, String name) {
        super(userId, name);
    }

    public void addBook(Book book, Library library) {
        library.addBook(book);
    }

    public void removeBook(Book book, Library library) {
        library.removeBook(book);
    }
}