package week3;

public class Calculator {
	
	public void toAdd(int num1, int num2) {
		// TODO Auto-generated method stub
		
		int sum= num1+num2;
		System.out.println(sum);

	}
	
	public void toAdd(int num1,int num2, int num3) {
		// TODO Auto-generated method stub

		int sum = num1+num2+num3;
		System.out.println(sum);
	}
	
	
	public void toSubtract(int num1, int num2) {
		// TODO Auto-generated method stub
		int value= num1-num2;
		System.out.println(value);
		
	}
	
	public void toSubtract(double num1, double num2) {
		// TODO Auto-generated method stub
		double value = num1-num2;
		System.out.println(value);

	}

	
	public void toMultiply(int num1, int num2) {
		// TODO Auto-generated method stub
		int result =num1*num2;
		System.out.println(result);

	}
	
	public void toMultiply(int num1, double num2) {
		// TODO Auto-generated method stub
		double result = num1*num2;
		System.out.println(result);

	}
	
	public void toDivide(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1/num2;
		System.out.println(result);
	}
	
	public void toDivide(double num1, int num2) {
		// TODO Auto-generated method stub
		double result= num1/num2;
		System.out.println(result);

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calc = new Calculator();
		calc.toAdd(6, 23);
		calc.toAdd(1, 2, 3);
		calc.toSubtract(18, 7);
		calc.toSubtract(16.5, 11.9);
		calc.toMultiply(56, 34);
		calc.toMultiply(36, 72.8);
		calc.toDivide(356, 8);
		calc.toDivide(256.64, 2);
		

	}

}
