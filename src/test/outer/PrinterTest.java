package test.outer;

import main.outer.Printable;
import main.outer.Printer;
import org.junit.jupiter.api.Test;

public class PrinterTest {
    @Test
    public void 継承確認() {
        Printable printer = new Printer();
    }
}
