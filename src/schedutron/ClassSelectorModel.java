package schedutron;

import java.awt.GridBagConstraints;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClassSelectorModel implements ListSelectionModel{
    JList<Course> list;
    static JList<Course> selected_list;
    static JPanel panel;
    GridBagConstraints c;
    JScrollPane listScroller; 
    static JScrollPane selectedListScrollPane; 
    JSplitPane splitPane;
    Course[] mcourses;
    Course[] mcourses_selected;
    Course[] mcourses_left;

      
	public ClassSelectorModel(Course[] courses) {

		    c = new GridBagConstraints();
	        c.fill = GridBagConstraints.BOTH;
	        c.weighty = 1;

//		    JTextField userInput = new JTextField(20);
//		    selector_panel.add(userInput);
		    mcourses = courses;
		    Course[] temp = {};
		    mcourses_selected = temp;
		    mcourses_left = courses;

		    list = new JList<Course>(courses); 
		    list.setLayoutOrientation(JList.VERTICAL);
		    list.setVisibleRowCount(-1);
		    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    listScroller = new JScrollPane(list);

		    selected_list = new JList<Course>(); 
		    selected_list.setLayoutOrientation(JList.VERTICAL);
		    selected_list.setVisibleRowCount(-1);
		    selectedListScrollPane = new JScrollPane(selected_list);
		    
		    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                    listScroller, selectedListScrollPane);
		 //   listScroller.setPreferredSize(new Dimension(250, 80));
		  //  listScroller
	}
	
	  
	public void setPanel(JPanel panel){
		 panel.add(splitPane, c);
	}
	  
	public JPanel getPanel(){
		 return panel;
	}
	



	


	
	public class CourseSelectorListener implements ListSelectionListener {
		//Course[] unselected_courses;
	//	Course[] selected_courses;
		boolean repeat = false;
		public CourseSelectorListener(){
		//	unselected_courses = punselected_courses;
	//		selected_courses = pselected_courses;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
		
		
			//a hack to keep the valueChanged from being fired again
			//if I add a another freaking value to the list of courses
			//it makes no sense that it would be fired like that.
		
			 if (!repeat){
				repeat = true;
			} else {
				repeat = false;
				return;
			}
	
			// TODO Auto-generated method stub
			System.out.println("here is the class");
		    System.out.println(e.getClass());
			 
	        JList<Course> list = (JList<Course>)e.getSource();
	        Course newcourse = list.getSelectedValue();
	        Course[] temp = {newcourse};
	        mcourses_selected = concatCourses(mcourses_selected, temp);
	        selectorListFunction(newcourse, mcourses_selected);  

		}
		public void selectorListFunction (Course selected, Course[] courses) {
			//	Course[] selected_array = {selected};
			//	Course[] newlist = concatCourses(courses, selected_array);
				
			//	list
				
			//	
			    selected_list.setListData(courses);
				System.out.println("second called");


			}
	}
	
	public static <Course> Course[] concatCourses(Course[] first, Course[] second) {
		  Course[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
		}
	
	
	public class CourseDeselectorListener implements ListSelectionListener {
		Course[] unselected_courses;
		Course[] selected_courses;
		boolean repeat = false;
		public CourseDeselectorListener(){			

		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
			//a hack to keep the valueChanged from being fired again
			//if I add a another freaking value to the list of courses
			//it makes no sense that it would be fired like that.
		/*
			 if (!repeat){
				repeat = true;
			} else {
				repeat = false;
				return;
			}
			*/ 
			if (e.getValueIsAdjusting() == false) {
		        if (list.getSelectedIndex() == -1) {

		         } else {
			 
				JList<Course> list = (JList<Course>)e.getSource();
				Course newcourse = list.getSelectedValue();
				Course[] temp = {newcourse};
				mcourses_selected = concatCourses(mcourses_selected, temp);
				selectedListFunction(newcourse, mcourses_selected); 
		        }
			}
			 
	   //     JList<Course> list = (JList)e.getSource();
	   //     selectedListFunction(list.getSelectedIndices(),unselected_courses);  
		}
		

		
		public void selectedListFunction (Course course, Course[] courses) {

			//int[] indices
			
			
			System.out.println("selected list called");
			/*
			Course[] selected_courses = new Course[indices.length];
		    for(int i=0 ; i<indices.length;i++ ){
		    	selected_courses[i] = courses[indices[i]];
		    }
		    
		    selected_list.setListData(selected_courses);
		    */
		}
	}



	@Override
	public void addListSelectionListener(ListSelectionListener x) {
		list.addListSelectionListener(x);
	}
	
	public void addListDeselectionListener(ListSelectionListener x){
		selected_list.addListSelectionListener(x);
	}

	@Override
	public void addSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAnchorSelectionIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeadSelectionIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxSelectionIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinSelectionIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelectionMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getValueIsAdjusting() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertIndexInterval(int index, int length, boolean before) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSelectedIndex(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelectionEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeIndexInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListSelectionListener(ListSelectionListener x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnchorSelectionIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLeadSelectionIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectionMode(int selectionMode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueIsAdjusting(boolean valueIsAdjusting) {
		// TODO Auto-generated method stub
		
	}
	
	public void addListeners(){
	    this.addListSelectionListener(new CourseSelectorListener());
//	    this.addListDeselectionListener(new CourseDeselectorListener());

	}

}
