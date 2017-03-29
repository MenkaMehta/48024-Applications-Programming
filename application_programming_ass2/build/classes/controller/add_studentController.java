/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.*;
import java.text.*;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

/**
 *
 * @author 12195032
 */
public class add_studentController extends Controller<University> {

    public final University getUniversity() {
        return model;
    }

    @FXML
    private TextField studentNumberTf;
    @FXML
    private TextField studentNameTf;
    //@FXML  private RadioButton AttendanceTg;
    @FXML
    private CheckBox agreeCb;
    @FXML
    private ToggleGroup AttendanceTg;
    @FXML
    private Button AddBtn;
    @FXML
    private Text errorText;

    @FXML
    private void initialize() {
        AttendanceTg.selectedToggleProperty().addListener((o, old, now)
                -> updateButtons());
        //System.out.println("Selected Attendance: " + now));

        studentNumberTf.textProperty().addListener((o, oldText, newText) -> updateButtons());

        studentNameTf.textProperty().addListener((o, oldText, newText) -> updateButtons());
    }

    private void updateButtons() {
        // Both type and credit limit need to be valid.
        // If not, disable the Add button.
        //addBtn.setDisable(!(isTypeValid() && isCreditLimitValid()));
        AddBtn.setDisable(!(isStudentNumberValid() && isStudentNameValid() && isAttendanceValid()));
        // Note: By De Morgan's Laws, we could also have written:
        // addBtn.setDisable(!isTypeValid() || !isCreditLimitValid());
        // i.e. Disable if either the type is invalid or the credit limit is invalid.
    }

    // Make sure reduce the if statements coding to one line later.
    private boolean isStudentNumberValid() {
        /* if (!getStudentNumber().isEmpty()) {
            return true;
        } else {
            return false;
        }*/
        return (!getStudentNumber().isEmpty());
    }

    /*private boolean isTypeValid() {
		return getType().length() >= 4;
	}*/

    private boolean isStudentNameValid() {
        /* if (!getStudentName().isEmpty()) {
            return true;
        } else {
            return false;
        }*/
        return (!getStudentName().isEmpty());
    }

    private boolean isAttendanceValid() {
        /* if (getStudentAttendance() != null) {
            return true;
        } else {
            return false;
        }*/
        return (getStudentAttendance() != null);

    }

    private String getStudentNumber() {
        return studentNumberTf.getText();
    }

    private String getStudentName() {
        return studentNameTf.getText();
    }

    private String getStudentAttendance() {
        if (AttendanceTg.getSelectedToggle() == null) {
            return null;
        }
        return AttendanceTg.getSelectedToggle().getUserData().toString();
    }

    //handles the Add Button in the University Window
    @FXML
    private void handleAdd(ActionEvent event) throws Exception {
        //System.out.println("" + getUniversity().toString() + " " + getStudentNumber() + " " + getStudentName() + " " + getStudentAttendance() + " " + hasScholarship());

        try {

            errorText.setText("");
            getUniversity().addStudent(getStudentNumber(), getStudentName(), getStudentAttendance(), hasScholarship());
            stage.close();

        } catch (Exception e) {
            // System.out.println("Student already exist");
            errorText.setText("Student already exists");
            e.printStackTrace();
        }

    }
    //handles the Cancel Button in the University Window
    @FXML
    private void handleCancel(ActionEvent event) throws Exception {
        //stage.close(); closes the window.
        stage.close(); 
    }

    private boolean hasScholarship() {
        if (agreeCb.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}
