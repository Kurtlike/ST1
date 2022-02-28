package Unbelievable.ship.controls;

public class SteeringWheel {
    public void turn(double xDegrees, double zDegrees, Navigation navigation){
        double time = navigation.changeSpeedVector(degreesToRadians(xDegrees), degreesToRadians(zDegrees));
        System.out.println("Курс построен, выход на заданный курс произойдет через " + time + " секунд");
    }
    private double degreesToRadians(double degrees){
        return degrees * Math.PI/180;
    }
}
