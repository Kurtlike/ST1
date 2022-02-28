package Unbelievable.ship.controls;

import Unbelievable.ship.controls.ControlLevers;
import Unbelievable.ship.controls.SteeringWheel;

public class Bridge {
    public SteeringWheel steeringWheel;
    public ControlLevers controlLevers;
    private Navigation navigation;
    public Bridge(SteeringWheel steeringWheel, ControlLevers controlLevers, double maxXAcceleration, double maxYAcceleration, double maxZAcceleration) {
        navigation = new Navigation(maxXAcceleration, maxYAcceleration, maxZAcceleration);
        this.steeringWheel = steeringWheel;
        this.controlLevers = controlLevers;
    }
}
