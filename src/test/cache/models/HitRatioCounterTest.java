package test.cache.models;

import main.cache.models.HitRatioCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HitRatioCounterTest {
    @Test
    public void countTest() {
        var counter = new HitRatioCounter();
        assertEquals(-1, counter.hitRatio());

        counter = counter.hitCount();
        assertEquals(100, counter.hitRatio());

        counter = counter.missHitCount();
        assertEquals(50, counter.hitRatio());

    }
}
