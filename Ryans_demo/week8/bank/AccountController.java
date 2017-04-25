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

public class AccountController {
	private Account account = new Account("Mr Smith");
	@FXML private TextField nameTf;
	@FXML private TextField amountTf;

	public final Account getAccount() { return account; }

	@FXML private void initialize() {
		nameTf.textProperty().bindBidirectional(getAccount().nameProperty());
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
