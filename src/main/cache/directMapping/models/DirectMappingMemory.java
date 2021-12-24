package main.cache.directMapping.models;

import main.cache.models.BlockCount;
import main.cache.models.WordCountPerBlock;

import java.util.HashMap;

public class DirectMappingMemory {
    private final HashMap<Integer,DirectMappingAddress> memories;
    private final BlockCount blocks;
    private final WordCountPerBlock words;
    public DirectMappingMemory(BlockCount blocks, WordCountPerBlock words) {
        memories = new HashMap<>();
        this.blocks = blocks;
        this.words = words;
    }
    private DirectMappingMemory(HashMap<Integer, DirectMappingAddress> memories, BlockCount blocks, WordCountPerBlock words) {
        this.memories = memories;
        this.blocks = blocks;
        this.words = words;
    }
    public boolean isHit(DirectMappingAddress address) {
        final var key = addressKey(address);
        if (!memories.containsKey(key)) return false;
        return memories.get(key).equals(address.representativeAddress(words));
    }
    public DirectMappingMemory recorded(DirectMappingAddress address) {
        if (isHit(address)) return this;
        var recordedMemories = memoryClone();
        recordedMemories.put(addressKey(address), address.representativeAddress(words));
        return new DirectMappingMemory(recordedMemories, blocks, words);
    }
    private Integer addressKey(DirectMappingAddress address) {
        return address.allocate(blocks, words);
    }
    private HashMap<Integer, DirectMappingAddress> memoryClone() {
        final var cloned = new HashMap<Integer, DirectMappingAddress>();
        for (var key: memories.keySet()) {
            cloned.put(key, memories.get(key));
        }
        return cloned;
    }
}
