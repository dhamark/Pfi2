import java.lang.reflect.Array;
import java.util.ArrayList;


public class Main {

	private static final int BLUE = 0;
	private static final int RED = 0;
	private static final int YELLOW = 0;
	private static final int GREEN = 0;


	public static void main(String[] args) {
		
		
		
		ArrayList<Bike> cykel = new ArrayList<Bike>();
		cykel.add(new Bike("blå", 28, 4000));
		cykel.add(new Bike("magenta", 15, 2000));
		cykel.add(new Bike("gul", 234, 140000));
		cykel.add(new Bike("blå", 20, 16700));
		cykel.add(new Bike("röd", 10, 1249));
		cykel.add(new Bike("grön", 28, 28000));
		cykel.add(new Bike("rosa", 25, 10000));
		cykel.add(new Bike("svart", 18, 12000));
		cykel.add(new Bike("gul", 16, 5000));
		cykel.add(new Bike("röd", 28, 2800)); 
		
		
		for(int i =0; i < cykel.size(); i++ ){
		
		System.out.println("Denna cykel är " + cykel.get(i).getColor() + " och är "+ cykel.get(i).getSize() + " i omfång och kostar "+ cykel.get(i).getPrice() + " kr");
		}
		
	}
	
	}
