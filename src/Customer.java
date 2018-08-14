import java.util.*;

public class Customer {
	private String custID;
	private String custName;
	private String cusPhoneNo;
	private String custAddress; /* Address should not make
		another treat, but calling a getAddress instead */
	public Customer(String custID,String custName,String custPhoneNo){
		this.custID=custID;
		this.custName=custName;
		this.cusPhoneNo=custPhoneNo;
		this.custAddress= null ; 
		}
/* --------------------------------------------------------
------------
* I dont I have to make a sc (scanner) functions in this
class
* as all the running codes including sc is suppose to be
in the System*/
	public String getCustID(){
		return custID;
	}
	public String getCustName(){
			return custName;
	}
public String getCustPhoneNo(){
		return cusPhoneNo;
}
public String getCustAddress(String suburb,String street,String streetNo,String unitNo,String state,String posCode,String country){
	return custAddress; 
 }
}