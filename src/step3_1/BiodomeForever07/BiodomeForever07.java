package step3_1.BiodomeForever07;

import java.util.Scanner;

public class BiodomeForever07 {
    //대부분의 입출력 스트림들은 파일에 순차적으로 입출력 작업을 수행한다.
    //RandomAccessFile class는 입출력 클래스 중 유일하게 파일에 대한 입력과 출력을 동시에 할 수 있는 클래스이다
    //RandomAccessFile 클래스는 파일만을 대상으로한다.
    //파일 포인터가 있어서 읽고 쓰는 위치의 이동이 가능하다. (seek 메소드를 활용)
    //순차적인 접근이 아닌 임의의 지접에 접근하여 작업을 수행하고 싶다면 사용하기 좋다.
    //RandomAccessFile 클래스의 생성자에는 인수로 파일의 이름뿐만 아니라 파일 모드까지 함께 전달해야한다.
    //r : 파일을 오로지 읽는 것만 가능한 모드로 개방한다.
    //re : 파일을 읽고 쓰는 것이 모두 가능한 모드로 개방함. 만약 파일이 없으면 새로운 파일을 생성한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EcoDataManager em = new EcoDataManager();

        while(true){
            System.out.println("환경 데이터 검색 프로그램을 시작합니다.");
            System.out.println("1. 환경 정보 검색");
            System.out.println("2. 환경 정보 저장");
            System.out.println("3. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요 : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("검색하고 싶은 날짜를 입력하세요: "); //예) 2130-08-01 00:00
                    String search = sc.nextLine();
                    em.read(search);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("저장할 날짜를 입력해주세요 : ");
                    String date = sc.nextLine();
                    em.write(date);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);

                    break;
                default:
                    break;
            }
        }

    }
}
