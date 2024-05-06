package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;

public class Member {
    private String name;
    private LocalDateTime date;
    private int skill;
    private  String location;
    private boolean Approval;

    public Member(String name, LocalDateTime date, int skill) {
        this.name = name;
        this.date = date;
        this.skill = skill;
        this.location = "대구";
        this.Approval= true;
    }

    public Member(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
        this.skill = 0;
        this.location = "대구";
        this.Approval= true;
    }
    public Member(String name, LocalDateTime date, int skill ,String location) {
        this.name = name;
        this.date = date;
        this.skill = skill;
        this.location = location;
        this.Approval= false;
    }

    public Member(String name, LocalDateTime date, String location) {
        this.name = name;
        this.date = date;
        this.skill = 0;
        this.location =location;
        this.Approval= false;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getSkill() {
        return skill;
    }

}
