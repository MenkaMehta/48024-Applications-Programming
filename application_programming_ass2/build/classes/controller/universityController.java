/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.*;

/**
 *
 * @author 12195032
 */
public class universityController extends Controller<University> {

    @FXML
    private ListView<Student> studentsLv;
    @FXML
    private Button loginBtn;
    @FXML
    private Button removeBtn;

    @FXML
    private void initialize() {
        //Enables the login button after student selection in the listview
        studentsLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> loginBtn.setDisable(newSubject == null)
        );

        studentsLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> removeBtn.setDisable(newSubject == null)
        );
    }

    public final University getUniversity() {
        return model;
    }

    private Student getSelectedStudent() {
        return studentsLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleAddStudent(ActionEvent event) throws Exception {

        ViewLoader.showStage(getUniversity(), "/view/add_student.fxml", "Add Student", new Stage());

    }

    @FXML
    private void handleRemoveStudent(ActionEvent event) throws Exception {
        Student student = getSelectedStudent();
        if (student != null) {
            //do something
            for (Activity activity : student.getActivities()) {
                activity.withdraw();
            }
            getUniversity().remove(student);

        }

    }

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        Student student = getSelectedStudent();
        if (student != null) {
            // System.out.println("You selected: " + student);
            ViewLoader.showStage(student, "/view/student.fxml", "Student", new Stage());
        }
    }

}
