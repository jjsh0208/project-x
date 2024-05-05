package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;

public class Member {
    private String name;
    private LocalDateTime date;
    private int skill;
    public Member(String name, LocalDateTime date, int skill) {
        this.name = name;
        this.date = date;
        this.skill = skill;
    }

    public Member(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
        this.skill = 0;
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
