import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

/**
 * This application allows the user to increment a number via a button.
 */
public class IncApplication extends Application {
	public static void main(String[] args) { launch(args); }

	private Label valueLbl;
	private TextField valueTf;
	private Button incBtn;

	@Override
	public void start(Stage stage) {
		// Create the leaves
		valueLbl = new Label("Value");
		valueTf = new TextField();
		incBtn = new Button("+1");

		// Add the leaves to a branch
		HBox box = new HBox(8, valueLbl, valueTf, incBtn);
		box.setAlignment(Pos.CENTER);
		// Two other ways to add leaves:
		// 1.
		// box.getChildren().addAll(valueLbl, valueTf, incBtn);
		// 2.
		// box.getChildren().add(valueLbl);
		// box.getChildren().add(valueTf);
		// box.getChildren().add(incBtn);

		// Set the event handlers
		incBtn.setOnAction(event -> {
			int oldValue = getValue();
			int newValue = oldValue + 1;
			setValue(newValue);
		});
		// Alternatively:
		//incBtn.setOnAction(event -> setValue(getValue() + 1));

		// Set the scene, show the stage
		stage.setScene(new Scene(box));
		stage.setTitle("Incrementer");
		stage.show();
	}

	private int getValue() {
		return Integer.parseInt(valueTf.getText());
	}

	private void setValue(int value) {
		valueTf.setText(String.valueOf(value));
	}
}
