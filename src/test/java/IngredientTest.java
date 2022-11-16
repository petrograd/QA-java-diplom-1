import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {

    private final String INGREDIENT_NAME = "Test ingredient";
    private final float INGREDIENT_PRICE = 12.34f;
    private Ingredient ingredient;

    @Mock
    IngredientType type;

    @Before
    public void createIngredient()  {
        ingredient = new Ingredient(type, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void shouldGetPrice() {
        assertEquals(INGREDIENT_PRICE, ingredient.getPrice(), 0.0);
    }

    @Test
    public void shouldGetName() {
        assertEquals(INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void shouldGetType() {
        assertEquals(type, ingredient.getType());
    }

}