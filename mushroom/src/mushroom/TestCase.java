package mushroom;

import java.util.*;



public class TestCase {
	
	private boolean[][] affected;
	private int size;
	int affectedNum;
	int darab;
	double[] meretek;
	double[] xek;
	double[] yok;
	
	public TestCase(int size, int darab, double[] meretek, double[] xek, double[] yok) {
		this.size=size;
		affectedNum=0;
		this.darab=darab;
		this.xek=xek;
		this.yok=yok;
		this.meretek=meretek;
		affected= new boolean[size][size];
	}
	
	public int gombaGenerate() {
		HashMap<Integer, Gomba> terkep = new HashMap<>();
		for(int i =0; i<darab; i++) {
			terkep.put(i, new Gomba(meretek[i], xek[i], yok[i]));
		}
		boolean[][] affectedByThis;
		for(int i=0; i<darab; i++) {
			affectedByThis = terkep.get(i).affectedCount(size);
			for (int j = 0; j < darab;j++) {
				for (int j2 = 0; j2 < darab; j2++) {
					if (affectedByThis[j][j2]) {
						affected[j][j2]=true;
					}
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (affected[i][j]) {
					affectedNum++;
				}
			}
		}
		return affectedNum;
		
	}
	
	
		
}