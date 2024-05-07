package step1_2;

class  Queue{
    public  int Max = 10; //bonus : 10   기본문제 : 100
    public  int[] Q;
    //현재 인덱스 (큐의 현재 크기)
    public  int stack;
    //남아있는 큐의 제일 앞의 인덱스
    public  int front;

    Queue() {
        Q = new int[Max];
        stack = 0;
        front = 0;
    }
     Queue(int length) {
        if(length <= 10){
            this.Max = length;
            Q = new int[Max];
            stack = 0;
            front = 0;
        }
        else{
            this.Max += 10;
            Q = new int[Max];
            stack = 0;
            front = 0;
            System.out.println("Queue의 크기가 "+this.Max+"으로 늘어났습니다.");
        }
    }

    public void enqueue(int value){
        Q[stack] = value;
        stack++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("큐가 비었습니다.");
        }
        front++;
    }

    public boolean isEmpty(){
        if(front >= stack ) return  true;
        return  false;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return Q[front];
    }


    public  void front(){
         if(isEmpty() || isFull()){
             front -= 1;
             Max -= 1;
         }
    }
    public boolean isFull(){
        if(front>=Max){
            return true;
        }else
            return false;
    }


}

public class RoadToBiodome08 {
    public static void main(String[] args) {

        Queue queue = new Queue(args.length);

        for(int i = 0; i < args.length; i++){
            queue.enqueue(Integer.parseInt(args[i]));
        }
        while(!queue.isEmpty()) { // 큐가 비어있지 않는 동안 반복
            System.out.println("자원 제공: " +queue.peek()); // 큐의 맨 앞 요소를 출력
             queue.dequeue(); // 그 요소를 제거
        }

        // 위의 반복문을 빠져나오면 큐가 비어 있다는 의미이므로, 모든 요청이 처리됐다는 메시지를 출력
        System.out.println("모든 요청이 처리되었습니다.");




    }
}
