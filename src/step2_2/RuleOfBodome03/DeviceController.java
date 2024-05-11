package step2_2.RuleOfBodome03;

import java.util.ArrayList;


class DeviceController implements  DeviceManager{
    ArrayList<Device> controllers = new ArrayList<>();

    public void controllerAddDevice(String model){
        Device device = deviceCheck(model);
        if (device != null){
            if (controllers.contains(device)){
                System.out.println("이미 컨트롤러에 연결된 기기입니다.");
                return;
            }
            controllers.add(device);
            System.out.println("컨트롤러에 기기가 등록되었습니다 : "+ ((DeviceDetails) device).getModel());
            return;
        }
        System.out.println("존재하지않는 기기 입니다.");
    }

    public void controlDevice(String model) { //연결된 기기 전원 on 기기 활성화
        Device device = deviceCheck(model);

        if (device != null && controllers.contains(device)){
            if (device instanceof SmartDevice){
                ((SmartDevice) device).activateFeature();
                return;
            }
            device.powerOn();
            return;
        }
        System.out.println("컨트롤러에 추가되지 않는 기기 입니다.");
    }

    public void powerOffAllDevices() { //기기 전체 종료
        int cnt = 0;
        for (Device device : controllers) {
            device.powerOff();
            cnt++;
        }
        if (cnt == 0) System.out.println("컨트롤러에 추가되지 않는 기기 입니다.");
    }

    public void test(){
        for (Device device : controllers){
            System.out.println(device.toString());
        }
    }

    public void powerSaving(String model) {
        Device device = deviceCheck(model);

        if (device != null && controllers.contains(device)){
            device.PowerSavingMode();
            System.out.println("된다");
            return;
        }
        System.out.println("컨트롤러에 추가되지 않는 기기 입니다.");
    }

    public void powerSaving() {
        int cnt = 0;
        for (Device device : controllers) {
            device.PowerSavingMode();
            cnt++;
        }
        if (cnt == 0) System.out.println("컨트롤러에 연결된 기기가없습니다.");
    }
}