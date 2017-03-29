import java.util.*;

public class Student
{
    private String number;
    private String name;
    private LinkedList<Activity> activities = new LinkedList<Activity>();
    public Student(String number, String name)
    {
        this.number = number;
        this.name =name;
    }

    public boolean hasNumber(String number)
    {
        return number.equals(this.number);
    }

    public String getNumber() 
    {
        return number;
    }

    public void addEnrolledActivityToList(Activity activity)
    {
        activities.add(activity); 
    }

    public void viewEnrolledActivity()
    {        
        for (Activity activity: activities)
        {
            System.out.println(activity);
        }
    }       

    public void removeEnrolledActivity(Activity activity)
    {
        activities.remove(activity);
    }

    public Activity hasCmp1(Subject subject)
    {
        Activity toReturn = null;
        for (Activity activity: activities)
        {
            if (activity.getSubject() == subject && activity.getGroup().equals("Cmp1"))
            {
                toReturn =  activity;         
            }
        }
        return toReturn;
    }

    //NEW
    public Activity hasSubjectGroup(Subject subject, String group)
    {
        Activity hasSubGroup = null;
        for (Activity activity: activities)
        {
            if (activity.getSubject() == subject && activity.getGroup().equals(group))
            {
                hasSubGroup = activity;
            }
        }
        return hasSubGroup;

    }

    @Override
    public String toString()
    {
        return  number + " " + name ;
    }
    
     public void removeEnrolled()
    {
        for(Activity activity: activities)
        {
        activity.withdrawStudent();
        }
    }

    /*public void selectSubject()
    { 
    System.out.println("");

    }*/

}