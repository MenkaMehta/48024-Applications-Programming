import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.image.*;

/**
 * This application demonstrates a VBox.
 */
public class VBoxExample extends Application {
	public static void main(String[] args) { launch(args); }

	private Label usernameLbl;
	private TextField usernameTf;
	private PasswordField passwordPf;
	private Button loginBtn;
	private ImageView imageView;

	@Override
	public void start(Stage stage) throws Exception {
		// Create the leaves
		usernameLbl = new Label("Username:");
		usernameTf = new TextField();
		passwordPf = new PasswordField();
		loginBtn = new Button("Login");
		imageView = new ImageView("flower.png");

		// Create a branch
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(usernameLbl, usernameTf, passwordPf, loginBtn, imageView);

		// Set the scene, show the stage
		stage.setScene(new Scene(vBox));
		stage.setTitle("VBox example");
		stage.show();
	}
}
