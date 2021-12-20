
import javax.swing.*;
abstract class parkingTemplate {
	//Method names and types that should be in the parkingStatus class
	public abstract void initializeParking();
	public abstract int getRandom(int min, int max);
	public abstract void updateParking(String text);
	public abstract void print();
	public abstract void checkParking(JCheckBox x);
	public abstract void reWriteFile();
	
}
