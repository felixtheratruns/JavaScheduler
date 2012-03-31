package schedutron;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author <a href="mailto:djsmit01@louisville.edu">Daniel J. Smith</a>
 */
public class Course {
  /** The course's number (ie. "CECS 550") */
  private String number;
  /** The course's title (ie. "Software Engineering") */
  private String title;
  /** The number of credit hours for taking the course */
  private int hours;
  /** The times at which the course meets */
  private ArrayList<TimeBlock> times; // TODO: Find optimal container type

  public Course ( String number, String title, String dayCodes, Date start, 
                  Date end, int hours ) {
    this.number = number;
    this.title = title;
    char[] days = dayCodes.toCharArray();
    times = new ArrayList<TimeBlock>();
    for (char day : days) {
      TimeBlock time = new TimeBlock( day, start, end );
      times.add( time );
    }
  }
	
  public ArrayList<TimeBlock> getTimes() {
    return times;
  }
  
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public boolean ConflictsWith(Course course) {
    for(TimeBlock timeA : times) {
      for(TimeBlock timeB : course.getTimes()) {
        if ( timeA.ConflictsWith( timeB ) ) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean ConflictsWith( TimeBlock time ) {
    for(TimeBlock timeA : times) {
      if (time.ConflictsWith( timeA )) {
        return true;
      }
    }
    return false;
  }

  public String toString() {
    return number + " | " + title;
  }

}
