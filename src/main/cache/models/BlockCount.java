package main.cache.models;

public class BlockCount {
    private final int count;
    public BlockCount(int count) {
        if (!isValid(count)) throw new IllegalArgumentException();
        this.count = count;
    }
    public int value() {
        return count;
    }
    private static boolean isValid(int count) {
        return count >= 0;
    }
}
