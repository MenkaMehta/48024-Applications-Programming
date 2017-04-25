package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import au.edu.uts.ap.javafx.*;

public class AddAccountController extends Controller<Customer> {
	public final Customer getCustomer() { return model; }

	@FXML private TextField typeTf;

	private String getType() { return typeTf.getText(); }
	private void setType(String type) { typeTf.setText(type); }

	@FXML private void handleCancel() {
		stage.close();
	}

	@FXML private void handleAdd() {
		getCustomer().addAccount(getType());
		stage.close();
	}
}
