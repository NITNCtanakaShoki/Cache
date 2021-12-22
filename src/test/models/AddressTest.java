package test.models;

import main.models.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    @Test
    public void equalsTest() {
        var address1 = new Address(1234);
        var address2 = new Address(1234);
        var address3 = new Address(1233);
        assertTrue(address1.equals(address2));
        assertFalse(address1.equals(address3));
    }
}
