package test.cache.fullAssociative;

import main.cache.fullAsociative.FullAssociativeCache;
import main.cache.models.BlockCount;
import main.cache.models.CacheAddress;
import main.cache.models.WordCountPerBlock;
import main.processor.Cacheable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FullAssociativeCacheTest {
    @Test
    public void cashTest() {
        Cacheable cache = new FullAssociativeCache(new WordCountPerBlock(8), new BlockCount(4));
        cache = cache.cache(CacheAddress.create(1234));
        assertEquals(0, cache.hitRatio());

        cache = cache.cache(CacheAddress.create(1235));
        assertEquals(50, cache.hitRatio());

        cache = cache.cache(CacheAddress.create(0));
        assertEquals(33, cache.hitRatio());

        cache = cache.cache(CacheAddress.create(128));
        assertEquals(25, cache.hitRatio());

        cache = cache.cache(CacheAddress.create(0));
        assertEquals(40, cache.hitRatio());

    }
}
