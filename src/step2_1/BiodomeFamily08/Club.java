package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import static step2_1.BiodomeFamily08.BiodomeFamily08.sc;

public class Club implements SessionManagement {
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Session> sessions = new ArrayList<Session>();
    //bonus 승인 요청 목록
    private ArrayList<Approval> approvalList = new ArrayList<Approval>();

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        if (member instanceof Admin) System.out.println(member.getName() + "이 운영진으로 가입되었습니다." + member.getLocation());
        if (member instanceof RegularMember) System.out.println(member.getName() + "이 일반 멤버로 가입되었습니다.");
        if (member instanceof NewMember) System.out.println(member.getName() + "이 신규멤버로 가입되었습니다.");
        members.add(member);
    }

    public void addMember(Member member1, Member member2) {
        if (member1 instanceof Admin && member2 instanceof  Admin)
            System.out.println(member1.getName() + " 과/와 "+ member2.getName()+"가 운영진으로 가입되었습니다.");
        if (member1 instanceof RegularMember && member2 instanceof  RegularMember)
            System.out.println(member1.getName() + " 과/와 "+ member2.getName()+"가 일반 멤버로 가입되었습니다."+ member1.getLocation() + member2.getLocation());
        if (member1 instanceof NewMember && member2 instanceof  NewMember)
            System.out.println(member1.getName() + " 과/와 "+ member2.getName()+"가 신규 멤버로 가입되었습니다.");
        members.add(member1);
        members.add(member2);
    }

    public void sessionAttend(String name,String location,LocalDateTime localDateTime){
        Member member = null;
        // 먼저 두 회원을 찾습니다.
        for (Member m : members) {
            if (m.getName().equals(name)) {
                member = m;
                break;
            }
        }

        // 두 회원 중 하나라도 찾지 못했다면
        if (member == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }

        // 해당하는 세션을 찾습니다.
        Session targetSession = null;
        for (Session s : sessions) {
            if (s.getLocation().equals(location) &&
                    s.getDate().getYear() == localDateTime.getYear() &&
                    s.getDate().getMonthValue() == localDateTime.getMonthValue() &&
                    s.getDate().getDayOfMonth() == localDateTime.getDayOfMonth()) {
                targetSession = s;
                break;
            }
        }

        // 적절한 세션을 찾지 못했다면
        if (targetSession == null) {
            System.out.println("존재하지 않는 연습 세션입니다.");
            return;
        }

        //bonus
        if (!member.getLocation().equals("대구")){ //대구 사람이 아니면
            System.out.println("타지역 사람은 가입신청을 해야합니다.");
            System.out.println("가입 신청을 하시겠습니까? 1. 예  2. 아니오");
            int check = Integer.parseInt(sc.nextLine());
            if(check == 1){
                sessionApproval(name,location,localDateTime);
                return;
            }
        }

        // 두 회원을 세션에 추가합니다.
        targetSession.addMember(member);
    }

    private void sessionApproval(String name, String location, LocalDateTime localDateTime) {
        String [] approval = new String[]{name , location , String.valueOf(localDateTime)};
        approvalList.add(new Approval(approval[0],approval[1],LocalDateTime.parse(approval[2])));
    }

    public void sessionAttend(String name1, String name2, String location, LocalDateTime localDateTime) {
        Member member1 = null;
        Member member2 = null;
        // 먼저 두 회원을 찾습니다.
        for (Member m : members) {
            if (m.getName().equals(name1)) {
                member1 = m;
            } else if (m.getName().equals(name2)) {
                member2 = m;
            }
            // 두 회원 모두 찾았다면 더 이상 순회할 필요가 없습니다.
            if (member1 != null && member2 != null) {
                break;
            }
        }

        // 두 회원 중 하나라도 찾지 못했다면
        if (member1 == null || member2 == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }

        // 해당하는 세션을 찾습니다.
        Session targetSession = null;
        for (Session s : sessions) {
            if (s.getLocation().equals(location) &&
                    s.getDate().getYear() == localDateTime.getYear() &&
                    s.getDate().getMonthValue() == localDateTime.getMonthValue() &&
                    s.getDate().getDayOfMonth() == localDateTime.getDayOfMonth()) {
                targetSession = s;
                break;
            }
        }

        // 적절한 세션을 찾지 못했다면
        if (targetSession == null) {
            System.out.println("존재하지 않는 연습 세션입니다.");
            return;
        }

        // 두 회원을 세션에 추가합니다.
        targetSession.addMember(member1,member2);
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

    public void  readSession(){
        System.out.println("==개설된 연습 세션==");
        for (Session s : sessions){
            if (s.getStatus().equals("개설")){
                System.out.println(s.toString());
            }
        }
    }

    //bonus
    public void readApproval() {
        System.out.println("==승인 대기중인 참가 요청==");
        for (Approval a : approvalList){
            System.out.println(a.toString());
        }
    }
    public void approval(String name, String location, LocalDateTime localDateTime) {
        Member member = null;
        Approval approval = null;
        for (Member m : members){
            if (m.getName().equals(name)){
                member = m;
                break;
            }
        }

        for (Approval a : approvalList){
            if (a.getName().equals(name) && a.getLocation().equals(location) &&
                a.getDate().getYear() == localDateTime.getYear() &&
                a.getDate().getMonthValue() == localDateTime.getMonthValue() &&
                a.getDate().getDayOfMonth()== localDateTime.getDayOfMonth()){
                approval = a;
                break;
            }
        }


        // 해당하는 세션을 찾습니다.
        Session targetSession = null;
        for (Session s : sessions) {
            if (s.getLocation().equals(location) &&
                    s.getDate().getYear() == localDateTime.getYear() &&
                    s.getDate().getMonthValue() == localDateTime.getMonthValue() &&
                    s.getDate().getDayOfMonth() == localDateTime.getDayOfMonth()) {
                targetSession = s;
                break;
            }
        }

        approvalList.remove(approval);
        targetSession.addMember(member);
    }

    @Override
    public void openSession(Session session) {
        System.out.println(session.getCreator().getName() + "이 " + session.getDate() + ", " + session.getLocation() + "에 연습 세션을 오픈했습니다.");
        sessions.add(session);
    }

    @Override
    public void cancelSession(String location, LocalDateTime localDateTime) {
        Iterator<Session> iterator = sessions.iterator();
        while(iterator.hasNext()){
            Session s = iterator.next();
            if (s.getLocation().equals(location) &&
                    s.getDate().getYear() == localDateTime.getYear() &&
                    s.getDate().getMonthValue() == localDateTime.getMonthValue() &&
                    s.getDate().getDayOfMonth() == localDateTime.getDayOfMonth()){
                        System.out.println(s.getDate() + ", " + s.getLocation() + " 연습 세션이 취소되었습니다.");
                        s.setStatus("취소");
                        return;
            }
        }
        System.out.println("입력한 세션이 존재하지않습니다.");
    }

    @Override
    public void postponeSession(String admin,String location, LocalDateTime localDateTime) {
        Iterator<Session> iterator = sessions.iterator();
        while(iterator.hasNext()){
            Session s = iterator.next();
            if (s.getLocation().equals(location) &&
                    s.getDate().getYear() == localDateTime.getYear() &&
                    s.getDate().getMonthValue() == localDateTime.getMonthValue() &&
                    s.getDate().getDayOfMonth() == localDateTime.getDayOfMonth()){
                System.out.println("변경할 날짜를 입력해주세요 : ");
                String date = sc.nextLine();
                String[] dateParts = date.split(" ");

                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
                LocalDateTime editDate = LocalDateTime.of(year,month,day,0,0,0);

                s.setDate(editDate);
                System.out.println(admin + "이/가 "+ s.getDate().getYear()+ "년 " +s.getDate().getMonthValue()+"월 "+s.getDate().getDayOfMonth()+"일, "+
                        s.getLocation()+"에 연습 세션을 연기했습니다.");
                return;
            }
        }
        System.out.println("입력한 세션이 존재하지않습니다.");
    }



}