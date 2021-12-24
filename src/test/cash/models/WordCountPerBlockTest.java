package test.cash.models;
import main.cash.models.WordCountPerBlock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordCountPerBlockTest {
    @Test
    public void インスタンス化() {
        var wordCount = new WordCountPerBlock(2);
        assertEquals(2, wordCount.value());
    }

    @Test
    public void 不正値() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WordCountPerBlock(-1);
        });
    }
}
