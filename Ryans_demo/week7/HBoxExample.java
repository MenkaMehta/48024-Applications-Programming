import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.geometry.*;
public class HBoxExample extends Application {
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
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(usernameLbl, usernameTf, loginBtn, imageView);

		// Set the scene, show the stage
		stage.setScene(new Scene(hBox));
		stage.setTitle("HBox example");
		stage.show();
	}
}
