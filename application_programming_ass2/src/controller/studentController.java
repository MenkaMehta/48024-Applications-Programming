/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import model.Activity;
import model.Student;
import model.Subject;
import model.University;

/**
 *
 * @author 12195032
 */
public class studentController extends Controller<Student> {

    @FXML
    private ComboBox<Subject> subjectCmb;
    @FXML
    private Button enrolBtn;
    @FXML
    private Button withdrawBtn;
    @FXML
    private TableView<Activity> activitiesTv;
    @FXML
    private TableView<Activity> activitiesTv2;
    @FXML
    private TextField studentNameTf;
    @FXML
    private ToggleGroup AttendanceTg;

    //NEW
    @FXML
    private TableColumn<Activity, String> subjectClm2;
    @FXML
    private TableColumn<Activity, String> groupClm2;
    @FXML
    private TableColumn<Activity, String> activitiesClm2;
    @FXML
    private TableColumn<Activity, String> dayClm2;
    @FXML
    private TableColumn<Activity, String> startClm2;
    @FXML
    private TableColumn<Activity, String> durationClm2;
    @FXML
    private TableColumn<Activity, String> roomClm2;
    @FXML
    private TableColumn<Activity, String> capacityClm2;
    @FXML
    private TableColumn<Activity, String> enrolledClm2;
    @FXML
    private Text scholarshipStatus;
    @FXML
    private Text attendanceStatus;
   
    public final Student getStudent() {
        return model;
    }

    @FXML
    private void initialize() {

        activitiesClm2.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asString());
        subjectClm2.setCellValueFactory(cellData -> cellData.getValue().getSubjectNumberProperty().asString());
        groupClm2.setCellValueFactory(cellData -> cellData.getValue().groupProperty());
        dayClm2.setCellValueFactory(cellData -> cellData.getValue().dayProperty());
        startClm2.setCellValueFactory(cellData -> cellData.getValue().startProperty().asString());
        durationClm2.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asString());
        roomClm2.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
        capacityClm2.setCellValueFactory(cellData -> cellData.getValue().capacityProperty().asString());
        enrolledClm2.setCellValueFactory(cellData -> cellData.getValue().enrolledProperty().asString());
        //activitiesTv2.setItems(getStudent().getUniversity().getSubjects().get(0).getActivities());
        activitiesTv.setItems(getStudent().getActivities());
        //studentNameTf.textProperty().bind(getName().nameProperty());


        activitiesTv2.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> updateEnrolBtn()
        );

        activitiesTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> withdrawBtn.setDisable(newSubject == null)
        );
        
        // The if else statement below sets scholarship to "yes" or "No"
        if (getStudent().getScholarship() == true) {
            scholarshipStatus.setText("Yes");
        } else {
            scholarshipStatus.setText("No");
        }
        // The if statement below uses the userdata and sets Text to "Full Time" or "Part Time"
        if(getStudent().getAttendance().equals ("ft"))
        {
            attendanceStatus.setText("Full Time");
        }
        else if(getStudent().getAttendance().equals ("pt"))
        {
            attendanceStatus.setText("Part Time");
        }
        
      
    }
    //NEW

    private void updateEnrolBtn() {
        // System.out.println("test");
        Activity activity = getSelectedActivity();
        if (!activity.canEnrol()) {
            // System.out.println("can't enrol");
            
            enrolBtn.setDisable(true);
            
        } else {
            // System.out.println("can enrol");
            enrolBtn.setDisable(false);
            
          
        }
        
    }
    



    @FXML
    private void handleWithdraw(ActionEvent event) {
        Activity activity = activitiesTv.getSelectionModel().getSelectedItem();
        getStudent().withdraw(activity);
        withdrawBtn.setDisable(true);
        activitiesTv.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void handleEnrol(ActionEvent event) {
        //The Enrol button is enabled when activity is selected and 
        //there is available seat in that activity and the student isn't enrolled in that activity. 
        Activity activity = activitiesTv2.getSelectionModel().getSelectedItem();
        getStudent().enrol(activity);
        enrolBtn.setDisable(true);
        activitiesTv2.getSelectionModel().clearSelection();
         
         
        
    }

    @FXML
    private void handleSelectSubject(ActionEvent event) {
        //activitiesTv2.getSelectionModel().getSelectedItem();
        Subject subject = subjectCmb.getValue();

        activitiesTv2.setItems(subject.getActivities());
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        stage.close();

    }

    private Activity getSelectedActivity() {
        return activitiesTv2.getSelectionModel().getSelectedItem();
    }

}
