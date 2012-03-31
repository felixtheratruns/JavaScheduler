package schedutron;

import java.util.ArrayList;

public class Catalog {
  /** Container for all courses in the catalog */
  private ArrayList<Course> catalog;

  public void add(Course course) {
    catalog.add(course); 
    addListenersNotify();
  }

  public void remove(Course course) {
    catalog.remove(course);
    removeListenersNotify();
  }

  public void addListenersNotify() {
    // TODO: Implement me!
  }

  public void removeListenersNotify() {
    // TODO: Implement me!
  }
}