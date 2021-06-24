package week1.assignment;

public class CharacterOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "welcome to chennai";
		int count =0;
		char[] char1 = str.toCharArray();
		for(int i=0;i<char1.length;i++) {
			
			if(char1[i]=='e') {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
