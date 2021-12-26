package main.cache.fullAsociative.models;

import main.cache.directMapping.models.DirectMappingAddress;
import main.cache.models.BlockCount;
import main.cache.models.WordCountPerBlock;
import main.models.Address;

import java.util.Objects;

public class FullAssociativeAddress {
    private final Address address;
    public FullAssociativeAddress(Address address) {
        this.address = address;
    }
    public static FullAssociativeAddress create(int addressNumber) {
        return new FullAssociativeAddress(new Address(addressNumber));
    }
    public  FullAssociativeAddress representativeAddress(WordCountPerBlock count) {
        return create(address.asInteger() / count.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullAssociativeAddress that = (FullAssociativeAddress) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
