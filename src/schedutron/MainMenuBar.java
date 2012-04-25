package schedutron;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainMenuBar extends JMenuBar{

  public MainMenuBar(){
 // JFrame frame = new JFrame("Creating a JMenuBar, JMenu, JMenuItem and seprator Component");
//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 // JMenuBar menubar = new JMenuBar();
  JMenu filemenu = new JMenu("File");
  filemenu.add(new JSeparator());
  JMenu editmenu = new JMenu("Edit");
  editmenu.add(new JSeparator());
  JMenuItem newItem = new JMenuItem("New");
  JMenuItem openItem = new JMenuItem("Open");
  JMenuItem closeItem = new JMenuItem("Close");
  closeItem.add(new JSeparator());
  JMenuItem saveItem = new JMenuItem("Save");
  JMenuItem editItem1 = new JMenuItem("Cut");
  JMenuItem editItem2 = new JMenuItem("Copy");
  editItem2.add(new JSeparator());
  JMenuItem editItem3 = new JMenuItem("Paste");
  JMenuItem editItem4 = new JMenuItem("Insert");
  filemenu.add(newItem);
  filemenu.add(openItem);
  filemenu.add(closeItem);
  filemenu.add(saveItem);
  editmenu.add(editItem1);
  editmenu.add(editItem2);
  editmenu.add(editItem3);
  editmenu.add(editItem4);
  this.add(filemenu);
  this.add(editmenu);
//  frame.setJMenuBar(menubar);
//  frame.setSize(400,400);
//  frame.setVisible(true);
  

  
  newItem.addActionListener(new ActionListener()
  {
	public void actionPerformed(ActionEvent arg0)
	{
		ClassSelectorModel.emptyLists();
	} 

  });
  
  
  openItem.addActionListener(new ActionListener()
  {
	  public void actionPerformed(ActionEvent arg0)

	  {
		  JFileChooser chooser = new JFileChooser(".");
		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
		     ".txt files");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(getParent());
		  if(returnVal == JFileChooser.APPROVE_OPTION) {
			  System.out.println("You chose to open this file: " +
		    		chooser.getSelectedFile().getName());
			  FileManager fman = new FileManager();
			ArrayList<Course> courses = null;
			  try {
				  courses = fman.getClassesFromFile(chooser.getSelectedFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (courses != null){
				ClassSelectorModel.emptyLists();
				ClassSelectorModel.addToLeftList(courses);
			}
		  }
	  } 

  });
  
  closeItem.addActionListener(new ActionListener()
  {
	  public void actionPerformed(ActionEvent arg0)
	  {
		  System.exit(0);
	  } 
  });
  
  saveItem.addActionListener(new ActionListener()
  {
	public void actionPerformed(ActionEvent arg0)

	{
	JFileChooser chooser = new JFileChooser(".");

	int returnVal = chooser.showSaveDialog(getParent());
	if(returnVal == JFileChooser.APPROVE_OPTION) {
		System.out.println("You chose to save to this file: " +
			chooser.getSelectedFile().getName());
		FileManager fman = new FileManager();
		try {
			fman.writeToFile(chooser.getSelectedFile(),
					ClassSelectorModel.getSelected());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}

  });

  
  } 
}