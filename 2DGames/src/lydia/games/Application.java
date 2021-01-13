package lydia.games;
//January 13, 2021

import java.awt.EventQueue; 

import javax.swing.JFrame;

public class Application extends JFrame { //now it's a JFrame. it has all those abilities.
	int height = 900;
	int width = 600;
	String title = "Title";	
	
	public Application() {
		initUI(); //init user interface
	}
	
	private void initUI() { //method
		add(new Board());
		
		setSize(width, height); //with making games we don't want to hard-code these, so we're gonna make the variables
		//class level variables
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pack(); //takes everything on the screen and packs into the smallest size possible
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{  //pass in method as parameter - arrow function
			Application ex = new Application();
			ex.setVisible(true);
		});

	}

}
