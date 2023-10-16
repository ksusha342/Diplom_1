import org.junit.Test;
import org.junit.Assert;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;


public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);

    @Test
    public void getIngredientPriceTest() {
        float result = 100;
        Assert.assertEquals(result, ingredient.getPrice(), 0.001f);
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
