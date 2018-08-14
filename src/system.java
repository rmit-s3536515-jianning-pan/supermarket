import java.util.ArrayList;
import java.util.Scanner;

public class system
{
    private static Scanner s = new Scanner(System.in);  //Set up scanner to check user input
    private static int auth = 0;
    
    private ArrayList<Sale> sale = new ArrayList<Sale>();
    private ArrayList<Customer> custs = new ArrayList<Customer>();
    private ArrayList<Product> prods = new ArrayList<Product>();
    private ArrayList<Employee> emps = new ArrayList<Employee>();
    
    
    private String test = "test"; //test
    public ArrayList<Sale> getOrders() { return sale; }  
    public ArrayList<Customer> getCustomers() { return custs; }  
    public ArrayList<Product> getProducts() { return prods; }  
    public ArrayList<Employee> getEmployees() { return emps; }
    
    public Product getProduct(String name)
    {
        for (int i=0; i<prods.size(); i++)
           if ( prods.get(i).getItemName().compareTo(name)==0)
              return prods.get(i);
        return null;
    }
    
    public void addSale()
    {
       Sale sales = new Sale(prods); 
       sale.add(sales);
    }
    public void add(Sale s)
    {
       sale.add(s);
    }
    
    public static void main(String[] args)
    {
    	system sys = new system();
        String inputLine;
        char option = ' ';  
        do
        {
            printMenu();
            System.out.printf("Please select a valid option: ");
            inputLine = s.nextLine();
            
            if (inputLine.length() != 1)
            {
                System.out.printf("Error! You did not select a valid option!\n");
                System.out.printf("Please try again\n\n");
            }
            else
            {
                option = inputLine.charAt(0);
                option = Character.toUpperCase(option);
                
                System.out.println();
                
                switch (option)
                {
                    case 'A':
                    	sys.printProductList(); //Not yet complete. (Can't shop yet)
                    	
                    	break;
                        
                    case 'B':
                    //	viewCart();
                    	sys.displaySale();
                   
                        break;
                     	
                    case 'C':
                    	sys.logIn(); //***********working fully
           
                    	break;
                        
                    case 'Y':
                    	sys.addSale();
                    	
                    	break;
                    	
                    case 'D':
                    //	changePrice();                          @@@@Cant complete until Print list is done
                    	if (auth > 0){
                    		System.out.println(" The Change Price function is running!");
                    		sys.changePrice();
                    	} else System.out.println("You are not logged in");
                    	break;

                    case 'E':
                   //     viewReport();
                    	break;
                    case 'F':
                        //listRevenue();
                    	break;
                    
                    case 'G':
                    	 creditCard.newCard(); //********Working fully
                    	break;
                    
                    case 'H':

                    creditCard.topUp(); //Bugged
                   	
                   	 break;
                   	
                    case 'I':

                        sys.addEmployee(); //*********Working Fully
                    	break;
                    	
                    case 'J':
                    	if (auth > 0){
                    		sys.addProduct();
                    	}
                    	break;
                    
                    case 'X':
                    	System.out.printf("Quitting ");
                    	break;
                    	
                    default:
                        System.out.printf("Error!" +
                                          "\"%c\" is not a valid menu option!\n\n",
                                          option);
                        
                }
            }
            
        } while (option != 'X');
    }
    
    public static void printMenu()
    {
        System.out.printf("**************Main Menu**************\n\n");
        System.out.printf("A. List Items\n");
        System.out.printf("B. View Cart \n");
        System.out.printf("C. Log in\n");
        System.out.println("Y, add Sale");
        System.out.printf("D. Change Item Price (Manager Auth Required)\n");
        System.out.printf("E. View Sales Report (Manager Auth Required)\n");
        System.out.printf("F. List Item Revenue (Manager Auth Required)\n");

        System.out.printf("G. Add Card (Manager Auth Required)\n");
        
        System.out.printf("H. Add Money to Card (Manager Auth Required)\n");
        System.out.printf("I. Add Employee (Manager Auth Required) \n");
        System.out.printf("J. Add Product (Manager Auth Required) \n");
        
        System.out.printf("X. Exit\n");
        System.out.printf("*************************************\n\n");
    }

