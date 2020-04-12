import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

    private Integer[] random;
    private Integer[] correct;

    public PriorityQueueTest(Integer[] random, Integer[] correct) {
        this.random = random;
        this.correct = correct;
    }

    @Parameterized.Parameters
    public static Collection collection() {
        return Arrays.asList(new Integer[][][] {
                { {1, 2, 3} , { 1, 3, 2} },
                { {2, 1, 3} , { 1, 2, 3} },
                { {2, 3, 1} , { 1, 2, 3} },
                { {1, 3, 2} , { 1, 2, 3} },
                { {3, 2, 1} , { 1, 2, 3} },
        });
    }

    @Test
    public void PriorityQueue() {
        PriorityQueue pq = new PriorityQueue();
        pq.addAll(Arrays.asList(random));
        assertEquals(pq.size(), correct.length);
        for (int i=0; i<correct.length; i++) {
            assertEquals(pq.poll(), correct[i]);
        }
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerException() {
        PriorityQueue pq = new PriorityQueue();
        Arrays arrays = null;
        pq.addAll((Collection) arrays);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerException2() {
        PriorityQueue pq = new PriorityQueue<Integer>();
        Integer num = null;
        pq.offer(num);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentException() {
        PriorityQueue pq = new PriorityQueue();
        pq.addAll(pq);
    }
}

