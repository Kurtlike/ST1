package Unbelievable.hum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    void teethClean() {
        AbstractHumanoid artur = new Human("Артур");
        artur.hands.get(0).teethClean(0);
        artur.hands.get(1).teethClean(1);
        assertEquals("""
                        левая рука Артур ковыряется в зубах единственная головы
                        правая рука Артур ковыряется в зубах воображаемой головы
                        """,
                output.toString());
    }
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}