    public void printProductList(){
    	for(int i =0; i<prods.size(); i++){
    		prods.get(i).printProduct();
    	}
    }
    
    public void addProduct()
    {	
    	System.out.println("Enter product ID : ");
    	String ID = s.nextLine();
        System.out.println("Enter product name : ");        
        String name = s.nextLine();
        System.out.println("Enter Cost price : ");       
        double price = s.nextDouble();
        System.out.println("Enter item Weight : ");     
        String w = s.nextLine();
        s.nextLine();
        System.out.println("Enter item stockLevel : ");       
        int stock = s.nextInt();
        add(new Product(ID,name,price,w,stock));
     }
    public void add(Product p)
    {
       prods.add(p);
    }
    
    
    public static void setAuth(int auth){
    	system.auth = auth;
    }
    
    public static int getAuth(){
    	return auth;
    }
    
    public void addEmployee(){
    	System.out.printf("NEW EMPLOYEE \n");
    	System.out.println("Press enter to continue...");
    	
    	s.nextLine();
    	
    	System.out.println("Please choose a Employee ID: ");
    	String ID = s.nextLine();
        System.out.printf("Please choose a username: \n");
        String newUser = s.nextLine();
        System.out.printf("Please choose a password: \n");
        String newPass = s.nextLine();
        
        System.out.printf("Enter level of authorisation (Manager = 2, salestaff = 1):  \n");
        int level = s.nextInt();
    	s.nextLine();  //next Int causes a weird bug that requires this to suck up the invisible \n it leaves behind
        add(new Employee(ID,newUser, newPass, level));
    	System.out.printf("Employee " + newUser + " created. \n");
    }
    
    public void changePrice(){
    	System.out.println("Please enter the product ID that you want to change: ");
    	String ID = s.nextLine();
    	for(int i=0; i<prods.size();i++){
    		if(prods.get(i).getItemID().equals(ID)){
    			System.out.printf("Item is found! The product ID is %s \n", ID);
    			System.out.println("Please enter the price you want to override : ");
    			double price = s.nextDouble();
    			double sale = prods.get(i).getSalePrice();
    			prods.get(i).setSalePrice(price);
    			System.out.printf("The Standard price has been overriden from %f to %f .\n",sale ,price);
    			break;
    		}
    	}
    	
    }
    public void add(Employee emp)
    {
    	emps.add(emp);
    }
    
    public void logIn(){
		int found = 0;
    	System.out.println("Please enter Username: ");
    	String inputUsername = s.nextLine();
    	System.out.println("Please enter password: ");
    	String inputPassword = s.nextLine();
    	for (int i = 0; i < emps.size(); i++) {
    		if (emps.get(i)!= null){
    			if(inputUsername.equals(emps.get(i).getName()) && inputPassword.equals(emps.get(i).getPassword())){
    				System.out.println("Welcome, " + emps.get(i).getName() + ".");
    				system.setAuth(emps.get(i).getLevel());
    				System.out.println(system.getAuth());
    				found = 1;
    	  }}
    	} 
    	if (found == 0) System.out.println("Invalid Username or Password.");
    	
    }
    
    public void displaySale(){
    	System.out.printf("%42s\n", "Sale Receipt" );
    	System.out.println("Item Name" + "\t" + "\t" + "\t" + "Quantity" + "\t" + "SalePrice" + "\t" + "Total Price" + "\t" );
    	for(int i =0; i<sale.size(); i++){
    		sale.get(i).displaySalesItem();
    		System.out.printf("%74f\n", sale.get(i).computeTotal());
    	}
    }
    
    
    public system(){
    	prods.add(new Product("1","Coke Can 375mL  24 pack",30,"10",100));
        prods.add(new Product("2","Classic Vanilla Ice Cream  1.8L",16,"2",50));
        prods.add(new Product("3","Apple Cider Vinegar  375mL",2.85,"0.3",40));
        
        emps.add(new Manager("000001","Tom","Tom1234",2));
        emps.add(new Manager("000002","Faud","Faud1234",2));
        emps.add(new Manager("000003","Jay","Jay1234",2));
        
        emps.add(new SalesStaff("000001","John","John1234",1));
        emps.add(new SalesStaff("000002","Jack","Jack1234",1));
        
    }
}
