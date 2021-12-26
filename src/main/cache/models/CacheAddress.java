package main.cache.models;

import main.models.Address;

import java.util.Objects;

public class CacheAddress {
    private final Address address;
    public CacheAddress(Address address) {
        this.address = address;
    }
    public static CacheAddress create(int addressNumber) {
        return new CacheAddress(new Address(addressNumber));
    }
    public CacheAddress representativeAddress(WordCountPerBlock count) {
        return create(address.asInteger() / count.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheAddress that = (CacheAddress) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
