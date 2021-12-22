package test.processor;
import main.models.Address;
import main.processor.CashProcessor;
import main.processor.Cashable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CashProcessorTest {
    class Cash implements Cashable {
        public int hitRatio() {
            return 90;
        }

        public Cashable cash(Address address) {
            return new Cash();
        }
    }

    private ArrayList<Address> addressList;
    private CashProcessor processor;

    @BeforeEach
    public void setUp() {
        addressList = new ArrayList<Address>();
        addressList.add(new Address(1234));
        addressList.add(new Address(2333));
        addressList.add(new Address(109));

        processor = new CashProcessor(new Cash(), addressList);
    }

    @Test
    public void processTest() {
        assertEquals(processor.hitRatio(), 90);
    }
}