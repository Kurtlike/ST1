package Unbelievable.ship.controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControlLeversTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    void changeSpeed() {
        Navigation navigation = new Navigation(10, 3, 3);
        ControlLevers controlLevers = new ControlLevers();
        controlLevers.changeSpeed(10,10,10, navigation);
        controlLevers.changeSpeed(10,10,10, navigation);
        assertEquals("Курс построен, выход на заданный курс произойдет через "+ 10/3d +" секунд\n" +
                        "Курс построен, выход на заданный курс произойдет через "+ 0.0 +" секунд\n",
                output.toString());

    }

    @Test
    void stop() {
        Navigation navigation = new Navigation(10, 3, 3);
        ControlLevers controlLevers = new ControlLevers();
        navigation.changeSpeed(10,10,10);
        controlLevers.stop(navigation);

        assertEquals("Корабль остановится через "+ 10/3d +" секунд\n",
                output.toString());
    }
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}