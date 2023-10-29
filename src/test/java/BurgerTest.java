import org.junit.*;
import org.mockito.Mock;
import praktikum.Burger;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkIngredientPresenceAfterAdditionTest() {
        burger.addIngredient(firstIngredient);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
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