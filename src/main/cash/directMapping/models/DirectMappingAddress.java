package main.cash.directMapping.models;

import main.cash.models.BlockCount;
import main.models.Address;

import java.util.Objects;

public class DirectMappingAddress {
    private final Address address;
    public DirectMappingAddress(Address address) {
        this.address = address;
    }
    public Integer block(int blocks, int words) {
        return address.asInteger() / words % blocks;
    }
    public static DirectMappingAddress create(int addressNumber) {
        return new DirectMappingAddress(new Address(addressNumber));
    }
    public DirectMappingAddress representativeAddress(BlockCount count) {
        return create(address.asInteger() / count.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectMappingAddress that = (DirectMappingAddress) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
