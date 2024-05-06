package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;

public class Approval {
    private String name;
    private String location;
    private LocalDateTime localDateTime;

    public Approval(String name, String location, LocalDateTime localDateTime) {
        this.name = name;
        this.location = location;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "승인요청 : " +
                "이름='" + name + '\'' +
                ", 참여세션장소'" + location + '\'' +
                ", 참여세션날짜=" + localDateTime +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDate() {
        return localDateTime;
    }
}
