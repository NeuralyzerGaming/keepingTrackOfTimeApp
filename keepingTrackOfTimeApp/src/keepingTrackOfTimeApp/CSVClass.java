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

	private void createCSVFile(String name) {
		f = FileUtility.createFile("CSVFile" + name);
		if (f == null) {
			System.out.println("Error creating CSV File");
		} else {
			this.cordinateGrid.add(new ArrayList<String>());
		}
	}

	public String returnIndex(int x, int y) {
		return this.cordinateGrid.get(x).get(y);
	}

	public void set(int x, int y, String input) {
		while (cordinateGrid.size() <= y) {
			cordinateGrid.add(new ArrayList<String>());
		}
		for (ArrayList<String> list : this.cordinateGrid) {
			while (list.size() <= x) {
				list.add("");
			}
		}

		this.cordinateGrid.get(y).set(x, input);
	}

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
		for (int i = 0; i < this.cordinateGrid.size(); i++) {
			for (int j = 0; j < this.cordinateGrid.get(i).size(); j++) {
				update += this.cordinateGrid.get(i).get(j) + ",\t";
			}
			update += "\n";
			FileUtility.filePrint(this.getFile(), update);
		}
	}

	public File getFile() {
		return f;
	}

	public void init(boolean carryOver) {
		this.cordinateGrid.clear();
		this.cordinateGrid.add(new ArrayList<String>());
		if (carryOver) {
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
