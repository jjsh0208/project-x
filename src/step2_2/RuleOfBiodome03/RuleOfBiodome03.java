package step2_2.RuleOfBiodome03;

import java.util.Scanner;

/*
1.
기존의 AllPurposeDevice 클래스의 activateFeature 메서드는 일반기기에서는 필요없는 기능이기 때문에 모든 기기가 가질필요는없다
고로 ISP 를 위반한다.

2.
또 AllPurposeDevice 클래스에서 DeviceDetails 클래스는 Device의 구현체가 아니지만 AllPurposeDevice에서는 구현체로 사용중입니다.
이는 LSP 를 위반한다.

3.
기존 Device 인터페이스는 기기의 전원 책임만 담당하지만 activateFeature 메서드로 기기를 활성화하는 책임도 가져
SRP 를 위반한다.
*/

public class RuleOfBiodome03 {
    static Scanner sc;
    static DeviceController dc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        dc = new DeviceController();

        while (true) {
            System.out.println("========================");
            System.out.println("1. 기기 추가");
            System.out.println("2. 기기 정보");
            System.out.println("3. 컨트롤러 기기 추가");
            System.out.println("4. 컨트롤러 조작");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                //기기 추가
                case 1:
                    addDevice();
                    break;
                //기기 정보 출력
                case 2:
                    deviceInfo();
                    break;
                case 3:
                    controllerAddDevice();
                    break;
                case 4:
                    deviceControl();
                    break;
                case 5:
                    dc.test();
                    break;
                default:
                    break;

            }
        }
    }

    private static void addDevice() {
        System.out.print("기기 이름 :");
        String model = sc.nextLine();
        System.out.println("기기의 종류는?  (1. 일반 기기 / 2. 스마트 기기)");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                dc.addDevice(new NormalDevice(model));
                break;
            case 2:
                System.out.println("기기의 특징을 입력 : ");
                String feature = sc.nextLine();
                dc.addDevice(new SmartDevice(model,feature));
                break;
            default:
                break;
        }
    }

    private static void deviceInfo() {
        System.out.println("정보를 확인할 기기 명 : ");
        String model = sc.nextLine();
        dc.deviceInfo(model);
    }


    private static void controllerAddDevice() {
        System.out.println("컨트롤러에 추가할 기기 이름 : ");
        String model = sc.nextLine();
        dc.controllerAddDevice(model);
    }


    private static void deviceControl() {
        int choice = 0;

        System.out.println("1. 기기활성화 / 2. 모든기기 전원 off / 3. 특정 기기 절전모드  / 4. 전체 기기 절전모드 ");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                System.out.println("조작할 기계명 : ");
                String model = sc.nextLine();
                dc.controlDevice(model);
                break;
            case 2:
                dc.powerOffAllDevices();
                break;
            case 3:
                System.out.println("조작할 기계명 : ");
                model = sc.nextLine();
                dc.powerSaving(model);
                break;
            case 4:
                dc.powerSaving();
                break;

            default:
                break;
            }
    }
}