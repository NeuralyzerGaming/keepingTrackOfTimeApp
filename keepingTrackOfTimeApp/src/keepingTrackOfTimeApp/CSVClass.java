package keepingTrackOfTimeApp;

//import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;

public class CSVClass {

	String name;
	File f;
	ArrayList<ArrayList<String>> cordinateGrid = new ArrayList<ArrayList<String>>();

	public CSVClass(String name) {
		this.name = name;
		this.createCSVFile(this.name);
	}

	public void createCSVFile(String name) {
		f = FileUtility.createFile("CSVFile" + name);
		if (f == null) {
			System.out.println("Error creating CSV File");
		} else {
			this.cordinateGrid.add(new ArrayList<String>());
			this.cordinateGrid.get(0).add("");
		}
	}

//	public CSVClass(String name, boolean blankFile) {
//		this.name = name;
//		if (blankFile) {
//			try {
//				wipeFile();
//			} catch (NullPointerException e) {
//				e.printStackTrace();
//			}
//		}
//		f = FileUtility.createFile("CSVFile" + name);
//
//		if (f == null) {
//			System.out.println("Error creating CSV File");
//		} else {
//			this.cordinateGrid.add(new ArrayList<String>());
//			this.cordinateGrid.get(0).add("");
//		}
//	}

	public String returnIndex(int x, int y) {
		return this.cordinateGrid.get(x).get(y);
	}

	public void set(int x, int y, String input) {
		int totalInitialRows = this.cordinateGrid.size();
		for (int i = 0; i < totalInitialRows; i++) {
//			System.out.println("i: " + i);
//			System.out.println(this.cordinateGrid.get(i).size());
			for (int i2 = this.cordinateGrid.get(i).size(); i2 <= x; i2++) {
				this.cordinateGrid.get(i).add("");// i + "." + i2);
			}
		}
		for (int i = this.cordinateGrid.size(); i <= y; i++) {
			this.cordinateGrid.add(new ArrayList<String>());
			for (int i2 = this.cordinateGrid.get(i).size(); i2 <= x; i2++) {
				this.cordinateGrid.get(i).add("");// i + "." + i2 + "");
			}
		}
		this.cordinateGrid.get(y).set(x, input);
	}

//	public void addRow(int numb) {
//		for (int i = numb; i > 0; i--) {
//			// System.out.println("Adding Column " + numb);
//			this.cordinateGrid.add(new ArrayList<String>());
//		}
//	}
//
//	public void addColumn(int numb) {
//		for (int i = this.cordinateGrid.size(); i > 0; i--) {
//			for (int i2 = numb; i2 > 0; i2--) {
//				// System.out.println("Adding row " + i2 + " in column "+i);
//				this.cordinateGrid.get(i - 1).add("");
//			}
//		}
//	}

	public void wipeFile() {
		FileUtility.deleteFile(this.getFile());
		this.createCSVFile(this.name);
		System.out.println("CSV named \"" + this.name + "\" wiped");
	}
	
	public void wipeArray() {
		this.cordinateGrid = new ArrayList<ArrayList<String>>();
		this.cordinateGrid.add(new ArrayList<String>());
	}

	public void update() {// updates the .txt file
		String update = "";
//		this.wipeFile();
		for (int i = 0; i < this.cordinateGrid.size(); i++) {
//			System.out.println("Size of parent array " + this.cordinateGrid.size());
//			System.out.println("Column number: " + i);
//			System.out.println("Size of child array " + this.cordinateGrid.get(i).size());
			for (int i2 = 0; i2 < this.cordinateGrid.get(i).size(); i2++) {
//				System.out.println("Row number: " + i2);
//				System.out.println(this.cordinateGrid.get(i).get(i2) + ", \t");
				update += this.cordinateGrid.get(i).get(i2) + ", \t";
			}
			update += "\n";
			FileUtility.filePrint(this.getFile(), update);
		}
	}

	public File getFile() {
		return f;
	}

	public void init() {
		this.cordinateGrid.clear();
		this.cordinateGrid.add(new ArrayList<String>());
		String s = FileUtility.fileToString(this.getFile());
		String current;
		int row = 0;
		while (s.indexOf(",") != -1) {
			current = s.substring(0, s.indexOf(","));
			current = current.substring(current.indexOf("\t") + 1);
			if (current.indexOf("\n") != -1) {
				row++;
				current = current.substring(current.indexOf("\n") + 1);
				this.cordinateGrid.add(new ArrayList<String>());
			}
			s = s.substring(s.indexOf(",") + 1);
			this.cordinateGrid.get(row).add(current);
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.cordinateGrid.size(); i++) {
			for (int i2 = 0; i2 < this.cordinateGrid.get(i).size(); i2++) {
				s += this.cordinateGrid.get(i).get(i2) + ", \t";
			}
			s += "\n";
		}
		return s;
	}

}
