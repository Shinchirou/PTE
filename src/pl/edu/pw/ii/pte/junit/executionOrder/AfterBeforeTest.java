package pl.edu.pw.ii.pte.junit.executionOrder;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AfterBeforeTest {

	@BeforeAll
	public static void setupClass() {
		System.out.println("@BeforeClass setUpClass");
	}

	@AfterAll
	public static void tearDownClass() {
		System.out.println("@AfterClass tearDownClass");
	}

	@BeforeEach
	public void setUp() {
		System.out.println("@Before setUp");
	}

	@AfterEach
	public void tearDown() {
		System.out.println("@After tearDown");
		System.out.println();
	}

	@Test
	public void test1() {
		System.out.println("@Test test1()");
		System.out.println(new Exception().getStackTrace()[0].getMethodName());
	}

	@Test
	public void test2() {
		System.out.println("@Test test2()");
		System.out.println(new Exception().getStackTrace()[0].getMethodName());
	}
}
