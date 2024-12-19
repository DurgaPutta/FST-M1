package activities;

public class MyBook extends Book{

	public static void main(String[] args) {
		MyBook newNovel = new MyBook();
		newNovel.setTitle("Car Bash");		
		System.out.println("The title is  " + newNovel.getTitle());

	}

	@Override
	void setTitle(String s) {
		title = s;
		
	}

}
