package week3;

public class ZeroToRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,0,3,0,1,5,2,0};
		int temp =0;
		for (int i : num) {
			if(num[i]!=0) {
				num[temp++] = num[i];
			}
	}
		for(int j=temp;j<num.length;j++)
		{
			num[temp++] = 0;
		}
		
		for (int i : num) {
			System.out.println(num[i]);
		}
	}
	

}
