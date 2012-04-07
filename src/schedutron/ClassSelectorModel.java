package schedutron;

import java.awt.GridBagConstraints;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
	
	
	
	public Course[] removeCourse( Course deleteMe, Course[] input) {
	    List result = new LinkedList();

	    for(Course item : input)
	        if(!deleteMe.equals(item))
	            result.add(item);

	    return (schedutron.Course[]) result.toArray(input);
	}
	  
	public void setPanel(JPanel panel){
		 panel.add(splitPane, c);
	}
	  
	public JPanel getPanel(){
		 return panel;
	}
	
	public static <Course> Course[] concatCourses(Course[] first, Course[] second) {
		  Course[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
	}
	
	public class CourseSelectorListener implements ListSelectionListener {

		boolean repeat = false;
		public CourseSelectorListener(){
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
		
			if (e.getValueIsAdjusting() == false) {
				if (list.getSelectedIndex() == -1) {
				} else {

					JList<Course> ret_list = (JList<Course>)e.getSource();
					Course newcourse = ret_list.getSelectedValue();
					Course[] temp = {newcourse};
					mcourses_selected = concatCourses(mcourses_selected, temp);
					selectorListFunction(newcourse);  
				}
			}
		}
		

		public void selectorListFunction (Course selected) {
				mcourses_left = removeCourse(selected,mcourses_left);
				list.setListData(mcourses_left);
			    selected_list.setListData(mcourses_selected);

		}
	}

	
	
	public class CourseDeselectorListener implements ListSelectionListener {
		Course[] unselected_courses;
		Course[] selected_courses;
		boolean repeat = false;
		public CourseDeselectorListener(){			

		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting() == false) {
				if (selected_list.getSelectedIndex() == -1) {
				} else {

					JList<Course> ret_list = (JList<Course>)e.getSource();
					Course newcourse = ret_list.getSelectedValue();
					Course[] temp = {newcourse};
					mcourses_left = concatCourses(mcourses_left, temp);
					selectedListFunction(newcourse);  
				}
			}

		}
		

		
		public void selectedListFunction (Course selected) {

			//int[] indices
			mcourses_selected = removeCourse(selected,mcourses_selected);
			selected_list.setListData(mcourses_selected);
		    list.setListData(mcourses_left);
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
	    this.addListDeselectionListener(new CourseDeselectorListener());

	}

}
