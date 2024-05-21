package step3_1.BiodomeForever08;

public class EnvironmentData {
    private String date;
    private double oxygenLevel;  //산소 농도
    private double humidity; //습도
    private double  temperature; //온도

    public EnvironmentData(String date, double oxygenLevel , double humidity, double temperature ) {
        this.date = date;
        this.oxygenLevel = oxygenLevel;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return this.date + ", "+this.oxygenLevel+", "+this.humidity+", "+this.temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double     getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(float oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
