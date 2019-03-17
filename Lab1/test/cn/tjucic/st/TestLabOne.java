package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestLabOne {
	private LabOne L1;

	@Before
	public void setup(){
		L1 = new LabOne();
	}
	
	@Test
	public void testCaseOne(){
		//success
		assertEquals(true,L1.ifAccessible(50));
	}
	
	@Test
	public void testCaseTwo(){
		//success
		assertEquals(true, L1.ifAccessible(20));
	}
	
	@Test
	public void testCaseThree(){
		//success
		assertEquals(true, L1.ifAccessible(10));
	}
	
	@Test
	public void testCaseFour(){
		//failure
		assertEquals(false, L1.ifAccessible(84));
	}
}
