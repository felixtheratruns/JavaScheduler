package schedutron;

import java.io.IOException;

import javax.swing.JFrame;

/** Main application class for JavaScheduler */
public class Application {
  /** Main function for initializing application */
  public static void main( String[] args ) {
    MainWindow main = null;
	try {
		main = new MainWindow();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SwingMenu sm = new SwingMenu();
	main.setJMenuBar(sm);
	main.setVisible(true);
  }
}
