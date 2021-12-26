package test.processor;

import main.cache.models.CacheAddress;
import main.models.AddressList;
import main.processor.CacheProcessor;
import main.processor.Cacheable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CacheProcessorTest {
    static class Cash implements Cacheable {
        public int hitRatio() {
            return 90;
        }
        public String title() {
            return "Mock";
        }
        public Cacheable cache(CacheAddress address) {
            return new Cash();
        }
    }

    private AddressList addressList;
    private CacheProcessor processor;

    @BeforeEach
    public void setUp() {
        addressList = AddressList.create(
                new int[]{0, 8, 16, 64, 129, 69}
        );
        processor = new CacheProcessor(new Cash(), addressList);
    }

    @Test
    public void processTest() {
        assertEquals(processor.hitRatio(), 90);
        assertEquals("Mockのヒット率は90%", processor.result());
    }
}