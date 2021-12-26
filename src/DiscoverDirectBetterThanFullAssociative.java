import main.cache.directMapping.DirectMappingCache;
import main.cache.fullAsociative.FullAssociativeCache;
import main.models.AddressList;
import main.processor.CacheProcessor;
import java.util.Random;

public class DiscoverDirectBetterThanFullAssociative {
    public static void main(String[] args) {
        while (true) {
            final var addressList = AddressList.create(randomAddresses());
            final var directMappingProcessor = new CacheProcessor(DirectMappingCache.create(8, 4), addressList);
            final var fullAssociativeProcessor = new CacheProcessor(FullAssociativeCache.create(8, 4), addressList);


            System.out.println(directMappingProcessor.result());
            System.out.println(fullAssociativeProcessor.result());
            System.out.println();

            if (directMappingProcessor.hitRatio() > fullAssociativeProcessor.hitRatio()) {
                System.out.println(addressList);
                break;
            }
        }
    }
    private static int[] randomAddresses() {
        final var random = new Random();
        final var addresses = new int[50];
        for (int i = 0; i < 50; i++) {
            addresses[i] = randomAddress(random);
        }
        return addresses;
    }
    private static int randomAddress(Random random) {
        return random.nextInt(3000) + 1;
    }
}
