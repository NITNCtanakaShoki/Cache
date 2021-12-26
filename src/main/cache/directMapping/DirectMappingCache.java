package main.cache.directMapping;

import main.cache.directMapping.models.DirectMappingAddress;
import main.cache.directMapping.models.DirectMappingMemory;
import main.cache.models.BlockCount;
import main.cache.models.CacheAddress;
import main.cache.models.HitRatioCounter;
import main.cache.models.WordCountPerBlock;
import main.processor.Cacheable;

public class DirectMappingCache implements Cacheable {
    private final DirectMappingMemory memory;
    private final HitRatioCounter counter;

    public DirectMappingCache(WordCountPerBlock words, BlockCount blocks) {
        memory = new DirectMappingMemory(blocks, words);
        counter = new HitRatioCounter();
    }

    private DirectMappingCache(HitRatioCounter counter, DirectMappingMemory memory) {
        this.counter = counter;
        this.memory = memory;
    }

    @Override
    public int hitRatio() {
        return counter.hitRatio();
    }

    @Override
    public Cacheable cache(CacheAddress address) {
        final var directMappingAddress = new DirectMappingAddress(address);
        return new DirectMappingCache(
                nextCounter(directMappingAddress),
                nextMemory(directMappingAddress)
        );
    }

    private DirectMappingMemory nextMemory(DirectMappingAddress address) {
        return memory.recorded(address);
    }
    private HitRatioCounter nextCounter(DirectMappingAddress address) {
        return memory.isHit(address) ? counter.hitCount() : counter.missHitCount();
    }
}
