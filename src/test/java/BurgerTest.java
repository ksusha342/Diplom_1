import org.junit.*;
import praktikum.Burger;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private static Ingredient firstIngredient;
    private static Ingredient secondIngredient;

    @BeforeClass
    public static void createIngredients() {
        firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkIngredientPresenceAfterAdditionTest() {
        burger.addIngredient(firstIngredient);
        Assert.assertTrue(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void checkBurgerSizeAfterAddingIngredientsTest() {
        burger.addIngredient(firstIngredient);
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void checkBurgerSizeAfterRemovingIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void checkIngredientOrderAfterMovingIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void checkBurgerSizeAfterMovingIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }
}