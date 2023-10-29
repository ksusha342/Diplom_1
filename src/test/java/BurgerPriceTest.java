import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.Constants.DELTA;
import static praktikum.IngredientType.*;


@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private Burger burger;

    public float firstIngredientPrise;
    public float secondIngredientPrise;
    public float totalPrice;

    public BurgerPriceTest(float firstIngredientPrise, float secondIngredientPrise, float totalPrice) {
        this.firstIngredientPrise = firstIngredientPrise;
        this.secondIngredientPrise = secondIngredientPrise;
        this.totalPrice = totalPrice;
    }

    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerPrice() {
        return new Object[][] {
                {300, 200, 900},
                {0.0f, 200, 600},
                {50.5f, 200, 650.5f},
                {200, 0, 600},
                {0.0f, 0.0f, 400},
        };
    }

    @Test
    public void getBurgerPriceTest() {
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", firstIngredientPrise);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", secondIngredientPrise);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Assert.assertEquals(totalPrice, burger.getPrice(), DELTA);
    }
}
