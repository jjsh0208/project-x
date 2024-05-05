package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.ArrayList;


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
