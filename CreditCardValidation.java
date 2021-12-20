
public class CreditCardValidation {
	
	public boolean validate(String card) {
		boolean status = false;
		long cardnum;
		int evencardDigits[] = new int [8];
		int oddcardDigits[] = new int [8];
		int cardDigits[] = new int [16];
		cardnum = Long.parseLong(card);
		int mult = 10;
		int evenIndex = 14;
		int oddIndex = 15;
		int sumOfNums;
		int total=0;
		
		for(int i=cardDigits.length-1; i>=0; i--) {
			cardDigits[i] = (int) (cardnum%mult);
			cardnum/=10;
		}
		
		for(int i=0; i<evencardDigits.length; i++) {
			evencardDigits[i] = cardDigits[evenIndex];
			evencardDigits[i]*=2;
			if(evencardDigits[i]>9) {
				evencardDigits[i]-=9;
			}
			oddcardDigits[i] = cardDigits[oddIndex];
			oddIndex-=2;
			evenIndex-=2;
		}
		
		for(int i=0; i<evencardDigits.length; i++) {
			sumOfNums = evencardDigits[i] + oddcardDigits[i];
			total+=sumOfNums;
		}
		
		if(total%10==0) {
			status = true;
		}
		else if(total%10 !=0) {
			status = false;
		}
		
		return status;
	
	}
}

