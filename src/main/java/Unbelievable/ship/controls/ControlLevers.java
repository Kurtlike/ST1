package Unbelievable.ship.controls;

public class ControlLevers {
    public void changeSpeed(double x, double y, double z, Navigation navigation){
        double time = navigation.changeSpeed(x, y, z);
        System.out.println("Курс построен, выход на заданный курс произойдет через " + time + " секунд");
    }
    public void stop(Navigation navigation){
        double time = navigation.stop();
        System.out.println("Корабль остановится через " + time + " секунд");
    }
}
