/**
 * 
 */
package keepingTrackOfTimeApp;

import java.io.File;
import java.util.ArrayList;

/**
 * @author warren
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CSVClass csvFile = new CSVClass("KeepingTrackOfTimeApp");
		csvFile.init(true);
//		csvFile.set(2, 3, "a");
//		csvFile.set(1, 4, "b");
//		csvFile.set(8, 1, "c");
//		csvFile.set(10, 15, "test");
//		csvFile.set(1, 1, "test");
		csvFile.set(0, 0, "lol");
		csvFile.update();
		System.out.println(csvFile.toString());
//		FileUtility.openFile(csvFile.getFile());
//		csvFile.wipeFile();
//		csvFile.wipeArray();
//		System.out.println(csvFile.toString());
		FileUtility.openFile(csvFile.getFile());
	}
}
