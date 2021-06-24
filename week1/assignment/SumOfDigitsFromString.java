package week1.assignment;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "Tes12Le79af65";
		int sum = 0;
		int temp =0;
		char[] textArray=text.toCharArray();
		
		for(int i=0;i<textArray.length;i++) {
			
			if(Character.isDigit(textArray[i]))
			{
				sum = sum + textArray[i];
			}
			else
			{
				sum = sum + Character.getNumericValue(textArray[i]);
			}
			
			temp = temp +sum;
		}
		
		System.out.println(temp);
	}

}
