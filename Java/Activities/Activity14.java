package activities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/java/activities/testfile2.txt");
		boolean fStatus = file.createNewFile();
		File fileUtil = FileUtils.getFile("filepath");
		FileUtils.writeStringToFile(file, "Welcome to the Java World", "UTF-8");
		System.out.println("Data in file: " + FileUtils.readFileToString(file, "UTF8"));
		
		File destDir = new File("File Container");
		FileUtils.copyFileToDirectory(file, destDir);
		
		File newFile = FileUtils.getFile(destDir, "testfile2.txt");
		String newFileData = FileUtils.readFileToString(newFile, "UTF8");
		System.out.println("Data in new file: " + newFileData);

	}

}
