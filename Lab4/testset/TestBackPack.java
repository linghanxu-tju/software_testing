import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestBackPack {
	private BackPack bp;
	
	@Before
    public void setup(){
		bp = new BackPack();
	}
	
	@Test
	public void testCaseOne(){
		//success
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = {{0,0,0,0,0,0,0,0,0,0,0},
        		     {0,0,0,4,4,4,4,4,4,4,4},
        		     {0,0,0,4,5,5,5,9,9,9,9},
        		     {0,0,0,4,5,6,6,9,10,11,11}};
        assertArrayEquals(c, bp.BackPack_Solution(m, n, w, p));
	}
}
