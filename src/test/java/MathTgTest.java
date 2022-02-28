import math.MathTg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MathTgTest {

    @Test
    void tg() {
        MathTg mTg = new MathTg();
        ArrayList<Double> actual = new ArrayList<>();
        actual.add(mTg.tg(3 * Math.PI/2));
        actual.add(mTg.tg(-Math.PI/2));
        actual.add(mTg.tg(-2 * Math.PI));
        actual.add(mTg.tg(0));
        actual.add(mTg.tg(Math.PI/4));
        actual.add(mTg.tg(Math.PI * 5 - Math.PI/4));
        ArrayList<Double> expected = new ArrayList<>();
        expected.add(Double.NaN);
        expected.add(Double.NaN);
        expected.add(0d);
        expected.add(0d);
        expected.add(1d);
        expected.add(-1d);
        assertEquals(expected, actual);
    }
    @Test
    void tgRange() {
        MathTg mTg = new MathTg();

        assertTrue(isInRange(Double.NaN, 0, mTg.tg(3 * Math.PI/2)));
        assertTrue(isInRange(Double.NaN, 0, mTg.tg(-Math.PI/2)));
        assertTrue(isInRange(0d, 0, mTg.tg(-2 * Math.PI)));
        assertTrue(isInRange(0d, 0, mTg.tg(0)));
        assertTrue(isInRange(1.0, 0.1, mTg.tg(Math.PI/4)));
        assertTrue(isInRange(-1.0, 0.1, mTg.tg(Math.PI * 5 - Math.PI/4)));

    }
    boolean isInRange(double expected, double accuracy, double actual){
        if(Double.isNaN(expected) && Double.isNaN(actual)) return true;
        return (actual >= expected - accuracy) && (actual <= expected + accuracy);
    }
}