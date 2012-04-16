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

	ArrayList<Course> classList = new ArrayList<Course>();
	
	public static BufferedReader getBufferedReader(File path) throws FileNotFoundException{

		// Open the file that is the first 
		// command line parameter
		FileInputStream fstream = new FileInputStream(path);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	 
	public void test(){
		
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

	public ArrayList<Course> makeClasses() throws IOException{
		File[] files = getFiles("data");
		for (int i = 0; i < files.length; i++) {
			BufferedReader br = getBufferedReader(files[i]);
			String strLine;
			while ((strLine = br.readLine()) != null)   {
			// Print the content on the console
				String[] lines = strLine.split("\t");
				if (lines.length == 13 ){
					for(String line : lines){
						line = line.trim();
						if (line.equals("")){
							continue;
						}
						System.out.println(line);
					}
				} else {
					System.out.println("not 13 long");
					for(String line : lines){
						System.out.println(line);
					}
				}
			}
			
		}
		return classList;
	}
}
	


