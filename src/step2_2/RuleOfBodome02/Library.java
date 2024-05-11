package step2_2.RuleOfBodome02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

class Library implements MemberControl{
    private List<Book> books = new ArrayList<>(); //도서관의 책 목록

    public void addBook(String isbn,String  title,String author ,int choice, String managerName) { //도서관에 책 추가;
        //choice 1. 일반책  2. 잡지  3. 교과서
        switch (choice){
            case 1:
                Book book = new Book(isbn,title,author);
                books.add(book);
                System.out.println("관리자 \'"+managerName+"\' 가 책을 추가합니다: \'"+title+"\', \'"+author+"\' (일반책)");
                break;
            case 2:
                Book magazine = new Magazine(isbn,title,author);
                books.add(magazine);
                System.out.println("관리자 \'"+managerName+"\' 가 책을 추가합니다: \'"+title+"\', \'"+author+"\' (잡지)");
                break;
            case 3:
                Book textBook = new TextBook(isbn,title,author);
                books.add(textBook);
                System.out.println("관리자 \'"+managerName+"\' 가 책을 추가합니다: \'"+title+"\', \'"+author+"\' (교과서)");
                break;
            default:
                System.out.println("책의 종류를 다시 1,2,3 중에 골라주세요");
                return;
        }
    }

    public void removeBook(String isbn,String  title,String author , String managerName) { //도서관 에 책 삭제
        Iterator<Book> iterator = books.iterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn) && book.getTitle().equals(title) && book.getAuthor().equals(author) && !book.isBorrowed() ){
                books.remove(book);
                System.out.println("관리자 \'"+managerName+"\' 가 책을 삭제합니다: \'"+title+"\', \'"+author+"\'");
                return;
            }
        }
        System.out.println("존재하지않거나 대출되어있는 책입니다.");
    }

    public void bookRental(String title,String name){
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();

        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equals(title) && !book.isBorrowed()) //해당 책이 존재하고 아직 대출되지않았으면
                .findFirst();

        if (userOptional.isPresent() && bookOptional.isPresent()) { //해당 유저가 존재하고 해당 책이 존재하면
            
            if (userOptional.get() instanceof Student && bookOptional.get() instanceof Magazine){ //bonus 학생이고 빌릴책이 잡지이면
                System.out.println("학생은 일반책과 교과서만 대출할 수 있습니다.");
                return;
            }
            
            System.out.println("이용자 \'"+ userOptional.get().getName()+"\' \'"+bookOptional.get().getTitle()+"\' 대출합니다.");
            userOptional.get().bookBorrow(bookOptional.get()); //사용자의 대출 목록에 추가
            borrowBook(bookOptional.get());  //해당 도서의 대출유무 변경
        }
        else{
            System.out.println("\'"+title+"\'은 대출중입니다.");
        }
    }

    public void bookReturn(String title,String name){

        Optional<User> userOptional = users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();

        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equals(title) && book.isBorrowed()) //해당 책이 존재하고 아직 대출되어있으면
                .findFirst();
        if (bookOptional.isEmpty()){
            System.out.println("등록되지않은 책입니다.");
            return;
        }

        if (userOptional.isPresent() &&userOptional.get().getBooks().contains(bookOptional.get())) { //해당 유저가 존재하고 해당 책이 존재하면
            System.out.println("이용자 \'"+ userOptional.get().getName()+"\'가 \'"+bookOptional.get().getTitle()+"\' 반납합니다.");
            userOptional.get().bookReturn(bookOptional.get()); //사용자의 대출 목록에서 제거
            borrowBook(bookOptional.get());  //해당 도서의 대출유무 변경(반납)
            }
        else{
            System.out.println("\'"+name+"\' 은"+"\'"+title+"\'을 대출한적이없습니다.");
        }
    }

    public void borrowBook(Book book) { //책 대여 여부
        if(!book.isBorrowed()) { //false 대출된게아니면
            book.setBorrowed(true);
        }
        else{   //대출된거면
            book.setBorrowed(false);
        }
    }

    public void authorSearch(String author) {
        int cnt = 0;
        System.out.println("저자 \'"+author+"\'의 책 목록:");
        for (Book book : books){
            if (book.getAuthor().equals(author)){
                String borrow = book.isBorrowed() ? "대출 불가 " : "대출 가능";
                System.out.println("- "+book.getTitle()+", "+ borrow);
                cnt++;
            }
        }
        if (cnt == 0){
            System.out.println("해당 저자의 도서가 존재하지않습니다.");
        }
    }


}