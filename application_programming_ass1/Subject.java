import java.util.*;

public class Subject
{
    private int number;
    private String name;
    private LinkedList<Activity> activities = new LinkedList<Activity>();
    public Subject(int number, String name)
    {
        //initialise the fields
        this.number = number;
        this.name = name;     
    }

    public void addActivity(String group, int number, String day, int start, int duration,String room, int capacity)
    {
        activities.add(new Activity(this, group, number,day, start, duration, room, capacity));
    }

    public void printActivity(Subject subject)
    {        
        for (Activity activity: activities)
        {
            if(activity.getSubject()== subject)
            {
                System.out.println(activity);
            }
        }                
    }

    public Activity enrolInActivity(String group, int activityNumber)
    {
        Activity enrolledActivity = null;
        for (Activity activity: activities)
        {
            if(activity.getGroup().equals(group) && activity.getNumber() == activityNumber)
            {
                if (activity.hasCapacity())
                {
                    activity.enrolStudent();
                    enrolledActivity = activity;
                    //System.out.println("Enrolled in Subject");
                }
                else
                {
                    System.out.println("No available seats");
                }
            }        
        }
        return enrolledActivity;
    }

    public Activity autoEnrolInActivity(String group, int activityNumber)
    {
        Activity enrolledActivity = null;
        for (Activity activity: activities)
        {
            if(activity.getGroup().equals("Cmp1") && activity.getNumber() == activityNumber)
            {
                if (activity.hasCapacity())
                {
                    activity.enrolStudent();
                    enrolledActivity = activity;
                    //System.out.println("Enrolled in Subject");
                    return enrolledActivity;
                }

            }        
        }
        return null;
    }

    public boolean checkActivity(String group, int activityNumber)
    {
        for (Activity activity: activities)
        {
            if(activity.getGroup().equals(group) && activity.getNumber() == activityNumber)
            {

                return true;

            } 
        } 
        return false;
    }

    //NEW
    //checks if activity is full or not
    public Activity autoEnrol(String group)
    {
        for(Activity activity: activities)
        {
            if(autoEnrolInActivity(group, activity.getNumber())== null)
            {
                //System.out.println("No available seats");
                //return null;

            }

            else
            {
                return activity;
            }
            
        }
        return null;
    }
    
    // NEW
    public boolean checkSubjectActivity(int subjectNumber, String group)
    {
        for(Activity activity: activities)
        {
            if(number == subjectNumber && activity.getGroup().equals(group))
            {
                return true;
            }
        }
        return false;
    }

    public void withdrawStudentFromActivity(Activity activity)
    {
        activity.withdrawStudent(); 
    }

    @Override
    public String toString()
    {
        return number + " " + name;
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public String printSelectedActivity()
    {        
        for (Activity activity: activities)
        {
            return activity.toString();
        } 
        return null;
    }

}