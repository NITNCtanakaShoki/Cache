package test.cache.models;

import main.cache.models.CacheAddress;
import main.cache.models.WordCountPerBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheAddressTest {
    @Test
    public void representativeAddressTest() {
        var address = CacheAddress.create(1235);
        var represent = address.representativeAddress(new WordCountPerBlock(8));
        assertEquals(CacheAddress.create(154), represent);
    }

    @Test
    public void asIntegerTest() {
        var address = CacheAddress.create(112);
        assertEquals(112, address.asInteger());
    }
}
