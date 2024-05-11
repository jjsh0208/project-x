package step2_2.RuleOfBodome03;

import java.util.ArrayList;

public interface DeviceManager {
    ArrayList<Device> devices = new ArrayList<>();

    default Device deviceCheck(String model){
        for (Device device : devices){
            if (device instanceof NormalDevice && ((NormalDevice) device).getModel().equals(model)){
                return device;
            }
            if (device instanceof SmartDevice && ((SmartDevice) device).getModel().equals(model)){
                return device;
            }
        }
        return null;
    }

    default void deviceInfo(String model) {
        Device device = deviceCheck(model);
        if (device != null ){
            if (device instanceof  NormalDevice) ((NormalDevice) device).displayInfo();
            if (device instanceof  SmartDevice) ((SmartDevice) device).displayInfo();
            return;
        }
        System.out.println("존재하지않는 기기 입니다.");
    }

    default void  addDevice(Device device){
        devices.add(device);
    }
}
