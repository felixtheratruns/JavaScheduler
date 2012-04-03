package schedutron;

import java.util.ArrayList;

/** Keeps a list of all available courses that have been entered */
public class Catalog {

  /** Container for all courses in the catalog */
  private ArrayList<Course> catalog;

  /** 
   * Add a course to the catalog
   * @param course -- the course to be added to the catalog
   */
  public void add(Course course) {
    catalog.add(course); 
    addListenersNotify();
  }

  /**
   * Remove a course from the catalog
   * @param course -- the course to be removed from the catalog
   */
  public void remove(Course course) {
    catalog.remove(course);
    removeListenersNotify();
  }

  /**
   * Method stub, to be used when I figure out how to get the data and the UI
   * to talk to each other
   */
  public void addListenersNotify() {
    // TODO: Implement me!
  }

  /**
   * Method stub, to be used when I figure out how to get the data and the UI
   * to talk to each other
   */
  public void removeListenersNotify() {
    // TODO: Implement me!
  }
}
