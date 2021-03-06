package schedutron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class FileManager {

	private ArrayList<Course> courseList = new ArrayList<Course>();

	
	public static BufferedReader getBufferedReader(File path) throws FileNotFoundException{
		// Open the file that is the first 
		// command line parameter
		FileInputStream fstream = new FileInputStream(path);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	 
	//find all files that have the .txt extension in the data folder and return a list y
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

	//read in classes and make them
	public ArrayList<Course> getAllClassesInData() throws IOException{
		File[] files = getFiles("data");
		String l;
		for (int i = 0; i < files.length; i++) {
			courseList = getClassesFromFile(files[i]);
		}
		return courseList;
	}
	
	
	public ArrayList<Course> getClassesFromFile(File file) throws IOException{
		BufferedReader br = getBufferedReader(file);
		String strLine;
		ArrayList<Course> courses = new ArrayList<Course>();

		while ((strLine = br.readLine()) != null)   {
			ArrayList<String> line_elements = new ArrayList<String>();
	
			String[] line = strLine.split("\t");
			if (line.length == 13 ){
				ArrayList<String> els = new ArrayList<String>();
	
				for(int a = 0; a < line.length; a++){
					line[a] = line[a].trim();
				//	if (line[a].equals("")){
				//		continue;
				//	}
					els.add(line[a]);
				}
				Course course = new Course(els);
				courses.add(course);
			} else {
				System.out.println("not 13 long");
				for(String el : line){
					System.out.println(el);
				}
			}
		}
		return courses;
	}
	
	public void writeToFile(File file, ArrayList<Course> courses) throws IOException{
		FileWriter fstream = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fstream);
		if (file == null){
			return;
		}
		for(int i = 0 ; i < courses.size(); i++)  {	
			bw.write(courses.get(i).toFile());
		}
		bw.close();
	}	
}


