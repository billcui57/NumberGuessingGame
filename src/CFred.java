
public class CFred {
	public int minnum=0; //minimum number is 0
	public int maxnum;
	public int tries=0;
	public int num;
	
	public void guess(int parameter){ //guessing method
	
		if(parameter == 1) { //if the actual number is higher than guessed number
			minnum=num; //the minimum value becomes the previous guess, and guesses again 
			num = (minnum+maxnum)/2; //by getting the midpoint of the min and max
		}else if(parameter == 0) { // else if actual number is lower
			maxnum=num;//same logic
			num=(minnum+maxnum)/2;
		}
		
		
		
		
		
	}
	
	public void say(int num) { //saying method
		tries++; // tries increments after each time Fred says his guess
		System.out.printf("Fred thinks that your number is %d \n",num);
		System.out.println("Is that correct?(1/0)");
		System.out.printf("Attempt number %d \n",tries);
		
		
		
	}
	
	
	
	
}
