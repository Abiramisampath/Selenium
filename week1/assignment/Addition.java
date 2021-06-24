package week1.assignment;

public class Addition {
	
	int input=9;
	
	public void display() {
		
		System.out.println(input);
	}

	public static void main(String[] args) {
		
		Addition obj = new Addition();
		System.out.println(obj.input);
		System.out.println(10+20+"Add");
		System.out.println("Add"+10+20);
		
		//System.out.println(input); why this is not valid.
		//Public static void main is also in the same class only 
		//then why we need to create object of the class to access the variable input
	
	}

}
