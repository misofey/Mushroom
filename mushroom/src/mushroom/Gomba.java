package mushroom;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Gomba {

	private double meret;
	private double x;
	private double y;
	
	public Gomba(double size, double x, double y) {
		meret=size;
		this.x=x;
		this.y=y;
	}
	
	public boolean[][] affectedCount (int gridSize) {
		boolean[][] affectedStore= new boolean[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
			if(bennevane(i, j)) {
				affectedStore[i][j]=true; 
			}else {
				affectedStore[i][j]=false; 
			}
			}
			
		}
		return affectedStore;
	}
	
	private boolean bennevane(int i, int j) {
		double xkozep= i-0.5;
		double ykozep= j-0.5;
		xkozep-=this.x;
		ykozep-= this.y;
		xkozep= Math.abs(xkozep);
		ykozep= Math.abs(ykozep);
		DecimalFormat df = new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.DOWN);
		df.format(xkozep);
		df.format(ykozep);
		if (Math.sqrt((Math.pow(xkozep, 2)+Math.pow(ykozep, 2)))>this.meret) {
			return true;
		} else {
			return false;
		}
	}
}
