package week1.assignment;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num =50;
		boolean flag =false;
		
		for(int i=2;i<=num/2;i++) {
			
			if(num%i==0)
			{
				flag = true ;
				//break;
			}
			
		}
		
		if(!flag) {
			System.out.println("The number is Prime");
		}
		else
		{
			System.out.println("The number is not Prime");
		}

	}

}
