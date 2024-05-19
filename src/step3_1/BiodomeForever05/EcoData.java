package step3_1.BiodomeForever05;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EcoData implements Serializable {
    private String DateTime;
    private float  temperature; //온도
    private float humidity; //습도
    private float oxygenLevel;  //산소 농도
    private  String measurementLocation; // 측정 장소

    public EcoData(float temperature, float humidity, float oxygenLevel, String measurementLocation) {
        DateTime = formatDate();
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygenLevel = oxygenLevel;
        this.measurementLocation = measurementLocation;
    }

    private String formatDate (){
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = LocalDateTime.now().format(dateTimeFormatter);
        return date;
    }
    public String ecoDataInfo(){
        String DateTime = this.DateTime;
        float temperature = this.temperature;
        float humidity = this.humidity;
        float oxygenLevel = this.oxygenLevel;
        String measurementLocation = this.measurementLocation;
        String info = String.format("%s,%s°C,%s%% 습도,%s%% 산소농도,%s", DateTime,temperature,humidity,oxygenLevel,measurementLocation);
        return info;
    }

    public String getDateTime() {
        return DateTime;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getOxygenLevel() {
        return oxygenLevel;
    }

    public String getMeasurementLocation() {
        return measurementLocation;
    }
}
