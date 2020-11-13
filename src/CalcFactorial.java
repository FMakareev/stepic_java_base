import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class CalcFactorial {

    public static BigInteger factorial(int value) {

        BigInteger max = new BigInteger(Integer.toString(value));
        BigInteger i = new BigInteger("1");
        BigInteger s = new BigInteger("1");
        BigInteger count = new BigInteger("1");

        while(i.compareTo(max) < 0 || i.compareTo(max) == 0){
            s = s.multiply(i);
            i = i.add(count);
        }


        return s;
    }

    @Test
    public void testFactorial() {
        Assert.assertEquals(new BigInteger("1"), CalcFactorial.factorial(1));
        Assert.assertEquals(new BigInteger("2"), CalcFactorial.factorial(2));
        Assert.assertEquals(new BigInteger("6"), CalcFactorial.factorial(3));
        Assert.assertEquals(new BigInteger("24"), CalcFactorial.factorial(4));
        Assert.assertEquals(new BigInteger("120"), CalcFactorial.factorial(5));

    }

}
