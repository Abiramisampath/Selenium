package week1.assignment;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "We learn java basics as part of java sessions in java week1";
		int count =0;
		String[] arraySplit = text.split("");
		//for(int i=0;i<arraySplit.length;i++) 
		//{ 
		//	System.out.println(arraySplit[i]); 
		//	}
		
		 

		for(int i=0;i<arraySplit.length;i++) {
			
			count=1;
			
			for(int j=i+1;j<arraySplit.length;j++)
			{
				if(arraySplit[i].equals(arraySplit[j])) {
					count++;
					//arraySplit[j] = "o";
					
				}
			}
			
			if(count>1)
			{
				arraySplit[i] = arraySplit[i].replace(arraySplit[i],"");
				
			}
			/*
			 * else { System.out.println(arraySplit[i]); }
			 */
			System.out.println(arraySplit[i]);
			
		}
		
	}

}
