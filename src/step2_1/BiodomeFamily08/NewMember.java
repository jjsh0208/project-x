package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.Date;

public class NewMember extends Member{

    public NewMember(String name, LocalDateTime date, int skill) {
        super(name, date, skill);
    }
    public NewMember(String name, LocalDateTime date) {
        super(name, date);
    }


}
