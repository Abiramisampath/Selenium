package week3;

public class SmartPhone extends AndroidPhone {
	
	public void connectWhatsApp() {
		// TODO Auto-generated method stub
		
		System.out.println("connectWhatsApp from SmartPhone class");
	}
	
	@Override
	public void takeVideo() {
		// TODO Auto-generated method stub
		super.takeVideo();
		System.out.println("from smartphone");
	}
}
