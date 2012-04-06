package schedutron;

import java.util.ArrayList;
import java.util.Date;

/**
 * Stores information about the Course -- the course number, title, etc.
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

  /** 
   * Create a new Course
   * @param number -- The course's number (ie. "CECS 550")
   * @param title -- The course's title (ie. "Software Engineering")
   * @param dayCodes -- String containing chars (UMTWRFS) of the days the course
   * meets at.
   * @param start -- The time at which the course meets
   * @param end -- The time at which the course lets out
   * @param hours -- The number of credit hours for taking the course
   */
  public Course ( String number, String title, String dayCodes, Date start, 
                  Date end, int hours ) {
    this.number = number;
    this.title = title;
    char[] days = dayCodes.toCharArray();
    times = new ArrayList<TimeBlock>();
    // TODO: Validate dayString input so it's not something stupid like "VNZZ"
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

  /**
   * Determine if the current course has time conflicts with a specified course
   * @param course -- the course to be checked for conflicts
   * @return True if there is a conflict, false otherwise
   */
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

  /**
   * Determine if the current course has time conflicts with a single time block
   * @param time -- a timeblock to be checked for conflicts
   * @return True if there is a conflict, false otherwise
   */
  public boolean ConflictsWith( TimeBlock time ) {
    for(TimeBlock timeA : times) {
      if (time.ConflictsWith( timeA )) {
        return true;
      }
    }
    return false;
  }

  /**
   * Overridden toString() method, string is course number and title separated 
   * by a | (pipe) (eg. "ENGR 550 | Software Engineering")
   */
  public String toString() {
    return number + " | " + title;
  }

}
