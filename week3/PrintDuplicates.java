package week3;

import java.util.ArrayList;
import java.util.List;

public class PrintDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data= {1,3,8,3,11,5,6,4,7,6,7};
		
		List<Integer> listNum = new ArrayList<Integer>();
		
		for (Integer eachNum : data) {
			listNum.add(eachNum);
						
		}
	
		System.out.println(listNum);
		
		for(int i=0;i<listNum.size()-1;i++){
			
			
			
						if(listNum.get(i) == (listNum.get(i+1)));
						System.out.println(listNum.get(i));
		}
	}

}
