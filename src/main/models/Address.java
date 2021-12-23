package main.models;

import java.util.Objects;

public class Address {
    private static final int MAX_ADDRESS = 65535;
    private static final int MIN_ADDRESS = 0;

    private final int addressNumber;

    public Address(int addressNumber) {
        if (!isValid(addressNumber)) throw new IllegalArgumentException("0 < address < 65535");
        this.addressNumber = addressNumber;
    }

    public Integer asInteger() {
        return addressNumber;
    }
    private static boolean isValid(int addressNumber) {
        if (addressNumber > MAX_ADDRESS) return false;
        if (addressNumber < MIN_ADDRESS) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressNumber == address.addressNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressNumber);
    }
}
