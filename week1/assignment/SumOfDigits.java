package week1.assignment;

public class SumOfDigits {
	

	int inputNumber=123;
	int sum=0;
	int remainder;
	int quotient;
	
	public void sumOfDigits() {
		// TODO Auto-generated method stub
		
		while(inputNumber>0)
		{
			remainder=inputNumber%10;
			System.out.println(remainder);
			sum=sum+remainder;
			System.out.println(sum);
			quotient=inputNumber/10;
			System.out.println(quotient);
			inputNumber=quotient;
		}
		
		System.out.println(sum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumOfDigits obj= new SumOfDigits();
		obj.sumOfDigits();
	}

}
