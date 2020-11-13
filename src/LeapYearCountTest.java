
import org.junit.Assert;
import org.junit.Test;

public class LeapYearCountTest {

    @Test
    public void testLeapYearCount() {
        Assert.assertEquals(0, LeapYearCount.leapYearCount(1));
        Assert.assertEquals(1, LeapYearCount.leapYearCount(4));
        Assert.assertEquals(24, LeapYearCount.leapYearCount(100));
        Assert.assertEquals(487, LeapYearCount.leapYearCount(2008));
    }
}