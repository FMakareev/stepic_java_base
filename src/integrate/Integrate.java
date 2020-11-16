package integrate;
import java.util.function.DoubleUnaryOperator;
import org.junit.Assert;
import org.junit.Test;

public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double n = 1e8;
        double h = (b - a) / n;
        double result = 0;

        for(int i = 0; i < n; i++) {
            result +=  f.applyAsDouble(a + h * i);
        }

        return result*= h;
    }

    @Test
    public void testIntegrate() {
        Assert.assertEquals(10.0, integrate(x -> 1, 0, 10),2);
    }
}
