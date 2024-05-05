package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.Date;

public class Admin extends Member{

    public Admin(String name, LocalDateTime date, int skill) {
        super(name, date, skill);
    }

    public Admin(String name, LocalDateTime date) {
        super(name, date);
    }
    

}
