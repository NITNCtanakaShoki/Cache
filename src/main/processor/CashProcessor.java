package main.processor;

import main.models.Address;

import java.util.ArrayList;

public class CashProcessor {
    private final Cashable cashable;
    private final ArrayList<Address> addresses;
    public CashProcessor(Cashable cashable, ArrayList<Address> addresses) {
        this.cashable = cashable;
        this.addresses = addresses;
    }
    public int hitRatio() {
        var store = cashable;
        for (var address: addresses) {
            store = store.cash(address);
        }
        return store.hitRatio();
    }
}
