import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    Bun bun = new Bun("white bun", 56.22f);

    @Test
    public void getBunNameTest() {
        String result = "white bun";
        Assert.assertEquals(result, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        float result = 56.22f;
        Assert.assertEquals(result, bun.getPrice(), 0.001f);
    }
}
