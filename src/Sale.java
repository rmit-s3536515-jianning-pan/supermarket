import java.util.*;
public class Sale{
	private Customer customerName;
	private String salesID;
	private Scanner scan = new Scanner(System.in);
	private ArrayList<SalesLineItem> lists = new ArrayList<SalesLineItem>();
	private Date salesDate;
	private double total;

	public Sale(ArrayList<Product> pList)
	   {
			Product p;
	        salesDate = new Date();
	        System.out.print("Enter Sale ID : ");
	        salesID = scan.nextLine();
	        String resp; 
	        int i;
	        do {

	        		   System.out.print("Enter Product ID : ");
	        		   String proID= scan.nextLine();
	        		   
	        			   for(i = 0;i<pList.size();i++){
	        				   	if(pList.get(i).getItemID().equals(proID)){
	        				   		   System.out.print("Enter 	qty : ");
	        				   		   int qty = scan.nextInt();
	        		   
	        				   		   lists.add(new SalesLineItem(pList.get(i),qty,this));
	        				   		   scan.nextLine();
	        				   		   System.out.println("Product is found");
	        				   		   break;
	        				   	}
	        				   	
	        			   }
	        			   if(pList.contains(proID)){
	        				   System.out.println("No Product is found!");
	        			   }
	        		 
	        		   
	        		
	          
	        		   System.out.print("Any more items ? : Y/N");
	        		   
	        		   resp = scan.nextLine();
	        }  while (   resp.compareTo("Y") == 0);       
	        
	   }
	
	public String getSaleID(){
		return salesID;
	}
	public Date getSalesDate(){
		return salesDate;
	}
	public double computeTotal(){ /* get sum without any discount */
		for(int i=0; i<lists.size();i++){
			total +=lists.get(i).computeSaleLineTotal();
			}
			return total;
		}

	public void displaySalesItem(){
		for(int i =0; i<lists.size(); i++){
			lists.get(i).printLine();
		}
	}
	public void setSalesDate(Date salesDate){
		this.salesDate=salesDate;
	}
	public double getDiscount(){ /*return discounted price if it has more than 5 item in the shopping chart*/
		int len =lists.size();
		if(len>=5 && len <10){
			total = total*1.1;
		}
		else if(len>=10){
			total = total*1.2;
		}
		return total;
	}
	
	public double calculateDiscount(){
		double discountPrice = 0;
		for(int i=0; i<lists.size(); i++){
			if(lists.get(i).getQuantity() >20){
				discountPrice = lists.get(i).computeSaleLineTotal();
				System.out.println("The discount for this item is 5% off! ");
				discountPrice = discountPrice * 0.95;
			}
		}
		return discountPrice;
	}

}
