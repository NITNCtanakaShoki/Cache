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
    public void title() {
        assertEquals("フルアソシアティブ方式", FullAssociativeCache.create(8, 4).title());
    }
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

    @Test
    public void 更新() {
        Cacheable cache = new FullAssociativeCache(new WordCountPerBlock(8), new BlockCount(4));
        cache = cache.cache(CacheAddress.create(0));
        cache = cache.cache(CacheAddress.create(8));
        cache = cache.cache(CacheAddress.create(16));
        cache = cache.cache(CacheAddress.create(0));
        cache = cache.cache(CacheAddress.create(32));
        cache = cache.cache(CacheAddress.create(64));
        cache = cache.cache(CacheAddress.create(0));
        assertEquals(28, cache.hitRatio());
    }
}
