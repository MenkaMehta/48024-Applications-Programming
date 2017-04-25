import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.fxml.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ControlsApplication extends Application {
	@Override public void start(Stage stage) throws Exception {
		Customer customer = new Customer("Mr Smith");
		customer.addAccount("Savings");
		customer.addAccount("Credit");
		customer.addAccount("Loan");
		ViewLoader.showStage(customer, "/controls.fxml", "Controls", stage);
	}
}
