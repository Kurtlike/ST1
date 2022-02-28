import fibonacci.FibHeap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class FibHeapTest {

    @Test
    void fibHeapTest() {
        FibHeap testQueue = new FibHeap();
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        Throwable thrown = assertThrows(NumberFormatException.class, testQueue::extractMin);
        assertNotNull(thrown);

        testQueue.add(0);
        actual.add(testQueue.extractMin());
        expected.add(0);

        for (int i = 10; i > -11; i--)testQueue.add(i);
        for (int i = 10; i > -11; i-=2)testQueue.add(i);
        for (int i = 0; i < 32; i++)actual.add(testQueue.extractMin());
        for (int i = -10; i < 11; i++){
            expected.add(i);
            if(i % 2 == 0) expected.add(i);
        }

        Queue<Integer> cleanQueue = new PriorityQueue<>();

        for (int i = -20; i < 20; i++)testQueue.add(i);
        for (int i = -20; i < 20; i+=2)testQueue.add(i);
        for (int i = 0; i < 60; i++)actual.add(testQueue.extractMin());

        for (int i = -20; i < 20; i++)cleanQueue.add(i);
        for (int i = -20; i < 20; i+=2)cleanQueue.add(i);
        for (int i = 0; i < 60; i++)expected.add(cleanQueue.poll());
        assertEquals(expected, actual);
    }
}
