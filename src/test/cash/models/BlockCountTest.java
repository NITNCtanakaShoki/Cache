package test.cash.models;
import main.cash.models.BlockCount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlockCountTest {
    @Test
    public void インスタンス化() {
        var blockCount = new BlockCount(2);
        assertEquals(2, blockCount.value());
    }

    @Test
    public void 不正値() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BlockCount(-1);
        });
    }
}
