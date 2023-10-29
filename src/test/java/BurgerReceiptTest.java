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
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
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

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        Mockito.when(bun.getName()).thenReturn("red bun");

        Mockito.when(firstIngredient.getPrice()).thenReturn(100f);
        Mockito.when(firstIngredient.getType()).thenReturn(FILLING);
        Mockito.when(firstIngredient.getName()).thenReturn("cutlet");

        Mockito.when(secondIngredient.getPrice()).thenReturn(300f);
        Mockito.when(secondIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(secondIngredient.getName()).thenReturn("chili sauce");

        Mockito.when(burger.getPrice()).thenReturn(800f);

        var actual = burger.getReceipt();
        Assert.assertEquals(result, actual);
    }
}