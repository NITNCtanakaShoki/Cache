package main.processor;

import main.models.Address;

public interface Cashable {
    public int hitRatio();
    public Cashable cash(Address address);
}
