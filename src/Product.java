import java.util.*;
	public class Product{
		private String itemName;
		private String itemID;
		private String weight;
		private double price; //cost price !!!!!!
		private int stockLevel;
		private double salePrice;
		private ArrayList<SalesLineItem> saleLine = new ArrayList<SalesLineItem>();
		
		
		public Product(String itemID,String itemName,double price,String weight,int stockLevel){
			this.itemID=itemID;
			this.itemName=itemName;
			this.price=price;
			this.weight=weight;
			this.stockLevel = stockLevel;
		}
		
		public ArrayList<SalesLineItem> getSalesLineItem(){
			return saleLine;
		}
		
		public void addSalesLineItem(SalesLineItem line){
				saleLine.add(line);
		}
		
		public double getSalePrice(){
			salePrice = price *1.5;
			return salePrice;
		}
		public String getItemName(){
			return itemName;
		}
		
		public String getItemID(){
			return itemID;
		}

		public double getPrice(){
			return price;
		}
		
		public String getWeight(){
			return weight;
		}
		
		public void setSalePrice(double salePrice){
			this.salePrice = salePrice;
		}
		
		public void setItemName(String itemName){
			this.itemName=itemName;
		}
		public void setItemID(String itemID){
			this.itemID=itemID;
		}

		public void setPrice(double price){
			this.price=price;
		}

		public void setWeight(String weight){
			this.weight=weight;
		}
		public int getStockLevel(){
			return stockLevel;
		}

		public void printProduct(){
			 System.out.printf("%-10s %-10s %-30s %-30s %-30s %-20d\n",
					"Product ID",	getItemID() ,"Product name ",getItemName(),"StockLevel ",getStockLevel());
		}
}
