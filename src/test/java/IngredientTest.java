import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import praktikum.Ingredient;

import static praktikum.Constants.DELTA;
import static praktikum.IngredientType.*;


public class IngredientTest {
    private static Ingredient ingredient;

    @BeforeClass
    public static void createIngredient() {
        ingredient = new Ingredient(SAUCE, "hot sauce", 56.22f);
    }

    @Test
    public void getIngredientPriceTest() {
        float result = 56.22f;
        Assert.assertEquals(result, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getIngredientNameTest() {
        String result = "hot sauce";
        Assert.assertEquals(result, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        ingredient.type = SAUCE;
        Assert.assertEquals(ingredient.type, ingredient.getType());
    }
}
