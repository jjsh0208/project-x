package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.Date;

public class RegularMember extends  Member{

    public RegularMember(String name, LocalDateTime date, int skill) {
        super(name, date, skill);
    }

    public RegularMember(String name, LocalDateTime date) {super(name, date);}

}
