import java.util.*;
public class SalesLineItem{
	private Product itemName;
	private int quantity;
	private Sale sale;
	public SalesLineItem(Product itemName,int quantity,Sale sale){
			this.itemName=itemName;
			itemName.addSalesLineItem(this);
			this.quantity=quantity;
			this.sale = sale;
	}
	
	public Sale getSale(){
			return sale;
	}
	public int getQuantity(){
		return quantity;
	}

	public double computeSaleLineTotal(){
		return quantity*itemName.getSalePrice();
	}
	public void setItemName(Product itemName){
		this.itemName = itemName;
	}

	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	
	
	public void printLine(){
		System.out.printf("%-31s %-15d %-15f %-15f \n", itemName.getItemName() , getQuantity() ,itemName.getSalePrice() ,computeSaleLineTotal());

	}
}

