package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Club implements SessionManagement {
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Session> sessions = new ArrayList<Session>();


    public boolean AdminCheck(String name) {
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member m = iterator.next();
            if (m.getName().equals(name) && m instanceof Admin) return true;
        }
        System.out.println("운영진이 아니거나 존재하지않습니다.");
        return false;
    }


    public void addMember(Member member) {
        if (member instanceof Admin) System.out.println(member.getName() + "이 운영진으로 가입되었습니다.");
        if (member instanceof RegularMember) System.out.println(member.getName() + "이 일반 멤버로 가입되었습니다.");
        if (member instanceof NewMember) System.out.println(member.getName() + "이 신규멤버로 가입되었습니다.");
        members.add(member);
    }

    public void removeMember(String name) {
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member m = iterator.next();
            if (m.getName().equals(name)) {
                System.out.println(m.getName() + "이/가 클럽에서 탈퇴했습니다.");
                iterator.remove();
                return;
            }
        }

    }

    @Override
    public void openSession(Session session) {
        System.out.println(session.getCreator().getName() + "이 " + session.getDate() + ", " + session.getLocation() + "에 연습 세션을 오픈했습니다.");
        sessions.add(session);
    }

    @Override
    public void cancelSession(String location, LocalDateTime localDateTime) {
        Iterator<Session> iterator = sessions.iterator();

        //장소와 날짜  기준으로 세션을 찾아서 취소

//        System.out.println(session.getDate() + ", " + session.getLocation() + " 연습 세션이 취소되었습니다.");
//        session.setStatus("취소");
    }

    @Override
    public void postponeSession(String location, LocalDateTime localDateTime) {
//        session.setDate(newDate);
//        System.out.println(session.getCreator() + "이 " + session.getLocation() + ", " + session.getLocation() + "에 연습 세션을 연기했습니다.");
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}