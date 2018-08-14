import java.util.Scanner;

public class creditCard{
	
		public int cardNumber;
		public String cusName;
		public double cardBalance;
		public int points;
		private static Scanner s = new Scanner(System.in);
		public static creditCard[] cardList = new creditCard[100];
		static int index = 1;
		
		public creditCard(int newNumber, String name){
		 cardNumber = newNumber;
		 cardBalance = 0;
		 points = 0;
		 cusName = name;
		}
		
		
		public static void newCard(){
	    	System.out.printf("NEW CREDIT CARD \n");
	    	System.out.println("Press enter to continue...");
	    	
	    	s.nextLine();
	    	
	        System.out.printf("Please enter Customer Name: \n");
	        String newCardName = s.nextLine();
	        System.out.printf("Please enter Card Number: \n");
	        int newNumber = s.nextInt();
	        
	        
	    	s.nextLine();  //next Int causes a weird bug that requires this to suck up the invisible \n it leaves behind
	        cardList[index] = new creditCard(newNumber, newCardName);
	        index++;
	    	System.out.printf("Card number " + newNumber + " created. \n");
	    	
	    	
	    }
		
		public static void topUp(){
			System.out.println("Please enter the card Number: ");
			int cardNum = s.nextInt();
            System.out.println("Please enter the amount to add: ");
            int topUp = s.nextInt();
            for (int i = 0; i < cardList.length; i++) {
            	if (i == cardNum){    //bug evaluating equality to fix
           	cardList[i].addMoney(topUp);
           	System.out.println(cardList[i].cardBalance);
		}
    			}
            }
		
		public void addMoney(double amount){
		this.cardBalance = this.cardBalance + amount;
		}

		public void addPoints(int points){
		this.points = this.points + points;
		}

		public int getPoints(){
		return this.points;
		}

		public int getCardNumber(){
		return this.cardNumber;
		}
		
		public String getCusName(){
			return this.cusName;
			}
			
}
