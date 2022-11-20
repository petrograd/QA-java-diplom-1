import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private final IngredientType INGREDIENT_TYPE = IngredientType.FILLING;
    private final String INGREDIENT_NAME = "Test ingredient";
    private final float PRICE = 1.0f;
    private final String BUN_NAME = "Test bun";
    private Ingredient ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, PRICE);
    private Bun bun = new Bun(BUN_NAME, PRICE);

    @Mock
    Burger mockitoBurger;
    @Mock
    Bun mockitoBun;
    @Mock
    Ingredient mockitoIngredient;

    @Before
    public void createBurger() {
        burger = new Burger();
        mockitoBurger = Mockito.spy(burger);
        mockitoBun = Mockito.spy(bun);
        mockitoIngredient = Mockito.spy(ingredient);
    }

    @Test
    public void setBunsShowsOk() {
        burger.setBuns(mockitoBun);
        assertEquals(mockitoBun, burger.bun);
    }

    @Test
    public void addIngredientShowsOk() {
        burger.addIngredient(mockitoIngredient);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientShowsOk() {
        burger.ingredients.add(mockitoIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientShowsOk() {
        burger.ingredients.add(mockitoIngredient);
        burger.ingredients.add(ingredient);
        burger.moveIngredient(1, 0);
        assertEquals(mockitoIngredient, burger.ingredients.get(1));
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceShowsOk() {
        float expected = 5.0f;
        burger.ingredients.add(mockitoIngredient);
        burger.ingredients.add(mockitoIngredient);
        burger.ingredients.add(mockitoIngredient);
        burger.bun = mockitoBun;
        Mockito.when(mockitoBun.getPrice()).thenReturn(PRICE);
        Mockito.when(mockitoIngredient.getPrice()).thenReturn(PRICE);
        burger.getPrice();
        Mockito.verify(mockitoBun).getPrice();
        Mockito.verify(mockitoIngredient, Mockito.times(3)).getPrice();
        assertEquals(expected, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptShowsOk() {
        final float VALUE_TO_RETURN = 5.0f;
        mockitoBurger.bun = mockitoBun;
        mockitoBurger.ingredients.add(mockitoIngredient);
        mockitoBurger.ingredients.add(mockitoIngredient);
        mockitoBurger.ingredients.add(mockitoIngredient);
        Mockito.when(mockitoIngredient.getType()).thenReturn(INGREDIENT_TYPE);
        Mockito.when(mockitoIngredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(mockitoBun.getName()).thenReturn(BUN_NAME);
        Mockito.when(mockitoBurger.getPrice()).thenReturn(VALUE_TO_RETURN);
        String receipt = mockitoBurger.getReceipt();
        Mockito.verify(mockitoIngredient, Mockito.times(3)).getType();
        Mockito.verify(mockitoIngredient, Mockito.times(3)).getName();
        Mockito.verify(mockitoBun, Mockito.times(2)).getName();
        Mockito.verify(mockitoBurger).getPrice();
        assertEquals(Boolean.FALSE, receipt.isEmpty());
    }
}
