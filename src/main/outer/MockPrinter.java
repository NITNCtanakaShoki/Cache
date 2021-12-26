package main.outer;

import java.util.ArrayList;

public class MockPrinter implements Printable {
    private final ArrayList<String> histories;
    public MockPrinter() {
        histories = new ArrayList<>();
    }
    public void println(String arg) {
        histories.add(arg);
    }
    public ArrayList<String> history() {
        return histories;
    }
}
