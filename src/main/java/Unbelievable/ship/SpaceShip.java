package Unbelievable.ship;

import Unbelievable.hum.AbstractHumanoid;
import Unbelievable.ship.controls.Bridge;
import Unbelievable.ship.controls.ControlLevers;
import Unbelievable.ship.controls.Navigation;
import Unbelievable.ship.controls.SteeringWheel;

public class SpaceShip {
    public SpaceShip(AbstractHumanoid capitan, double maxXAcceleration, double maxYAcceleration, double maxZAcceleration) {
        this.capitan = capitan;
        bridge = new Bridge(new SteeringWheel(), new ControlLevers(),maxXAcceleration, maxYAcceleration, maxZAcceleration);
    }

    private AbstractHumanoid capitan;
    private Bridge bridge;
}
