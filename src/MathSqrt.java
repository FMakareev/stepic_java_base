import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;


public class MathSqrt {
    public static double sqrt(double x) {
        if(x < 0){
            throw new IllegalArgumentException("Expected non-negative number, got "+x);
        }
        return Math.sqrt(x);
    }

    @Test
    public void testSqrt() {

        Assert.assertEquals(Math.sqrt(2), MathSqrt.sqrt(2), 2);
        try{
            MathSqrt.sqrt(-2);
        } catch (IllegalArgumentException e){
            Assert.assertThat(e.getMessage(), is("Expected non-negative number, got -2.0"));
        }
    }


}
