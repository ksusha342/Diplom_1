import org.junit.Test;
import org.junit.Assert;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    @Mock
    Bun bun;
    @Spy
    Burger burger;

    @Test
    public void getBurgerReceiptTest() {
        String result = "(==== red bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce chili sauce =\r\n" +
                "(==== red bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";
        Ingredient firstIngredient = new Ingredient(FILLING, "cutlet", 100);
        Ingredient secondIngredient = new Ingredient(SAUCE, "chili sauce", 300);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(burger.getPrice()).thenReturn(800f);
        var actual = burger.getReceipt();
        Assert.assertEquals(result, actual);
    }
}