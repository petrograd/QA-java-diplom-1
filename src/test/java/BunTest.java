import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTest {
    private Bun bun;
    private final String BUN_NAME = "zufälliges Brötchen";
    private final float BUN_PRICE = 7.40f;

    @Before
    public void createBun() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void shouldGetName() {
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void shouldGetPrice() {
        assertEquals(BUN_PRICE, bun.getPrice(), 0.0);
    }
}

