import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static praktikum.Constants.DELTA;


@RunWith(Parameterized.class)
public class BunTest {
    private static Bun bun;

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Before
    public void createBun() {
        bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100},
                {"white bun", 62.50f},
                {"red bun", 0},
                {null, 100},
                {"", 100.0f}
        });
    }

    @Test
    public void getBunNameTest() {
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Assert.assertEquals(bunPrice, bun.getPrice(), DELTA);
    }
}
