package test.cache.directMapping.models;

import static org.junit.jupiter.api.Assertions.*;
import main.cache.directMapping.models.DirectMappingAddress;
import main.cache.models.BlockCount;
import main.cache.models.WordCountPerBlock;
import org.junit.jupiter.api.Test;

public class DirectMappingAddressTest {
    @Test
    public void createTest() {
        var address = DirectMappingAddress.create(1234);
    }

    @Test
    public void representativeAddressTest() {
        var address = DirectMappingAddress.create(1235);
        var represent = address.representativeAddress(new WordCountPerBlock(8));
        assertEquals(DirectMappingAddress.create(154), represent);
    }

    @Test
    public void 分類() {
        var address = DirectMappingAddress.create(1235);
        assertEquals(2, address.allocate(new BlockCount(4), new WordCountPerBlock(8)));
    }
}
