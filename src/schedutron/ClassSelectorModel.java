package schedutron;

import java.awt.GridBagConstraints;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public class ClassSelectorModel implements ListSelectionModel{
      JList<Course> list;
      JList<Course> selected_list;
      JPanel panel;
      GridBagConstraints c;
      JScrollPane listScroller; 
      
	  public ClassSelectorModel(Course[] courses) {

		    c = new GridBagConstraints();
	        c.fill = GridBagConstraints.BOTH;
	        c.weighty = 1;

//		    JTextField userInput = new JTextField(20);
//		    selector_panel.add(userInput);
		    

		    list = new JList<Course>(courses); //data has type Object[]
		    list.setLayoutOrientation(JList.VERTICAL);
		    list.setVisibleRowCount(-1);
		    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		    listScroller = new JScrollPane(list);
		 //   listScroller.setPreferredSize(new Dimension(250, 80));
		  //  listScroller


	  }
	  
	  public void setPanel(JPanel panel){
			panel.add(listScroller, c);
	  }
	  
	  public JPanel getPanel(){
		  return panel;
	  }

	
	@Override
	public void addListSelectionListener(ListSelectionListener x) {
		list.addListSelectionListener(x);
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
