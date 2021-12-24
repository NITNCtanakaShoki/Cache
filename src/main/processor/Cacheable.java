package main.processor;

import main.models.Address;

public interface Cacheable {
    public int hitRatio();
    public Cacheable cache(Address address);
}
