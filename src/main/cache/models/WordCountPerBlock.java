package main.cache.models;

public class WordCountPerBlock {
    private final int count;
    public WordCountPerBlock(int count) {
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
