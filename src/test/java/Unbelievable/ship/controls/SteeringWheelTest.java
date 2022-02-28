package Unbelievable.ship.controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SteeringWheelTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    void turn() throws IOException {
        Navigation navigation = new Navigation(10, 3, 3);
        navigation.changeSpeed(10, 0, 0);
        SteeringWheel wheel = new SteeringWheel();
        wheel.turn(90,0,navigation);
        navigation.changeSpeed(10, 0, 0);
        wheel.turn(0,90,navigation);
        assertEquals("Курс построен, выход на заданный курс произойдет через "+ 10/3d +" секунд\n" +
                "Курс построен, выход на заданный курс произойдет через "+ Math.cos(Math.PI/2) * 10/3 +" секунд\n",
                output.toString());

    }
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

}