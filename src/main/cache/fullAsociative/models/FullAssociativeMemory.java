package main.cache.fullAsociative.models;

import main.cache.models.BlockCount;
import main.cache.models.CacheAddress;
import main.cache.models.WordCountPerBlock;
import java.util.ArrayList;

public class FullAssociativeMemory {
    private final BlockCount blockCount;
    private final WordCountPerBlock wordCount;
    private final ArrayList<CacheAddress> memories;

    public FullAssociativeMemory(BlockCount blocks, WordCountPerBlock words) {
        blockCount = blocks;
        wordCount = words;
        memories = new ArrayList<>();
    }
    private FullAssociativeMemory(BlockCount blocks, WordCountPerBlock words, ArrayList<CacheAddress> memories) {
        blockCount = blocks;
        wordCount = words;
        this.memories = memories;
    }

    public boolean isHit(CacheAddress address) {
        return memories.contains(address.representativeAddress(wordCount));
    }

    public FullAssociativeMemory recorded(CacheAddress address) {
        if (isHit(address)) return this;
        return new FullAssociativeMemory(
                blockCount,
                wordCount,
                recordedMemory(address.representativeAddress(wordCount))
        );
    }

    private ArrayList<CacheAddress> recordedMemory(CacheAddress address) {
        return isRecordableWithoutDrop() ? recordedWithoutDrop(address) : recordedWithDrop(address);

    }
    private boolean isRecordableWithoutDrop() {
        return memories.size() < blockCount.value();
    }
    private ArrayList<CacheAddress> recordedWithoutDrop(CacheAddress address) {
        final var cloned = memoryClone();
        cloned.add(0, address);
        return cloned;
    }
    private ArrayList<CacheAddress> recordedWithDrop(CacheAddress address) {
        final var cloned = memoryClone();
        cloned.add(0, address);
        cloned.remove(cloned.size() - 1);
        return cloned;
    }
    private ArrayList<CacheAddress> memoryClone() {
        return (ArrayList<CacheAddress>) memories.clone();
    }

    @Override
    public String toString() {
        var result = "";
        for (var address: memories) {
            result += range(address) + ", ";
        }
        return result;
    }
    private String range(CacheAddress address) {
        final var start = address.asInteger() * wordCount.value();
        final var end = start + wordCount.value() - 1;
        return String.format("%d 〜 %d", start, end);
    }
}
