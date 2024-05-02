package step1_2;

import java.util.LinkedList;

class MyStack{
    // 원래 ArrayList를 사용하여 stack을 구현하려 했지만, addFirst와 removeFirst 메서드들은
    // ArrayList에 존재하지 않고 LinkedList에서 제공됩니다. ArrayList에서 제공하는 add(0, element)와 remove(0) 메서드를
    // 사용해 처음 위치에 요소를 추가하거나 제거할 수는 있으나, 이러한 작업들은 ArrayList에서 O(n)의 시간 복잡도를 가지므로 비효율적입니다.
    // 따라서, O(1)의 시간 복잡도로 요소를 추가하고 제거할 수 있는 LinkedList로 구현 방식을 변경하였습니다.
    // 이는 전체적인 코드의 성능을 향상시키는 데 도움이 됩니다. (출처 : 뤼튼)

    //    static ArrayList<Character> stack; //기존코드
    static LinkedList<Character> stack; // LinkedList로 변경
    MyStack(){
//        stack = new ArrayList<>(); //기존 코드
        stack = new LinkedList<>();
    }

    public int size(){
        return stack.size();
    }

    // LinkedList의 addFirst 메소드를 사용하여 O(1) 시간 복잡도를 가짐
    public void push(char chars) {
        stack.addFirst(chars);
    }

    // LinkedList의 removeFirst 메소드를 사용하여 O(1) 시간 복잡도를 가짐
    public char pop() {
        return stack.removeFirst();
    }

    // LinkedList의 getLast 메소드를 사용하여 O(1) 시간 복잡도를 가짐
    public char peek(){
        return stack.getLast();
    }

    public boolean isEmpty(){
        if(stack.size() == 0) return  true;
        return false;
    }
}

public class RoadToBiodome02 {

    public static void main(String[] args) {
        //\\P{L} 유니코드(영어,한글)   \\p{N}은 유니코드(숫자) {2,1000000}은 문자열의 길이 최소 2부터 10^6까지의미
        //args[0]의 공백을 모두제거하고 args[0]값이 비었는지 체크 (공백만 입력된 경우)
        if(!args[0].matches("^[\\p{L}\\p{N}\\s]{2,1000000}$") ||
            args[0].trim().isEmpty()){
            System.out.println("입력된 메시지가 올바르지 않습니다. 다시 한번 확인해주세요.");
            return;
        }

        palindrome(args[0]);

        //스택은 후입선출
        char[] chars = args[0].toCharArray();
        MyStack stack = new MyStack();
        for(int i = 0; i < chars.length; i++){
             stack.push(chars[i]);
        }
        int initialSize = stack.size();
        for(int i = 0; i < initialSize; i++){
            System.out.print(stack.pop());
        }
    }

    private static void palindrome(String args) {
        //회문 테스트
        //역순 암호화를 진행시키든 시키지않은 변화가없다
        String str = args;
        str = str.toLowerCase();

        int len = str.length();

        for(int i = 0; i < len / 2; i++){
            if (str.charAt(i) == str.charAt(len - i - 1)) {
                System.out.println("회문 입니다.");
                return;
            }
        }
    }
}