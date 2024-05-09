package step2_2.RuleOfBodome02;

import java.util.ArrayList;
import java.util.List;

public interface MemberControl {
    //SRP 원칙을 지키기 위해 Library 는 도서만 관리한다.
    //회원 관리는 MemberControl 인터페이스 의 기능을 받아 사용

    List<User> users = new ArrayList<>(); //도서관 사용자 목록

    default void addMember(Member member) {
        System.out.println("새로운 이용자 \'"+ member.getName() +"\' 를/을 등록합니다.");
        users.add(member);
    }

    default void addManager(Manager manager) {
        System.out.println("새로운 관리자 \'"+ manager.getName() +"\' 를/을 등록합니다.");
        users.add(manager);
    }

    default boolean userExists(String id, String name, boolean checkManager) {
        for (User user : users) {
            boolean isManager = user instanceof Manager;
            boolean idAndNameMatch = user.getUserId().equals(id) && user.getName().equals(name);

            if (idAndNameMatch && (!checkManager || isManager)) {
                return true;
            }
        }
        return false;
    }

    default Manager managerCheck(String id, String name){
        for(User user : users){
            User u = user;
            if(u instanceof Manager &&  u.getUserId().equals(id) && u.getName().equals(name)){
                return (Manager) user;
            }
        }
        return null;
    }

    default boolean memberCheck(String id, String name){
        return userExists(id, name, false);
    }


}
