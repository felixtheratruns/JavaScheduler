package schedutron;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClassSelectorModel implements ListSelectionModel{
  
	//list on the left
	JList<Course> list;
    //list on the right
    static JList<Course> selected_list;

    GridBagConstraints c;
    
    //scroll pane for list on the left
    static JScrollPane listScroller; 
    //scroll pan for list on the right
    static JScrollPane selectedListScrollPane; 
    //the pane that holds the two lists
    JSplitPane splitPane;
    //the list models that are used for adding and removing elements from the lists
    private DefaultListModel<Course> listmodel_selected;
    private DefaultListModel<Course> listmodel_left;
    
    //the list of courses passed to the constructor
    //not used yet
    ArrayList<Course> mcourses = new ArrayList<Course>();

    
      
	public ClassSelectorModel(ArrayList<Course> courses) {

		    c = new GridBagConstraints();
	        c.fill = GridBagConstraints.BOTH;
	        c.weighty = 1;

		    mcourses = courses;
		    ArrayList<Course> mcourses_left = courses;
		    

		    listmodel_left = new DefaultListModel<Course>();
			Course[] courseArray = new Course[mcourses_left.size()];
		    addToListModel(mcourses_left.toArray(courseArray));
		    list = new JList<Course>(listmodel_left);
		    
		    list.setLayoutOrientation(JList.VERTICAL);
		    list.setVisibleRowCount(-1);
		    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    listScroller = new JScrollPane(list);

		    //set dimensions on scoll pane so list displays correctly
		    listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    listScroller.setBounds(1, 1, 400, 500);
		    listScroller.setMaximumSize(new Dimension(300,500));
		    listScroller.setPreferredSize(new Dimension(300,500));
		    
		    //set up list model
		    listmodel_selected = new DefaultListModel<Course>();
		    //make it the model for the selected_list
		    selected_list = new JList<Course>(listmodel_selected); 
		    selected_list.setLayoutOrientation(JList.VERTICAL);
		    selected_list.setVisibleRowCount(20);
		    //make it the right scroll pane
		    selectedListScrollPane = new JScrollPane(selected_list);
		    
		    //add both right and left scrollpans to the splitpane
		    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                    listScroller, selectedListScrollPane);
		    splitPane.setBounds(10, 10, 10, 10);
	}
	
	
	private void addToListModel(Course[] arr_courses){
		for(Course c : arr_courses){
			listmodel_left.addElement(c);
		}
	}
	
	private void addToSelectedListModel(Course[] arr_courses){
		for(Course c : arr_courses){
			listmodel_selected.addElement(c);
		}
	}
	
	public Course[] removeCourse( Course deleteMe, Course[] input) {
	    List<Course> result = new LinkedList<Course>();
	    if (input.length > 0){
	    	for(Course item : input)
	    		if(!deleteMe.equals(item))
	    			result.add(item);
	    } 
	    return (schedutron.Course[]) result.toArray(input);
	}
	  
	public void setPanel(JPanel panel){
		 panel.add(splitPane, c);
	}
	  
	public static <Course> Course[] concatCourses(Course[] first, Course[] second) {
		  Course[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
	}
	
	public class CourseSelectorListener implements ListSelectionListener {

		public CourseSelectorListener(){
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
		
			if (e.getValueIsAdjusting() == false) {
				if (list.getSelectedIndex() == -1) {
				} else {

					JList<Course> ret_list = (JList<Course>)e.getSource();
					Course newcourse = ret_list.getSelectedValue();
					listmodel_selected.addElement(newcourse);
					listmodel_left.removeElement(newcourse);  
				}
			}
		}
		
	}

	
	
	public class CourseDeselectorListener implements ListSelectionListener {

		public CourseDeselectorListener(){			

		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting() == false) {
				if (selected_list.getSelectedIndex() == -1) {
				} else {

					JList<Course> ret_list = (JList<Course>)e.getSource();
					Course newcourse = ret_list.getSelectedValue();;
					listmodel_left.addElement(newcourse);
					listmodel_selected.removeElement(newcourse);
				}
			}

		}
	}



	@Override
	public void addListSelectionListener(ListSelectionListener x) {
		list.addListSelectionListener(x);
	}
	
	public void addListDeselectionListener(ListSelectionListener x){
		selected_list.addListSelectionListener(x);
	}

	public void addListeners(){
	    this.addListSelectionListener(new CourseSelectorListener());
	    this.addListDeselectionListener(new CourseDeselectorListener());

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
	


}
