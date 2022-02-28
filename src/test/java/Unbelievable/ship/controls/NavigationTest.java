package Unbelievable.ship.controls;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NavigationTest {

    @Test
    void changeSpeedVector() {
        Navigation navigation = new Navigation(10, 3, 3);
        navigation.changeSpeed(10, 0, 0);
        assertTrue(isInRange(Math.cos(Math.PI/4) * 10/3d, 0.1, navigation.changeSpeedVector(Math.PI/4, Math.PI/4)));
        navigation.changeSpeed(10, 0, 0);
        assertTrue(isInRange(10/3d, 0.1, navigation.changeSpeedVector(0, 0)));
        navigation.changeSpeed(10, 0, 0);
        assertTrue(isInRange(0d, 0.1, navigation.changeSpeedVector(0, Math.PI/2)));
        navigation.changeSpeed(10, 0, 0);
        assertTrue(isInRange(Math.cos(10) * 10/3d * -1, 0.1, navigation.changeSpeedVector(10, 10)));
    }

    @Test
    void stop() {
        Navigation navigation = new Navigation(10, 3, 3);
        navigation.changeSpeed(10, 0, 0);
        assertTrue(isInRange(1, 0.0, navigation.stop()));
    }

    @Test
    void changeSpeed() {
        Navigation navigation = new Navigation(10, 3, 3);
        assertTrue(isInRange(1, 0.0, navigation.changeSpeed(10, 0, 0)));
        assertTrue(isInRange(10, 0.0, navigation.getXSpeed()));
        assertTrue(isInRange(10/3d, 0.1, navigation.changeSpeed(10, 10, 0)));
        assertTrue(isInRange(10, 0.0, navigation.getYSpeed()));
        assertTrue(isInRange(10/3d, 0.1, navigation.changeSpeed(10, 10, 10)));
        assertTrue(isInRange(10, 0.0, navigation.getZSpeed()));
        assertTrue(isInRange(10/3d, 0.1, navigation.changeSpeed(0, 0, 0)));
        assertTrue(isInRange(0, 0.0, navigation.getYSpeed()));
        assertTrue(isInRange(1, 0.0, navigation.changeSpeed(-10, 0, 0)));
        assertTrue(isInRange(-10, 0.0, navigation.getXSpeed()));
    }
    boolean isInRange(double expected, double accuracy, double actual){
        if(Double.isNaN(expected) && Double.isNaN(actual)) return true;
        return (actual >= expected - accuracy) && (actual <= expected + accuracy);
    }
}