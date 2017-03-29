package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Activity {
    //private StringProperty type = new SimpleStringProperty();
    private Subject subject;
    
    //private String group;
    private StringProperty group = new SimpleStringProperty();
    //private int number;
    private IntegerProperty number = new SimpleIntegerProperty();
    //private String day;
    private StringProperty day = new SimpleStringProperty();
    
    //private int start;
    private IntegerProperty start = new SimpleIntegerProperty();
    //private int duration;
     private IntegerProperty duration = new SimpleIntegerProperty();
    //private String room;
    private StringProperty room = new SimpleStringProperty();
    
    //private int capacity;
    private IntegerProperty capacity = new SimpleIntegerProperty();
   // private int enrolled;
    private IntegerProperty enrolled = new SimpleIntegerProperty();

    public Activity(Subject subject, String group, int number, String day, int start, int duration, String room, int capacity) {
        this.subject = subject;
        
        //this.group = group;
        this.group.set(group);
        this.number.set(number);
        this.day.set(day);
        this.start.set(start);
        this.duration.set(duration);
        this.room.set(room);
        this.capacity.set(capacity);
        //enrolled = 0;
        enrolled.set(0);
    }

    public Subject getSubject() { return subject; }
    public int getSubjectNumber() { return subject.getNumber(); }
    public IntegerProperty getSubjectNumberProperty() { return subject.numberProperty();}
    public final String getGroup() { return group.get(); }
    public StringProperty groupProperty() {return group;}
    public final int getNumber() { return number.get(); }
    public IntegerProperty numberProperty() {return number;};
    public final String getDay() { return day.get(); }
    public StringProperty dayProperty() {return day;}
    public final int getStart() { return start.get(); }
    public IntegerProperty startProperty() {return start;};
    public final int getDuration() { return duration.get(); }
    public IntegerProperty durationProperty() {return duration;};
    public final String getRoom() { return room.get(); }
    public StringProperty roomProperty() {return room;};
    public final int getCapacity() { return capacity.get(); }
    public IntegerProperty capacityProperty() {return capacity;};
    public final int getEnrolled() { return enrolled.get(); }
    public IntegerProperty enrolledProperty() {return enrolled;};
    
   
    public boolean canEnrol() {
        return enrolled.get() < capacity.get();
    }

    public void enrol() {
        enrolled.set(enrolled.get() + 1); 
    }

    public void withdraw() {
        enrolled.set(enrolled.get() - 1); 
    }

    public boolean matches(int subjectNumber, String group) {
        return subject.matches(subjectNumber) && group.equals(this.group);
    }
    
    

    @Override
    public String toString() {
        return String.format("%d %s %d %s %s %02d:00 %dhrs %d/%d", subject.getNumber(), group, number, day, room, start, duration, enrolled, capacity);
    }
}
