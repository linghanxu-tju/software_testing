package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestHW3 {
	private HW3 h3;
	
	@Before
	public void setup(){
		h3 = new HW3();
	}
	
	@Test
	public void testCaseOne(){
		//success
		assertEquals("Prime: 2\nPrime: 3\n",h3.printPrimes(2));
	}

}
