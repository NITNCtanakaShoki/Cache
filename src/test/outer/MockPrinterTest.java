package test.outer;

import main.outer.MockPrinter;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MockPrinterTest {
    @Test
    public void test() {
        final var printer = new MockPrinter();

        final var sentences = new ArrayList<String>();
        sentences.add("Hello");
        sentences.add("My name is Bob!");
        sentences.add("Bye");

        for (var sentence: sentences) {
            printer.println(sentence);
        }

        assertEquals(sentences, printer.history());
    }
}
