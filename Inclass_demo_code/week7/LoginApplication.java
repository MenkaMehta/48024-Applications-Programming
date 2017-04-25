import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

/**
 * This application shows a login form. It does not handle button clicks.
 */
public class LoginApplication extends Application {
	public static void main(String[] args) { launch(args); }

	private Label usernameLbl;
	private Label passwordLbl;
	private TextField usernameTf;
	private PasswordField passwordPf;
	private Button loginBtn;

	@Override
	public void start(Stage stage) throws Exception {
		// Create the leaves
		usernameLbl = new Label("Username:");
		passwordLbl = new Label("Password:");
		usernameTf = new TextField();
		passwordPf = new PasswordField();
		loginBtn = new Button("Login");

		// Create a branch
		GridPane gridPane = new GridPane();
		gridPane.add(usernameLbl, 0, 0);
		gridPane.add(passwordLbl, 0, 1);
		gridPane.add(usernameTf, 1, 0);
		gridPane.add(passwordPf, 1, 1);
		gridPane.add(loginBtn, 1, 2);

		// Set the scene, show the stage
		stage.setScene(new Scene(gridPane));
		stage.setTitle("Login");
		stage.show();
	}
}
