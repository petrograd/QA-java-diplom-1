import praktikum.IngredientType;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType value;
    private final IngredientType expected;

    public IngredientTypeTest(IngredientType value, IngredientType expected) {
        this.value = value;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Ingredient type: {0}")
    public static Object[][] getIngredientType() {
        return new Object[][] {
                { IngredientType.SAUCE, IngredientType.valueOf("SAUCE")},
                { IngredientType.FILLING, IngredientType.valueOf("FILLING")},
        };
    }

    @Test
    public void shouldGetIngredientType() {
        assertEquals(expected, value);
    }

}