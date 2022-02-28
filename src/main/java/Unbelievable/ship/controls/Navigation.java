package Unbelievable.ship.controls;

public class Navigation {
    private double xSpeed, ySpeed, zSpeed;
    private final double  maxXAcceleration, maxYAcceleration, maxZAcceleration;

    protected Navigation(double maxXAcceleration, double maxYAcceleration, double maxZAcceleration) {
        this.maxXAcceleration = maxXAcceleration;
        this.maxYAcceleration = maxYAcceleration;
        this.maxZAcceleration = maxZAcceleration;
    }
    protected double changeSpeedVector(double fiRadian, double tetRadian){
        double linearSpeed = Math.sqrt(Math.pow(xSpeed,2) + Math.pow(ySpeed,2) + Math.pow(zSpeed,2));
        double newXsp = linearSpeed * Math.cos(fiRadian);
        double newYsp = linearSpeed * Math.sin(fiRadian);
        double newZsp = linearSpeed * Math.cos(tetRadian);
        return changeSpeed(newXsp, newYsp, newZsp);
    }
    protected double stop(){
        return changeSpeed(0,0,0);
    }

    protected double changeSpeed(double x, double y, double z){
        double maxTime = 0;
        double time = Math.abs((x - xSpeed)/maxXAcceleration);
        if (time > maxTime) maxTime = time;
        time = Math.abs((y - ySpeed)/maxYAcceleration);
        if (time > maxTime) maxTime = time;
        time = Math.abs((z - zSpeed)/maxZAcceleration);
        if (time > maxTime) maxTime = time;
        xSpeed = x;
        ySpeed = y;
        zSpeed = z;
        return  maxTime;
    }
    protected double getXSpeed() {
        return xSpeed;
    }

    protected double getYSpeed() {
        return ySpeed;
    }

    protected double getZSpeed() {
        return zSpeed;
    }

    protected double getMaxXAcceleration() {
        return maxXAcceleration;
    }

    protected double getMaxYAcceleration() {
        return maxYAcceleration;
    }

    protected double getMaxZAcceleration() {
        return maxZAcceleration;
    }

}
