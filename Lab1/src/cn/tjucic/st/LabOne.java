package cn.tjucic.st;

public class LabOne {
	private int numFifty = 1;
	private int numTwenty = 1;
	private int numFive = 2;
	private int numOne = 3;

	public LabOne() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean ifAccessible(int x){
		if(x >= 50){
			x -= 50;
		}
		if(x >= 20){
			x -= 20;
		}
		if(x == 0){
			return true;
		}
		for(int m = 0;m <= numFive;m++){
			for(int n = 0;n <= numOne;n++){
				if(5 * m + n == x){
					return true;
				}
			}
		}
		return false;
	}

}
