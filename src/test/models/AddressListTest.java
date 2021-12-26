package test.models;

import main.models.Address;
import main.models.AddressList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressListTest {
    AddressList list;
    @BeforeEach
    public void setUp() {
        list = AddressList.create(
                new int[]{1, 3, 2, 1}
        );
    }

    @Test
    public void atTest() {
        assertEquals(new Address(3), list.at(1));
    }

    @Test
    public void countTest() {
        assertEquals(4, list.count());
    }
}
