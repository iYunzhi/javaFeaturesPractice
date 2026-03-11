package quizForEnum;

public enum SensorType {
    TEMPERATURE(0.1,"℃"),
    PRESSURE(0.01,"MPa"),
    HUMIDITY(0.5,"%RH");

    private final double scale;
    private final String unit;

    SensorType(double scale, String unit) {
        this.scale = scale;
        this.unit = unit;
    }

    public double transform(int rawValue){
        return rawValue * this.scale;
    }

    public double getScale() {
        return scale;
    }

    public String getUnit() {
        return unit;
    }
}
