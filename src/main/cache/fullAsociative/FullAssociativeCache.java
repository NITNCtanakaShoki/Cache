package main.cache.fullAsociative;

import main.cache.fullAsociative.models.FullAssociativeMemory;
import main.cache.models.BlockCount;
import main.cache.models.CacheAddress;
import main.cache.models.HitRatioCounter;
import main.cache.models.WordCountPerBlock;
import main.processor.Cacheable;

public class FullAssociativeCache implements Cacheable {
    private final FullAssociativeMemory memory;
    private final HitRatioCounter counter;

    public FullAssociativeCache(WordCountPerBlock words, BlockCount blocks) {
        memory = new FullAssociativeMemory(blocks, words);
        counter = new HitRatioCounter();
    }

    private FullAssociativeCache(HitRatioCounter counter, FullAssociativeMemory memory) {
        this.counter = counter;
        this.memory = memory;
    }

    @Override
    public int hitRatio() {
        return counter.hitRatio();
    }

    @Override
    public Cacheable cache(CacheAddress address) {
        return new FullAssociativeCache(
                nextCounter(address),
                nextMemory(address)
        );
    }

    private FullAssociativeMemory nextMemory(CacheAddress address) {
        return memory.recorded(address);
    }
    private HitRatioCounter nextCounter(CacheAddress address) {
        return memory.isHit(address) ? counter.hitCount() : counter.missHitCount();
    }
}
