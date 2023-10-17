import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import praktikum.Burger;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkIngredientPresenceAfterAdditionTest() {
        Ingredient ingredient = new Ingredient(FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void checkBurgerSizeAfterAddingIngredientsTest() {
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void checkBurgerSizeAfterRemovingIngredientTest() {
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(1);
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }
    @Test
    public void checkIngredientPresenceAfterRemovingIngredientTest() {
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(1);
        Assert.assertTrue(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void checkIngredientOrderAfterMovingIngredientTest() {
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void checkBurgerSizeAfterMovingIngredientTest() {
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @After
    public void tearDown() {
        burger = null;
    }
}