package main.cash.models;

public class HitRatioCounter {
    private final int hitCount;
    private final int totalCount;

    public HitRatioCounter() {
        hitCount = 0;
        totalCount = 0;
    }
    private HitRatioCounter(int hitCount, int totalCount) {
        this.hitCount = hitCount;
        this.totalCount = totalCount;
    }
    public int hitRatio() {
        if (totalCount == 0) return -1;
        return (int) perHitRatio();
    }
    public HitRatioCounter hitCount() {
        return new HitRatioCounter(hitCount + 1, totalCount + 1);
    }
    public HitRatioCounter missHitCount() {
        return new HitRatioCounter(hitCount, totalCount + 1);
    }
    private double perHitRatio() {
        return (double)hitCount / (double)totalCount * 100;
    }
}
