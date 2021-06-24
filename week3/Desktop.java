package week3;

public class Desktop implements HardWare,SoftWare {
	
	private void desktopModel() {
		// TODO Auto-generated method stub
		System.out.println("Desktop Model is: Dell");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Desktop dt= new Desktop();
		dt.desktopModel();
		dt.hardwareResources();
		dt.softwareResources();
		
		

	}

	public void softwareResources() {
		// TODO Auto-generated method stub
		
		System.out.println("Software Resources");
		
	}

	public void hardwareResources() {
		// TODO Auto-generated method stub
		System.out.println("Hardware Resources");
		
	}

}
