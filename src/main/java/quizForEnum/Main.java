package quizForEnum;

public class Main {
    public static void main(String[] args) {
        int rawValue = 256;
        double transform = SensorType.HUMIDITY.transform(rawValue);
        System.out.println(transform + SensorType.HUMIDITY.getUnit());
    }
}
