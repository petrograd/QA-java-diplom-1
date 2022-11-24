import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String BUN_NAME = "Турецкий экмек";
    private final float BUN_PRICE = 7.40f;
    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameShowsOk() {
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceShowsOk() {
        assertEquals(BUN_PRICE, bun.getPrice(), 0.0);
    }
}

