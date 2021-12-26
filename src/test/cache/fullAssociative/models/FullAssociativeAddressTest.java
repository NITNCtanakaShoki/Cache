package test.cache.fullAssociative.models;

import main.cache.fullAsociative.models.FullAssociativeAddress;
import main.cache.models.WordCountPerBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullAssociativeAddressTest {
    @Test
    public void representativeAddressTest() {
        var address = FullAssociativeAddress.create(1235);
        var represent = address.representativeAddress(new WordCountPerBlock(8));
        assertEquals(FullAssociativeAddress.create(154), represent);
    }
}
