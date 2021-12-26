package main.processor;

import main.cache.models.CacheAddress;
import main.models.Address;
import java.util.ArrayList;

public class CacheProcessor {
    private final Cacheable cacheable;
    private final ArrayList<Address> addresses;
    public CacheProcessor(Cacheable cacheable, ArrayList<Address> addresses) {
        this.cacheable = cacheable;
        this.addresses = addresses;
    }
    public int hitRatio() {
        var store = cacheable;
        for (var address: addresses) {
            store = store.cache(new CacheAddress(address));
        }
        return store.hitRatio();
    }
}
