# 문제01 밥 아저씨의 도움이 필요한 순간
* Java 2팀 전승현

### 목차
#### SOLID 원칙의 등장과 필요성<br>
로버트 마틴이 2000년 초반에 명명한 객체 지향 프로그래밍 및 설계의 다섯가지 기본 원칙을 <br>
마이클 페더스가 두문자어 기억술로 소개한 것이다. 프로그래머가 시간이 지나도 유지 보수와 <br>
확장이 쉬운 시스템을 만들고자 할 때 이원칙들을 함께 적용할 수 있다.<br><br>
소스코드를 읽기 쉽고 확장하기 쉽게 될 때까지 리펙터링하여 코드 냄새를 제거하기 위해 적용<br>
할 수 있는 지침이다.


<hr>

#### 다섯가지 원칙 소개<br>
- SRP (Single Responsibility Principle) 단일 책임 원칙 <br>
  -한 클래스는 하나의 책임만 가져야한다. 
  - 클래스를 변경하는 이유도 단 하나여야한다.
  - 이를 지키지않으면 한 책임의 변경에 의해 다른책임과 관련된 코드에 영향을 미칠 수있다.(유지보수 비효율적)
- OCP (Open/Closed Principle) 개방-폐쇄의 원칙<br>
  - 소포트 웨어 요소는 확장에는 열려있으나 변경에는 닫혀 있어야한다.
  - 즉, 기존 코드를 변경하지않고 기능을 수정하거나 추가할 수 있도록 설계해야한다.
  - 이를 지키지않으면 instanceof 와 같은 연산자를 사용하거나, 다운 캐스팅 발생
- LSP (Liskov substitution principle) 리스코프 치환 원칙<br>
  - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야한다.
  - 하위 타입의 객체는 상위 타입에서 가능한 행위를 수행할 수 있어야함
  - 즉, 상위 타입 객체를 하위 타입객체로 치환해도 정상적으로 동작해야함
  - 상속관계에서는 꼭 일반화 관계가 성립해야한다는 의미(일관성있는 관계인지 확인)
  - 상속관계가 아닌 클래스들을 상속관계로 설정하면, 이 원칙이 위배됨(재사용 목적으로 사용하는 경우)
  - 결론적으로 리스코프 치환 원칙을 지키지않으면 개방-폐쇄의 원칙을 위반하게된다
- ISP (Interface Segregation) 인터페이스 분리 원칙<br>
  - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
  - 클라이언트는 자신이 사용하는 메서드에만 의존해야한다는 원칙
  - 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 않아야한다.
  - 애매하게 하나의 통상적인 인터페이스보다는 차라리 여러 개의 세부적인(구체적) 인터페이스가 낫다
  - 인터페이스는 해당 인터페이스를 사용하는 클라이언트를 기준으로 잘게 분리되어야 함
  - 인터페이스를 분리함으로 써 사용하지않는 인터페이스에 변경이 발생하더라도 영향을 받지않도록 한다.
- DIP (Dependency inversion Principle) 의존관계 역전 원칙<br>
  - 프로그래머는 추상화에 의존해야지, 구체화에 의존하면 안된다. 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
  - 의존 관계를 맺을 때, 변하기 쉬운것 (구체적인 것 )보다는 변하기 어려운 것(추상적인 것)에 의존해야함
  - 구체화된 클래스에 의존하기보다 추상클래스나 인터페이스에 의존해야한다는 뜻
  - 즉, 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안됨
  - 저수준 모듈이 고수준 모듈에서 정의한 추상 타입에 의존해야한다
  - 저수준 모듈이 변경되더라도 고수준 모듈은 변경이 필요없는 형태가 이상적이다.
<hr>

#### 요약
SRP와 ISP는 객체가 커지는 것을 막아준다. 한 기능의 변경이 다른 곳까지 미치는 영향을 최소화하고,<br>
이는 기능 추가 및 변경에 용이하도록 만들어준다.
<br><br>
LSP와 DIP는 OCP를 서포트한다. 변화되는 부분을 추상화 할 수 있도록 도와주는 원칙이 DIP 이고,<br>
다형성 구현을 도와주는 원칙이 LSP이다.

<hr>

#### 도서관 시스템에서 SOLID 원칙에 어긋나는 부분
``` 
abstract class User { //사용자 관리 이외에도 도서관리 기능도 포함되어 SRP 원칙을 위배
    public String userId;
    public String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void borrowBook(Book book) { // OCP 원칙 위반 (다른 객체의 요소를 직접적으로 변경하면 안된다.)
        if(!book.isBorrowed) {
            book.isBorrowed = true;
        }
    }

    public void returnBook(Book book) { // OCP 원칙 위반 (다른 객체의 요소를 직접적으로 변경하면 안된다.)
        if(book.isBorrowed) {
            book.isBorrowed = false;
        }
    }
    
    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);
    
    //Book 클래스에도 의존하고있음으로 DIP 원칙을 위반할 수 있다.
    
}
```
<br>

```
class Member extends User {
    public Member(String userId, String name) {
        super(userId, name);
    }

    public void addBook(Book book, Library library) { //ISP 위반 (필요없는 기능까지 추상 클래스에서 받아 재정의할 필요없이 추상클래스를 분할하는것이 좋다)
        System.out.println("Member can't add book");
    }
    public void removeBook(Book book, Library library) { //ISP 위반 (필요없는 기능까지 추상 클래스에서 받아 재정의할 필요없이 추상클래스를 분할하는것이 좋다)
        System.out.println("Member can't remove book");
    }
}
```
<hr>

### Bobus

```
 public static int[][] extractNumbersBonus(String args) {
        String[] parts = args.split("], \\[");
        parts[0] = parts[0].substring(1); // 첫 번째 '[' 제거
        parts[parts.length - 1] = parts[parts.length - 1].substring(0, parts[parts.length - 1].length() - 1); // 마지막 ']' 제거


        // 문자열을 정수 배열로 변환합니다.
        int[][] array = new int[parts.length][];

        for (int i = 0; i < parts.length; i++) {
            // 각 부분을 쉼표로 나누고, 결과를 정수 배열로 변환하여 저장합니다.
            array[i] = Arrays.stream(parts[i].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 선택정렬로 정렬합니다.
            for (int j = 0; j < array[i].length - 1; j++) {
                int minIndex = j;
                for (int k = j + 1; k < array[i].length; k++) {
                    if (array[i][k] < array[i][minIndex]) { // 오름차순
                        minIndex = k;
                    }
                }
                // 최소값을 현재 위치로 교환
                int temp = array[i][j];
                array[i][j] = array[i][minIndex];
                array[i][minIndex] = temp;
            }
        }

        return array;
    }

```
4번 문제 
한 클래스 내에서 여러 기능을 가지고있어 SRP 를 위반<br>
정렬 방식이나 다른 종류의 평균 계산 등 직접적으로 다른 객체를 변경하기 때문에 OCP를 위반하고있습니다.