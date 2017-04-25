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

public class CustomerController extends Controller<Customer> {
	@FXML private ListView<Account> accountsLv;
	@FXML private Button viewAccountBtn;

	@FXML private void initialize() {
		accountsLv.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldSubject, newSubject) -> viewAccountBtn.setDisable(newSubject == null)
				);
	}

	public final Customer getCustomer() {
		return model;
	}

	private Account getSelectedAccount() {
		return accountsLv.getSelectionModel().getSelectedItem();
	}

	@FXML private void handleViewAccount(ActionEvent event) throws Exception {
		Account account = getSelectedAccount();
		if (account != null) {
			ViewLoader.showStage(account, "/view/account.fxml", "Account", new Stage());
		}
	}

	@FXML private void handleAddAccount(ActionEvent event) throws Exception {
		ViewLoader.showStage(getCustomer(), "/view/add_account.fxml", "Add Account", new Stage());
	}
}
