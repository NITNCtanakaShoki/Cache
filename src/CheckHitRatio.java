import main.cache.directMapping.DirectMappingCache;
import main.cache.fullAsociative.FullAssociativeCache;
import main.models.AddressList;
import main.outer.Printer;
import main.processor.CacheProcessorList;
import main.processor.Cacheable;

public class CheckHitRatio {
    public static void main(String[] args) {

        final var attempt = new int[]{
                /* 確かめるアドレスたち */
                2715, 2716, 2717, 2718, 2719,   11,   12,   13,   14,   15,
                13,     14,   15, 1030, 1031, 1032, 1033, 1034, 1035, 2700,
                2690, 2691, 2700, 2701, 2702, 2703, 1024,    0,   11,   12,
                2710, 1050, 2711, 2712, 1024, 1025, 1026, 1051, 2688, 2689,
                   1,    2,    3,    4,    5,    6,    7,    8,    9,   10
                /* ----------------- */
        };

        final var caches = new Cacheable[]{
                DirectMappingCache.create(8, 4),
                FullAssociativeCache.create(8, 4)
        };
        final var processorList = CacheProcessorList.create(
            caches,
            AddressList.create(attempt)
        );
        processorList.out(new Printer());
    }
}
