package week1.assignment;

public class ChangeOddIndexToUpperCase {

	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ChangeOddIndexToUpperCase obj=new ChangeOddIndexToUpperCase();
		obj.changeOddIndexToUpperCase();
	}

	
	
	
	private void changeOddIndexToUpperCase() {
		// TODO Auto-generated method stub
		
		String test = "changeme";
		char[] testArray = test.toCharArray();
		
		for(int i=0;i<testArray.length;i++) {
			
			if(i%2==0)
			{
				char ch=testArray[i];
				char ch1=Character.toUpperCase(ch);
				System.out.println(ch1);
				
			}
			else
			{					
				System.out.println(test.charAt(i));
			}
		}
		

	}
}
