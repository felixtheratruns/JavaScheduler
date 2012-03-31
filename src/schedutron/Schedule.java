package schedutron;

import java.util.ArrayList;

public class Schedule {
  private ArrayList<Course> available;
  private ArrayList<Course> courses;

  public ArrayList<Course> getAvailable() {
    return available;
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }

  public void addCourse( Course course ) {
    courses.add( course );
  }
  // TODO: Notify window when course is added.

  public int getTotalHours() {
    int hours = 0;
    for (Course course : courses ) {
      hours += course.getHours();
    }
    return hours;
  }

  public Schedule () {
    available = new ArrayList<Course>();
    courses = new ArrayList<Course>();
  }
}
