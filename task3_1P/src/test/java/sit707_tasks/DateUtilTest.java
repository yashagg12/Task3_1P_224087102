package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224087102";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Yash";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	// **Boundary Value Tests for January**
		@Test
		public void testMinJanuary1ShouldIncrementToJanuary2() {
			DateUtil date = new DateUtil(1, 1, 2024);
	        date.increment();
	        Assert.assertEquals(2, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
		}
		
		@Test
		public void testMinJanuary1ShouldDecrementToDecember31() {
			DateUtil date = new DateUtil(1, 1, 2024);
	        date.decrement();
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(12, date.getMonth());
	        Assert.assertEquals(2023, date.getYear());
		}

		// **February (Leap Year)**
		@Test
		public void testMaxFebruary29ShouldIncrementToMarch1() {
			DateUtil date = new DateUtil(29, 2, 2024);
	        date.increment();
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
		}

		@Test
		public void testMinFebruary1ShouldDecrementToJanuary31() {
			DateUtil date = new DateUtil(1, 2, 2024);
	        date.decrement();
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
		}
		
		// **March**
		@Test
		public void testMaxMarch31ShouldIncrementToApril1() {
			DateUtil date = new DateUtil(31, 3, 2024);
	        date.increment();
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(4, date.getMonth());
		}

		@Test
		public void testMinMarch1ShouldDecrementToFebruary29() {
			DateUtil date = new DateUtil(1, 3, 2024);
	        date.decrement();
	        Assert.assertEquals(29, date.getDay());
	        Assert.assertEquals(2, date.getMonth());
		}

		// **April**
		@Test
		public void testMaxApril30ShouldIncrementToMay1() {
			DateUtil date = new DateUtil(30, 4, 2024);
	        date.increment();
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(5, date.getMonth());
		}

		@Test
		public void testMinApril1ShouldDecrementToMarch31() {
			DateUtil date = new DateUtil(1, 4, 2024);
	        date.decrement();
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
		}

		// **December (Year Change)**
		@Test
		public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
			DateUtil date = new DateUtil(31, 12, 2024);
	        date.increment();
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
	        Assert.assertEquals(2025, date.getYear());
		}

		@Test
		public void testMinDecember1ShouldDecrementToNovember30() {
			DateUtil date = new DateUtil(1, 12, 2024);
	        date.decrement();
	        Assert.assertEquals(30, date.getDay());
	        Assert.assertEquals(11, date.getMonth());
		}
}