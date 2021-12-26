package main.processor;

import main.cache.models.CacheAddress;
import main.models.AddressList;

public class CacheProcessor {
    private final Cacheable cacheable;
    private final AddressList addressList;
    public CacheProcessor(Cacheable cacheable, AddressList addressList) {
        this.cacheable = cacheable;
        this.addressList = addressList;
    }
    public int hitRatio() {
        var store = cacheable;
        for (int i = 0; i < addressList.count(); i++) {
            store = store.cache(new CacheAddress(addressList.at(i)));
        }
        return store.hitRatio();
    }
}
