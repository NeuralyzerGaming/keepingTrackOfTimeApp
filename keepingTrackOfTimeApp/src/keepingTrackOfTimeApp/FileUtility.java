package keepingTrackOfTimeApp;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileUtility {
	public static void openFile(File file) {
		Desktop d = Desktop.getDesktop();
		try {
			d.open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static File createFile(String name) {
		File f = new File(name + ".txt");
		try {
			if (f.createNewFile()) {
				System.out.println(name + " File created successfully at " + f.getAbsolutePath());
				return f;
			} else {
				System.out.println(name + " file already made at " + f.getAbsolutePath());
				return f;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void filePrint(File f, String text) {
		try {
			PrintStream p = new PrintStream(f);
			p.print(text);
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String fileToString(File f) {
		try {
			Scanner sc = new Scanner(f);
			String s = "";
			while (sc.hasNextLine()) {
				s += sc.nextLine() + "\n";
			}
			sc.close();
			return s;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void wipeFile(File f) {
		try {
			PrintStream p = new PrintStream(f);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile(File f) {
		System.out.println("File \"" + f.getName() + "\" deleted: " + f.delete());
	}
}
