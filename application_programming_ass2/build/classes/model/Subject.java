package model;

import java.util.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Subject {

    //private int number;
    private IntegerProperty number = new SimpleIntegerProperty();
    private String name;
    private ObservableList<Activity> activities = FXCollections.observableArrayList();

    public Subject(int number, String name) {
        this.number.set(number);
        this.name = name;
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    ;

    public int getNumber() {
        return number.get();
    }

    public ObservableList<Activity> getActivities() {
        return activities;
    }

    public void addActivity(String group, int number, String day, int start, int duration, String room, int capacity) {
        activities.add(new Activity(this, group, number, day, start, duration, room, capacity));
    }

    public boolean matches(int number) {
        return this.number.get() == number;
    }

    @Override
    public String toString() {
        return number.get() + " " + name;
    }
}
