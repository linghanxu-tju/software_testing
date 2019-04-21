import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort {
	private BubbleSort bs;
	
	@Before
    public void setup(){
		bs = new BubbleSort();
	}
	
	@Test
	public void testCaseOne(){
		//success
		assertEquals("[1, 2, 2, 5, 6]",Arrays.toString(bs.BubbleSort(new int[]{1,6,2,2,5})));
	}
}
