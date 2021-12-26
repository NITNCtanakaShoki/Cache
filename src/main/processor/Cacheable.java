package main.processor;

import main.cache.models.CacheAddress;

public interface Cacheable {
    String title();
    int hitRatio();
    Cacheable cache(CacheAddress address);
}
