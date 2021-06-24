package week1.assignment;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 ="stops";
		String str2 ="potss";
		
		/*
		 * String text = "(2345)"; System.out.println(text.replaceAll("[^0-9]", ""));
		 */
		char[] char1=str1.toCharArray();
		char[] char2=str2.toCharArray();
		
		if(str1.length()==str2.length())
		{
			
			Arrays.sort(char1);
			Arrays.sort(char2);
			System.out.println(char1);
			System.out.println(char2);
			/*
			 * for(int i=0;i<char1.length;i++) {
			 * 
			 * for(int j=i+1;j<char1.length;j++) {
			 * 
			 * char temp = char1[i]; char1[i] = char1[j]; char1[j] = temp;
			 * 
			 * char temp1 = char2[i]; char2[i] = char2[j]; char2[j] = temp1; } }
			 */
			
			System.out.println(Arrays.toString(char1));
			System.out.println(Arrays.toString(char2));
			
			
		}
		
		
		
		
	}

}
