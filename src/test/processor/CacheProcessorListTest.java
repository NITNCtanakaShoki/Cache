package test.processor;

import main.cache.directMapping.DirectMappingCache;
import main.cache.fullAsociative.FullAssociativeCache;
import main.models.AddressList;
import main.outer.MockPrinter;
import main.processor.Cacheable;
import main.processor.CacheProcessorList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CacheProcessorListTest {
    CacheProcessorList cacheProcessorList;
    @BeforeEach
    public void setUp() {
        cacheProcessorList = CacheProcessorList.create(
                new Cacheable[]{
                        DirectMappingCache.create(8, 4),
                        FullAssociativeCache.create(8, 4)
                },
                AddressList.create(new int[]{0, 8, 16, 64, 128, 64, 256, 512, 1024, 64})
        );
    }

    @Test
    public void test() {
        final var expected = new ArrayList<String>();
        expected.add("ダイレクトマッピング方式のヒット率は0%");
        expected.add("フルアソシアティブ方式のヒット率は20%");
        final var printer = new MockPrinter();
        cacheProcessorList.out(printer);
        final var actual = printer.history();
        assertEquals(expected, actual);
    }
}
