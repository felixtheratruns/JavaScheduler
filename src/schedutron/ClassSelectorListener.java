package schedutron;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClassSelectorListener implements ListSelectionListener {
	Course[] courses;
	public ClassSelectorListener(Course[] list_of_courses){
		courses = list_of_courses;
	}
	

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
        JList<Course> list = (JList)e.getSource();
        // ClassSelectorModel.updateLabel(list.getSelectedIndices(), courses);
        
	}
	

	

}
