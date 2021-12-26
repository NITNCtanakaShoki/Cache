package main.processor;

import main.cache.models.CacheAddress;

public interface Cacheable {
    int hitRatio();
    Cacheable cache(CacheAddress address);
}
