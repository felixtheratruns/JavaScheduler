package schedutron;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class FileManager {

	ArrayList<Class> fileList = new ArrayList<Class>();
	
	public static BufferedReader getBufferedReader(File path) throws FileNotFoundException{

		// Open the file that is the first 
		// command line parameter
		FileInputStream fstream = new FileInputStream(path);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	 
	public File[] getFiles(String path){
		class OnlyExt implements FilenameFilter {
			String ext;
			public OnlyExt(String ext) {
			this.ext = "." + ext;
			}
			public boolean accept(File dir, String name) {
			return name.endsWith(ext);
			}
		}
		File folder = new File(path);
		FilenameFilter only = new OnlyExt("txt"); 
		File[] listOfFiles = folder.listFiles(only);
		return listOfFiles;
	}

	public void makeClasses() throws IOException{
		File[] files = getFiles("data");
		for (int i = 0; i < files.length; i++) {
			BufferedReader br = getBufferedReader(files[i]);
			String strLine;
			while ((strLine = br.readLine()) != null)   {
			// Print the content on the console
				System.out.println(strLine.split("\t")[0]);
			}
		}
	}
}
	


