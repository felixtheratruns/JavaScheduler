package schedutron;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Stores information about the Course -- the course number, title, etc.
 * @author <a href="mailto:djsmit01@louisville.edu">Daniel J. Smith</a>
 */
public class Course {
	private String ClassNbr;
	private String Subj;
	private String CatNbr; 	
	private String Sec;
	private String Title; 	
	private String Days;	
	private String Time;	
	private String Bldg;
	private String Enroll; 	
	private String Wait;
	private String Instr; 	
	private String Units;
	private String Location;	

	/** The course's number (ie. "CECS 550") */
  	private String number;
  	/** The course's title (ie. "Software Engineering") */
  	private String title;
  	/** The number of credit hours for taking the course */
  	private double hours;
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
  
  
  public Course (ArrayList<String> l) {
	  	ClassNbr = l.get(0);
		Subj = l.get(1);
		CatNbr =l.get(2);
		Sec =l.get(3);
		Title =l.get(4);
		Days = l.get(5);
		Time = l.get(6);
		Bldg =l.get(7);
		Enroll = l.get(8);
		Wait = l.get(9);
		Instr = l.get(10);
		Units = l.get(11);
		Location = l.get(12);

		
		System.out.println("class number: "+ClassNbr);
		System.out.println("subject: "+Subj);
		System.out.println("cat number: "+CatNbr);
		System.out.println("sec: "+Sec);
		System.out.println("title: "+Title);
		System.out.println("days: "+Days);
		System.out.println("time: "+Time);
		System.out.println("bldg: "+Bldg);
		System.out.println("enrol: "+Enroll);
		System.out.println("wait: "+Wait);
		System.out.println("instr: "+Instr);
		System.out.println("units: "+Units);
		System.out.println("location: "+Location);

		
		number = ClassNbr;
		title = Title;
		if(Units.equals("")){
			//do nothing
		} else {
			hours = Double.parseDouble(Units);
		}
	    SimpleDateFormat sdf = new SimpleDateFormat("h:mma");
	    if(Time.equals("TBA") || Time.equals("")){
	    	//don't do anything
	    }else {
		    String[] time_block = Time.split("-");
		    Date start = null;
		    Date end = null;
			try {
				start = sdf.parse(time_block[0]);
			    end = sdf.parse(time_block[1]);
	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
		    char[] days = Days.toCharArray();
		    times = new ArrayList<TimeBlock>();
		    // TODO: Validate dayString input so it's not something stupid like "VNZZ"
		    for (char day : days) {
		      TimeBlock time = new TimeBlock( day, start, end );
		      times.add( time );
		    }
	    }
		

	/*  
	  char[] days = dayCodes.toCharArray();
	  times = new ArrayList<TimeBlock>();
	  // TODO: Validate dayString input so it's not something stupid like "VNZZ"
	  for (char day : days) {
		  TimeBlock time = new TimeBlock( day, start, end );
		  times.add( time );
	  }
	  */
}
  public Course (String pClassNbr, String pSubj, String pCatNbr, String pSec, 
		  String pTitle, String pDays, String pTime, String pBldg, String pEnroll, 
		  String pWait, String pInstr, String pUnits, String pLocation) {
		ClassNbr = pClassNbr;
		Subj = pSubj;
		CatNbr = pCatNbr;
		Sec = pSec;
		Title = pTitle;
		Days = pDays;
		Time = pTime;
		Bldg = pBldg;
		Enroll = pEnroll;
		Wait = pWait;
		Instr = pInstr;
		Units = pUnits;
		Location = pLocation;

	  
	/*  
	  char[] days = dayCodes.toCharArray();
	  times = new ArrayList<TimeBlock>();
	  // TODO: Validate dayString input so it's not something stupid like "VNZZ"
	  for (char day : days) {
		  TimeBlock time = new TimeBlock( day, start, end );
		  times.add( time );
	  }
	  */
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

  public double getHours() {
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
