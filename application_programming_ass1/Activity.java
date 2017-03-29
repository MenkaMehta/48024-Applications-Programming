public class Activity
{
    private Subject subject;
    private String group;
    private int number;
    private String day;
    private int start;
    private int duration;
    private String room;
    private int capacity;
    private int enrolled = 0;
    public Activity(Subject subject, String group, int number, String day,int start,int duration,String room, int capacity)
    {
        this.subject = subject;
        this.group = group;
        this.number = number;
        this.day = day;
        this.start= start;
        this.duration = duration;
        this.room = room;
        this.capacity = capacity;

    }

    public Subject getSubject()
    {
        return subject;
    }

    public String getGroup()
    {
        return group;
    }

    public int getNumber()
    {
        return number;
    }
    
    //NEW
    public boolean isFull()
    {
        if(enrolled==capacity)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //NEW
    public int getCapacity()
    {
        return capacity;
    }

    //NEW
    public int getEnrolled()
    {
        return enrolled;
    }

    //NEW
    public boolean hasCapacity()
    {
        if(enrolled<capacity)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void enrolStudent()
    {
        enrolled +=1;   
    } 

    public void withdrawStudent()
    {
        enrolled -=1;
    }

    @Override
    public String toString()
    {
        //not finished enrolled/capacity
        String newStart;
        if(start<10)
        {
            newStart = "0" + start;
        }
        else
        {
            newStart = "" +start;
        }

        return subject.getNumber() + " " + group + " " + number + " " + day + " " +room + " " + newStart + ":00 "+ duration + "hrs  "+ enrolled + "/"+ capacity;
    }

    
    
}