package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Session{

    private LocalDateTime date;
    private String location;
    private ArrayList<Member> members;
    private Member creator;
    private String status; // "개설", "취소"

    public Session(Member creator, String location,LocalDateTime date) {
        this.creator = creator;
        this.location = location;
        this.date = date;
        this.members = new ArrayList<>();
        this.status = "개설";
    }

    public void addMember(Member member){
        System.out.println(member.getName()+"이/가 세션에 참가합니다.");
        members.add(member);
    }

    public void addMember(Member member1,Member member2){
        System.out.println(member1.getName()+ "과 "+ member2.getName() +"이/가 연습 세션에 참가합니다.");
        members.add(member1);
        members.add(member2);
    }

    public void removeMember(Member member){
        System.out.println(member.getName()+"이/가 세션에서 탈퇴합니다.");
        members.remove(member);
    }

    @Override
    public String toString() {
        String memberNames = members.stream() // members 리스트를 스트림으로 변환
                .map(Member::getName) // 각 Member 객체를 이름으로 매핑
                .collect(Collectors.joining(", ")); // 이름들을 ", "로 구분하여 하나의 문자열로 결합

        return this.date.getYear() +"년 "+ this.getDate().getMonthValue() + "월 "+ this.date.getDayOfMonth() +"일, "+
                this.getLocation()+ ", [" + memberNames + "], " + this.getCreator().getName() +", "+ this.getStatus();
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Member getCreator() {
        return creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
