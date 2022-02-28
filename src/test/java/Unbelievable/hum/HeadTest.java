package Unbelievable.hum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HeadTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    void getSmiled() {
        AbstractHumanoid artur = new Human("Артур");
        artur.heads.get(0).getSmiled();
        assertEquals("""
                        Артур улыбнулся
                        """,
                output.toString());
    }

    @Test
    void getSurprised() {
        AbstractHumanoid artur = new Human("Артур");
        artur.heads.get(0).getSurprised();
        assertEquals("""
                        Артур удивился
                        """,
                output.toString());
    }
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}