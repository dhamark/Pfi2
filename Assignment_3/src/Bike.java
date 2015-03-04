import java.util.Arrays;


public class Bike {

	public int price;
	public int size; 
	public String color; 
	
	public Bike(String color,int size){ 
	this.color = color; 
	this.size = size; 
	}
	
	/** Creates a Bike with variables limited by values in Constants.java */
	public Bike(String color,int size, int price){ 
		this.color = color; 
		this.size = size; 
		this.price = price; 
	//Arraylisten som skrivs ut
		if(Arrays.asList(Constants.colors).contains(color)){
			this.color = color;
		}
			else {
				this.color = "fel färg";
			}
	
		
	}
		
	/** Creates method for color */
	public String getColor(){
		
		return this.color; 
		
		}
	/** Creates method for size */
public int getSize(){
	
	if(size < Constants.MIN_SIZE){
		size = 8; 
	}
	
	if(size > Constants.MAX_SIZE){
		size = 28; 
	}
		
		return this.size; 
		
		}
/** Creates method for price */
public int getPrice(){

	if(price < Constants.MIN_PRICE){
		price = 0; 
	}
	
	if(price > Constants.MAX_PRICE){
		price = 30000; 
	} 
	return this.price; 
	
	
	}

public void setSize(int size) {
	this.size = size;
}

	

	
}
