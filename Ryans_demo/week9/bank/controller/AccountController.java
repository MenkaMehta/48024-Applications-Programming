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

public class AccountController extends Controller<Account> {
	@FXML private Text typeTxt;
	@FXML private Text balanceTxt;
	@FXML private TextField amountTf;

	public final Account getAccount() { return model; }

	@FXML private void initialize() {
		typeTxt.textProperty().bindBidirectional(getAccount().typeProperty());
		balanceTxt.textProperty().bind(getAccount().balanceProperty().asString("$%.2f"));
	}

	@FXML private void handleDeposit(ActionEvent event) {
		getAccount().deposit(getAmount());
		setAmount(0);
	}

	@FXML private void handleWithdraw(ActionEvent event) {
		getAccount().withdraw(getAmount());
		setAmount(0);
	}

	private double getAmount() {
		return Double.parseDouble(amountTf.getText());
	}

	private void setAmount(double value) {
		amountTf.setText(new DecimalFormat("###,##0.00").format(value));
	}
}
