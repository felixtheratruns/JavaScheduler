package schedutron;

import java.util.Date;

public class TimeBlock {
  private char day;
  private Date start;
  private Date end;

  public TimeBlock( char day, Date start, Date end ) {
    this.day = day;
    this.start = start;
    this.end = end;
  }

  public char getDay() {
    return day;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public boolean ConflictsWith(TimeBlock timeA) {
    if (day != timeA.getDay()) {
      return false;
    }
    else {
      // XXX: Clever, but really unclear what it does. Java sucks anyway so why
      // are you trying to optimize it?
      int comp_s = start.compareTo( timeA.getStart() );
      int comp_e = start.compareTo( timeA.getEnd() );
      if (comp_s != comp_e)
      {
        return true;
      }
      else {
        return false;
      }
    }
  }

  public String toString() {
    return start + " to " + end;
  }

}
