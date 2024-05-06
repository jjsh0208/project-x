package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;

public class RegularMember extends  Member{

    public RegularMember(String name, LocalDateTime date, int skill) {
        super(name, date, skill);
    }

    public RegularMember(String name, LocalDateTime date) {super(name, date);}

    public RegularMember(String name, LocalDateTime date, int skill, String location) {
        super(name, date, skill, location);
    }
    public RegularMember(String name, LocalDateTime date,String location) {
        super(name, date, location);
    }
}
