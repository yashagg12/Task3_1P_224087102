package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
    public void testStartOfYearIncrement() {
        DateUtil date = new DateUtil(1, 1, 2023);
        date.increment();
        System.out.println("Test A1: 1-1-2023 -> Next = " + date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testEndOfYearDecrement() {
        DateUtil date = new DateUtil(31, 12, 2023);
        date.decrement();
        System.out.println("Test A2: 31-12-2023 -> Prev = " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testFebruary28NonLeapYearIncrement() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        System.out.println("Test A3: 28-2-2023 -> Next = " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testFebruary28LeapYearIncrement() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        System.out.println("Test A4: 28-2-2024 -> Next = " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDayZero() {
        System.out.println("Test A5: 0-5-2023 -> Invalid");
        new DateUtil(0, 5, 2023);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidMonthThirteen() {
        System.out.println("Test A6: 15-13-2023 -> Invalid");
        new DateUtil(15, 13, 2023);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidYearTooLow() {
        System.out.println("Test A7: 15-5-1600 -> Invalid");
        new DateUtil(15, 5, 1600);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidYearTooHigh() {
        System.out.println("Test A8: 15-5-3000 -> Invalid");
        new DateUtil(15, 5, 3000);
    }

    @Test
    public void testValidLeapYearFebruary29() {
        DateUtil date = new DateUtil(29, 2, 2020);
        System.out.println("Test A9: 29-2-2020 -> Valid");
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2020, date.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidLeapYearFebruary29() {
        System.out.println("Test A10: 29-2-2023 -> Invalid");
        new DateUtil(29, 2, 2023);
    }

    @Test
    public void test4B() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        System.out.println("Test 4B: 30-6-1994 -> Next = " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void test5B_InvalidDate() {
        System.out.println("Test 5B: 31-6-1994 -> Invalid");
        new DateUtil(31, 6, 1994);
    }

    @Test
    public void test14B_LeapFeb28() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        System.out.println("Test 14B: 28-2-2024 -> Next = " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void test15B_LeapFeb29() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        System.out.println("Test 15B: 29-2-2024 -> Next = " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void test16B_March1FromLeapFeb() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        System.out.println("Test 16B: 1-3-2024 -> Prev = " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void test17B_InvalidNonLeapFeb29() {
        System.out.println("Test 17B: 29-2-2023 -> Invalid");
        new DateUtil(29, 2, 2023);
    }

}
