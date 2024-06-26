package step2_1.BiodomeFamily06;

public class Animal {
    private  String name;
    private  String type;
    private  int age;


    Animal(String name, String type, int age){
        this.name = name;
        this.type = type;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // toString 메서드 오버라이드
    @Override
    public String toString() {
        return name + "(" + type + ", " + age + "살)";
    }
}


