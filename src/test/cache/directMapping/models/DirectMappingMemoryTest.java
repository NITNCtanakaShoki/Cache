package test.cache.directMapping.models;
import static org.junit.jupiter.api.Assertions.*;

import main.cache.directMapping.models.DirectMappingAddress;
import main.cache.directMapping.models.DirectMappingMemory;
import main.cache.models.BlockCount;
import main.cache.models.WordCountPerBlock;
import org.junit.jupiter.api.Test;

public class DirectMappingMemoryTest {
    @Test
    public void memoryTest() {
        var memory = new DirectMappingMemory(new BlockCount(4), new WordCountPerBlock(8));
        assertFalse(memory.isHit(DirectMappingAddress.create(1234)));

        memory = memory.recorded(DirectMappingAddress.create(1234));
        assertTrue(memory.isHit(DirectMappingAddress.create(1234)));

        assertFalse(memory.isHit(DirectMappingAddress.create(1)));
        memory = memory.recorded(DirectMappingAddress.create(1));
        assertTrue(memory.isHit(DirectMappingAddress.create(1)));
        assertTrue(memory.isHit(DirectMappingAddress.create(1234)));

        assertFalse(memory.isHit(DirectMappingAddress.create(16)));
        memory = memory.recorded(DirectMappingAddress.create(16));
        assertTrue(memory.isHit(DirectMappingAddress.create(16)));
        assertTrue(memory.isHit(DirectMappingAddress.create(1)));
        assertFalse(memory.isHit(DirectMappingAddress.create(1234)));
    }
}
