package week3;

public class College extends Univesity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Univesity obj = new College();
		obj.postGraduate();
		obj.underGraduate();

	}

	@Override
	public void underGraduate() {
		// TODO Auto-generated method stub
		System.out.println("Under Graduate courses offered");
	}

}
