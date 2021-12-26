package main.processor;

import main.cache.models.CacheAddress;

public interface Cacheable {
    public int hitRatio();
    public Cacheable cache(CacheAddress address);
}
