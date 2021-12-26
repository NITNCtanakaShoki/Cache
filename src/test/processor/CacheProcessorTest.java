package test.processor;

import main.cache.models.CacheAddress;
import main.models.Address;
import main.processor.CacheProcessor;
import main.processor.Cacheable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CacheProcessorTest {
    static class Cash implements Cacheable {
        public int hitRatio() {
            return 90;
        }

        public Cacheable cache(CacheAddress address) {
            return new Cash();
        }
    }

    private ArrayList<Address> addressList;
    private CacheProcessor processor;

    @BeforeEach
    public void setUp() {
        addressList = new ArrayList<>();
        addressList.add(new Address(1234));
        addressList.add(new Address(2333));
        addressList.add(new Address(109));

        processor = new CacheProcessor(new Cash(), addressList);
    }

    @Test
    public void processTest() {
        assertEquals(processor.hitRatio(), 90);
    }
}