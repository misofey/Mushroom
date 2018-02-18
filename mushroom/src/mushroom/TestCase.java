package mushroom;

import java.awt.geom.AffineTransform;
import java.util.*;




public class TestCase {
	
	private HashSet<String> affected;
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
		this.affected = new HashSet<String>();
	}
	
	public int gombaGenerate() {
		HashMap<Integer, Gomba> terkep = new HashMap<>();
	
		for(int i =0; i<darab; i++) {
			terkep.put(i, new Gomba(meretek[i], xek[i], yok[i], size));
		}
		for(int i=0; i<darab; i++) {
			affected.addAll(terkep.get(i).affectedCount());
			//visszad egy [a fertozottt negyzetek szama][a kooridinatajuk
			//kiszedi belole az ertekeket es belerakja az affected hashmapbe
		}
		//for (String string : affected) {
		//	System.out.println(string);
		//}
		affectedNum = affected.size();
		return affectedNum;
	}
	
	
		
}