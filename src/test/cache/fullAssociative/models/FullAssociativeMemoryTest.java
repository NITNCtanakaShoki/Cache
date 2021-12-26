package test.cache.fullAssociative.models;

import static org.junit.jupiter.api.Assertions.*;
import main.cache.fullAsociative.models.FullAssociativeMemory;
import main.cache.models.BlockCount;
import main.cache.models.CacheAddress;
import main.cache.models.WordCountPerBlock;
import org.junit.jupiter.api.Test;

public class FullAssociativeMemoryTest {
    @Test
    public void memoryTest() {
        var memory = new FullAssociativeMemory(new BlockCount(4), new WordCountPerBlock(8));
        assertFalse(memory.isHit(CacheAddress.create(0)));

        memory = memory.recorded(CacheAddress.create(0));
        assertTrue(memory.isHit(CacheAddress.create(0)));

        assertFalse(memory.isHit(CacheAddress.create(8)));
        memory = memory.recorded(CacheAddress.create(8));
        assertTrue(memory.isHit(CacheAddress.create(0)));
        assertTrue(memory.isHit(CacheAddress.create(8)));

        assertFalse(memory.isHit(CacheAddress.create(16)));
        memory = memory.recorded(CacheAddress.create(16));
        assertTrue(memory.isHit(CacheAddress.create(0)));
        assertTrue(memory.isHit(CacheAddress.create(8)));
        assertTrue(memory.isHit(CacheAddress.create(16)));


        assertFalse(memory.isHit(CacheAddress.create(24)));
        memory = memory.recorded(CacheAddress.create(24));
        assertTrue(memory.isHit(CacheAddress.create(0)));
        assertTrue(memory.isHit(CacheAddress.create(8)));
        assertTrue(memory.isHit(CacheAddress.create(16)));
        assertTrue(memory.isHit(CacheAddress.create(24)));

        assertFalse(memory.isHit(CacheAddress.create(64)));
        memory = memory.recorded(CacheAddress.create(64));
        assertFalse(memory.isHit(CacheAddress.create(0)));
        assertTrue(memory.isHit(CacheAddress.create(8)));
        assertTrue(memory.isHit(CacheAddress.create(16)));
        assertTrue(memory.isHit(CacheAddress.create(24)));
        assertTrue(memory.isHit(CacheAddress.create(64)));
    }
}
