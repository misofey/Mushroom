package mushroom;

import java.util.HashSet;

public class Gomba {

	private double meret;
	private double x;
	private double y;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	public Gomba(double size, double x, double y, int gridSize) {
		meret=size;
		this.x=x;
		this.y=y;
		if (x<meret) {
			minX = 0;
		} else {
			minX = (int)Math.floor(this.x-meret);
		}
		if (y<meret) {
			minY = 0;
		} else {
			minY = (int)Math.floor(this.y-meret);
		}
		if (x+meret>gridSize) {
			maxX = gridSize;
		}else {
			maxX = (int)Math.ceil(x+meret);
		}
		if (y+meret>gridSize) {
			maxY = gridSize;
		}else {
			maxY = (int)Math.ceil(y+meret);
		}
	}
	
	
	
	public HashSet<String> affectedCount () {
		HashSet<String> affset = new HashSet<>();
		
		for (int i = minX; i < maxX; i++) {
			for (int j = minY; j < maxY; j++) {
				if (bennevane(i, j)) {
					affset.add(new String(i + ", " + j));
				}
			}
		}
		return affset;
	}
	
	private boolean bennevane(int i, int j) {
		double xkozep= i+0.5;
		double ykozep= j+0.5;
		xkozep-= this.x;
		ykozep-= this.y;
		xkozep= Math.abs(xkozep);
		ykozep= Math.abs(ykozep);
		
		if (xkozep<0.5) {
			Math.floor(xkozep);
		} else {
			xkozep-=0.5;
		}
		if (ykozep<0.5) {
			Math.floor(ykozep);
		} else {
			ykozep-=0.5;
		}
		
		if (Math.sqrt((Math.pow(xkozep, 2)+Math.pow(ykozep, 2)))>=this.meret) {
			return false;
		} else {
			return true;
		}
	}
}
