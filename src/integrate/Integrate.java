package integrate;
import java.util.function.DoubleUnaryOperator;
import org.junit.Assert;
import org.junit.Test;

public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        return f.applyAsDouble(a);
    }


    @Test
    public void testIntegrate() {

        Assert.assertEquals(10.0, integrate(x -> 1, 0, 10));
        Assert.assertEquals(70.0, integrate(x -> x + 2, 0, 10));
        Assert.assertEquals(0.603848, integrate( x -> Math.sin(x) / x , 1, 5));

    }
}
