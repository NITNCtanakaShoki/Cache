package main.models;

import java.util.ArrayList;

public class AddressList {
    private final ArrayList<Address> addresses;

    private AddressList(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public static AddressList create(int[] addressNumbers) {
        final var list = new ArrayList<Address>();
        for (var addressNumber: addressNumbers) {
            list.add(new Address(addressNumber));
        }
        return new AddressList(list);
    }

    public Address at(int index) {
        return addresses.get(index);
    }

    public int count() {
        return addresses.size();
    }

    @Override
    public String toString() {
        return addresses.toString();
    }
}
