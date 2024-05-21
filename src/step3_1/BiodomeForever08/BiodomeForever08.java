package step3_1.BiodomeForever08;


import java.util.Scanner;

public class BiodomeForever08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnvironmentDataManager em = new EnvironmentDataManager();

        System.out.println("환경 데이터 검색 및 수정 프로그램에 오신 것을 환영합니다!");
        while(true){
            System.out.print("검색하고 싶은 날짜를 입력하세요: ");
            String date = sc.nextLine();
            em.searchAndUpdate(date);
        }

    }
}
