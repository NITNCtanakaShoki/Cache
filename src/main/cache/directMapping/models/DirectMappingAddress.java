package main.cache.directMapping.models;

import main.cache.models.BlockCount;
import main.cache.models.WordCountPerBlock;
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
    public DirectMappingAddress representativeAddress(WordCountPerBlock count) {
        return create(address.asInteger() / count.value());
    }
    public Integer allocate(BlockCount blocks, WordCountPerBlock words) {
        return representativeAddress(words).surplusForAllocate(blocks);
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
    private Integer surplusForAllocate(BlockCount blocks) {
        return address.asInteger() % blocks.value();
    }
}
