package test.cash.directMapping.models;
import static org.junit.jupiter.api.Assertions.*;

import main.cash.directMapping.models.DirectMappingAddress;
import main.cash.models.BlockCount;
import main.models.Address;
import org.junit.jupiter.api.Test;

public class DirectMappingAddressTest {
    @Test
    public void addressBlockTest() {
        var address = new Address(1234);
        var directMappingAddress =  new DirectMappingAddress(address);

        assertEquals(2, directMappingAddress.block(4, 8));

        directMappingAddress = new DirectMappingAddress(new Address(1));
        assertEquals(0, directMappingAddress.block(4, 8));

    }
    @Test
    public void createTest() {
        var address = DirectMappingAddress.create(1234);
    }

    @Test
    public void representativeAddressTest() {
        var address = DirectMappingAddress.create(1235);
        var represent = address.representativeAddress(new BlockCount(4));
        assertEquals(DirectMappingAddress.create(308), represent);
    }
}
