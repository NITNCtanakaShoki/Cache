package main.cash.directMapping.models;

import main.models.Address;

public class DirectMappingAddress {
    private final Address address;
    public DirectMappingAddress(Address address) {
        this.address = address;
    }
    public Integer block(int blocks, int words) {
        return address.asInteger() / words % blocks;
    }
}
