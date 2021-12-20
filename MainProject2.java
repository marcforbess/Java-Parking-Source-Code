import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainProject2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			userLogIn object = new userLogIn();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
	}
	}
}
