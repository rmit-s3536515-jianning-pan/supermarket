import java.util.*;

public class Location{
	
	/* instance variables that suits for Location class */
	private String suburbName;
	private String stName;
	private String stNo;
	private String stateName;
	private String poscodeNo;
	private String countryPlace;
	
	
	/* Accessories for the Locations */
	public Location (String suburb,String street,String streetNo,String unitNo,String state,String posCode,String country){
		suburb=suburbName;
		street=stName;
		streetNo=stNo;
		unitNo=stNo;
		state=stateName;
		posCode=poscodeNo;
		country=countryPlace;
	}
	
	public String getSuburbName(){return suburbName;}
	public String getStreetName(){return stName;}
	public String getStreetNumber(){return stNo;}
	public String getUnitNumber(){return stNo;}
	public String getStateName(){return stateName;}
	public String getPoscodeNumber(){return poscodeNo;}
	public String getCountryArea(){return countryPlace;}

}
