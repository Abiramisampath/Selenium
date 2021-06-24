package week1.assignment;

import java.util.Arrays;

public class MissingElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);	
		}
		
		
		
		  for(int i=1;i<arr.length;i++) {
		  
		  if(i==arr[i]) { 
			  
			  continue;
			 
		  }
		  else {
			  System.out.println(i);
			  break;
		  
		  }
		  }
		 

	}

}
