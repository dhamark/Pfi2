import java.util.ArrayList;
public class BikeStore {
	


ArrayList<Bike> bikes = new ArrayList<Bike>();
	/** ArrayList for my bikes. */
public  BikeStore() {		
	addBike("blå", 28, 4000);
	addBike("magenta", 15, 2000);
	addBike("gul", 234, 140000);
	addBike("blå", 20, 16700);
	addBike("röd", 10, 1249);
	addBike("grön", 28, 28000);
	addBike("rosa", 25, 10000);
	addBike("svart", 18, 12000);
	addBike("gul", 16, 5000);
	addBike("röd", 28, 2800); 
}
	/**  String for getALlBikes. Declared and looped. Returning value. */
	public String getAllBikes(){
		String allBikes = ""; 	
	
	for(int b =0; b< bikes.size(); b++){
		//bikes.get(b); 
		allBikes += "Number: " + (b+1) + "\n" + "Color: " + bikes.get(b).getColor() + "\n" + "Size: " + bikes.get(b).getSize() + "\n" + "Price: " + bikes.get(b).getPrice() + "kr" + "\n";
		allBikes += "\n";
		}
	return allBikes; 
		}
	/**  Void for the addBike command. Constuctor.*/
	public void addBike(String color, int size, int price){
		bikes.add(new Bike(color, size, price));
			
		}
			
	}
	


