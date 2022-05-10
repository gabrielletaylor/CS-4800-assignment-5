import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeTest {
	
	@Test
	public void test2() {
		Prime p = new Prime();
		boolean prime = p.isPrime(2);
		assertTrue(prime);
	}
	
	@Test
	public void test3() {
		Prime p = new Prime();
		boolean prime = p.isPrime(3);
		assertTrue(prime);
	}

	@Test
	public void test4() {
		Prime p = new Prime();
		boolean prime = p.isPrime(4);
		assertTrue(prime);
	}

	@Test
	public void test5() {
		Prime p = new Prime();
		boolean prime = p.isPrime(5);
		assertTrue(prime);
	}

	@Test
	public void test6() {
		Prime p = new Prime();
		boolean prime = p.isPrime(6);
		assertTrue(prime);
	}

}
