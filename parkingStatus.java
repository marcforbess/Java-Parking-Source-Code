import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
public class parkingStatus extends parkingTemplate{
	private int parkingspots[][];
	private int unique_ID;
	
	
	public void initializeParking() {
		parkingspots = new int[7][4];
		try {
			Scanner sc = new Scanner(new BufferedReader(new FileReader("src\\parkingspots")));
			 while(sc.hasNextLine()) {
		         for (int i=0; i<parkingspots.length; i++) {
		            String[] line = sc.nextLine().trim().split(",");
		            for (int j=0; j<line.length; j++) {
		               parkingspots[i][j] = Integer.parseInt(line[j]);
		            }
		         }
		      }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateParking(String spot) {
		int converted = Integer.parseInt(spot);
		int picked_row = converted/10;
		int picked_col = converted%10;
		unique_ID = getRandom(1000, 9999);
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<4; j++) {
				while(parkingspots[i][j] == unique_ID) {
					unique_ID = getRandom(1000, 9999);
				}
			}
		}
		
		parkingspots[picked_row][picked_col] = unique_ID;
		
		reWriteFile();
		
	}
	
	public void reWriteFile() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 7; i++)
		{
		   for(int j = 0; j < 4; j++)
		   {
		      builder.append(parkingspots[i][j]+"");
		      if(j < parkingspots.length - 1)
		         builder.append(",");
		   }
		   builder.append("\n");
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("src\\parkingspots"));
			writer.write(builder.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void checkforUniqueID(String UniqueID) {
		int ID = Integer.parseInt(UniqueID);
		boolean found = false;
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<4; j++) {
				if(parkingspots[i][j]==ID) {
					JOptionPane.showMessageDialog(null, "SUCCESSFULLY REMOVED FROM SPOT: "+i+j);
					parkingspots[i][j] = -1;
					reWriteFile();
					initializeParking();
					found = true;
				}
			}
		}
		
		if(found==false) {
			JOptionPane.showMessageDialog(null, "VEHICLE NOT FOUND, MAKE SURE UNIQUE ID IS ENTERED CORRECTLY", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int getUniqueID() {
		return this.unique_ID;
	}
	
	public void checkParking(JCheckBox box) {
		int converted = Integer.parseInt(box.getText());
		int row = converted/10;
		int column = converted%10;
		
		if(parkingspots[row][column] != -1) {
			box.setBackground(Color.red);
			box.setSelected(true);
			box.setEnabled(false);
		}else {
			box.setBackground(Color.green);
		}
		
	}
	
	public void print() {
		for(int i=0; i<7; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(parkingspots[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int getRandom(int min, int max){
	    int x = (int) ((Math.random()*((max-min)+1))+min);
	    return x;
	}
}
